package com.unab.apiconsultoriog43;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.unab.apiconsultoriog43.utils.AppContexto;

//Excluir configuración de base de datos
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//Excluir la seguridad para encriptar la password y poder encriptar la pass
//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@SpringBootApplication
@EnableJpaAuditing
public class Apiconsultoriog43Application {

	public static void main(String[] args) {
		SpringApplication.run(Apiconsultoriog43Application.class, args);
		System.out.println("Api corriendo ...");

		// //Esta linea genera una clave para el token
		// SecretKey key= Keys.secretKeyFor(SignatureAlgorithm.HS512);
		// //decodificar clave para verla en consola
		// String base64key= Encoders.BASE64.encode(key.getEncoded());
		// //mostrar clave en consola despues de API corriendo para copiarla para luego usarla.
		// System.out.println(base64key);

	}

	@Bean
    public ModelMapper modelmapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

    @Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AppContexto appContexto(){
		return new AppContexto();
	}
}
