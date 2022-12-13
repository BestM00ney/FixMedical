package com.unab.apiconsultoriog43.controllers;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unab.apiconsultoriog43.models.dto.CitaDto;
import com.unab.apiconsultoriog43.models.dto.PacienteDto;
import com.unab.apiconsultoriog43.models.peticiones.PacienteCrearReqModel;
import com.unab.apiconsultoriog43.models.respuestas.CitaDataResModel;
import com.unab.apiconsultoriog43.models.respuestas.PacienteDataResModel;
import com.unab.apiconsultoriog43.services.IPacienteService;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IPacienteService iPacienteService;

    @PostMapping
    public PacienteDataResModel crearPaciente(@RequestBody PacienteCrearReqModel pacienteCrearReqMode){

        PacienteDto pacienteDto= modelMapper.map(pacienteCrearReqMode, PacienteDto.class);

        PacienteDto pacienteDtoCreado= iPacienteService.crearPaciente(pacienteDto);

        PacienteDataResModel pacienteDataResModel= modelMapper.map(pacienteDtoCreado,PacienteDataResModel.class);

        return pacienteDataResModel;

    }

    @GetMapping
    public PacienteDataResModel leerPaciente(){
        //autenticacion SpringBootSecurity
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        
        String username = authentication.getPrincipal().toString();
        //String username = "ustorms";

        PacienteDto pacienteDto= iPacienteService.leerPaciente(username);

        PacienteDataResModel pacienteDataResModel= modelMapper.map(pacienteDto,PacienteDataResModel.class);

        return pacienteDataResModel;
    }

    
    @GetMapping(path = "/miscitas")
    public List<CitaDataResModel> leerMiscitas(){

        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        
        String username = authentication.getPrincipal().toString();
        //Debo estar logueado
        //String username= "ustorms";
        //leer partidos pos usuario y guardarlos en una lista
        //Aqui puede estar el error
        //List<CitaDto> citaDtoList = iCitaService.leerCitas();
        List<CitaDto> citaDtoList = iPacienteService.leerMiscitas(username);

        List<CitaDataResModel> citaDataResModelList= new ArrayList<>();

        for (CitaDto citaDto : citaDtoList) {
            CitaDataResModel citaDataResModel= modelMapper.map(citaDto, CitaDataResModel.class);
            citaDataResModelList.add(citaDataResModel);            
        }

        return citaDataResModelList;
    }


}
