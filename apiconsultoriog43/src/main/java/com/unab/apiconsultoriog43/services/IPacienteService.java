package com.unab.apiconsultoriog43.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.unab.apiconsultoriog43.models.dto.CitaDto;
import com.unab.apiconsultoriog43.models.dto.PacienteDto;

//Extendemos la clase de login
public interface IPacienteService extends UserDetailsService{

    public PacienteDto crearPaciente(PacienteDto pacienteDto);

    public PacienteDto leerPaciente(String username);
    
    public List<CitaDto> leerMiscitas(String username);
}
