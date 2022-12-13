package com.unab.apiconsultoriog43.security;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.unab.apiconsultoriog43.services.IPacienteService;

//activar el tema de seguridad web
@EnableWebSecurity
//Extender de clase de configuración web
public class ConfiguracionSecurity extends WebSecurityConfigurerAdapter{
    
    //Este es como el controlador de la libreria debemos llamar una instancia de la clase Paciente
    private final IPacienteService iPacienteService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    //creamos constructori con las clases finales.
    public ConfiguracionSecurity(IPacienteService iPacienteService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.iPacienteService = iPacienteService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    //activar los endpoint publicos, sin autenticación. para eso es el metodo configure HHTP
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        //activar CORS para recibir conexiones desde cualquier IP para que funcione el cliente
        .cors()
        .and()
        //desactivar protección contra Cross
        .csrf().disable()
        //autorizamos las peticiones o requetiemientos o endpoints.
        .authorizeRequests()
        //Aqui van los enpoint a visualizar sin necesidad de Loguearse o tener token.
        .antMatchers(HttpMethod.POST, "/paciente").permitAll()
        .antMatchers(HttpMethod.GET, "/cita").permitAll()
        .antMatchers(HttpMethod.GET, "/cita/{id}").permitAll()
        //Los demás endpoint si van a tener seguridad.
        .anyRequest().authenticated()
        .and()
        .addFilter(new PacienteAutenticacion(authenticationManager()))
        .addFilter(new TokenAutorizacion(authenticationManager()))
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);        
    }

    //crear metodo config de autenticacion
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(iPacienteService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Bean
	CorsConfigurationSource corsConfigurationSource(){
		CorsConfiguration configuration= new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("*"));
		configuration.setAllowedHeaders(Arrays.asList("*"));
		configuration.setAllowedMethods(Arrays.asList("*"));

		UrlBasedCorsConfigurationSource source= new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);

		return source;
	}
}
