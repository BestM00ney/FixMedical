package com.unab.apiconsultoriog43.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unab.apiconsultoriog43.models.dto.PacienteDto;
import com.unab.apiconsultoriog43.models.peticiones.PacienteSignupReqModel;
import com.unab.apiconsultoriog43.services.IPacienteService;
import com.unab.apiconsultoriog43.utils.AppContexto;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;


public class PacienteAutenticacion extends UsernamePasswordAuthenticationFilter{

    private final AuthenticationManager authenticationManager;


    public PacienteAutenticacion(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        
                try {
                    PacienteSignupReqModel pacienteSignupReqModel= new ObjectMapper().readValue(request.getInputStream(), PacienteSignupReqModel.class);

                    UsernamePasswordAuthenticationToken upat= new UsernamePasswordAuthenticationToken(pacienteSignupReqModel.getUsername(), pacienteSignupReqModel.getPassword(), new ArrayList<>());

                    Authentication authentication= authenticationManager.authenticate(upat);

                    return authentication;

                } catch (IOException e) {
                    //Usar IOException Java.IO para que no genere error la primera linea del Try-Catch
                    throw new RuntimeException(e);
                }

        
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {
        
                String username= ((User)authResult.getPrincipal()).getUsername();

                SecretKey key= Keys.hmacShaKeyFor(Decoders.BASE64.decode(ConstantesSecurity.TOKEN_SECRETO));

                String token= Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis()+ConstantesSecurity.FECHA_EXPIRACION))
                .signWith(key)
                .compact();

                IPacienteService iPacienteService= (IPacienteService) AppContexto.getBean("pacienteService");
                PacienteDto pacienteDto = iPacienteService.leerPaciente(username);

                response.addHeader("Access-Control-Expose-Headers", "Authorization, IdUsuario");
                response.addHeader("IdUsuario", pacienteDto.getIdPaciente());
                response.addHeader(ConstantesSecurity.HEADER_STRING, ConstantesSecurity.TOKEN_PREFIJO + token);

        //super.successfulAuthentication(request, response, chain, authResult);
    }
    
}
