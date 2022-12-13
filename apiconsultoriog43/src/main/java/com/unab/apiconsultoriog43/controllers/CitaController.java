package com.unab.apiconsultoriog43.controllers;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unab.apiconsultoriog43.models.dto.CitaDto;
import com.unab.apiconsultoriog43.models.dto.PacienteDto;
import com.unab.apiconsultoriog43.models.peticiones.CitaCrearReqModel;
import com.unab.apiconsultoriog43.models.respuestas.CitaDataResModel;
import com.unab.apiconsultoriog43.models.respuestas.MensajeResModel;
import com.unab.apiconsultoriog43.services.ICitaService;
import com.unab.apiconsultoriog43.services.IPacienteService;

@RestController
@RequestMapping("/cita")
public class CitaController {
    
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ICitaService iCitaService;

    @Autowired
    IPacienteService iPacienteService;

    @PostMapping
    public CitaDataResModel crearCita(@RequestBody CitaCrearReqModel citaCrearReqModel){

        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        
        String username = authentication.getPrincipal().toString();

        CitaDto citaDto = modelMapper.map(citaCrearReqModel,CitaDto.class);
        citaDto.setUsername(username);
        CitaDto citaDtoCreado= iCitaService.crearCita(citaDto);
        CitaDataResModel citaDataResModel= modelMapper.map(citaDtoCreado,CitaDataResModel.class);
        return citaDataResModel;

    }

    @GetMapping
    public List<CitaDataResModel> leerCitas(){

        List<CitaDto> citaDtoList = iCitaService.leerCitas();

        List<CitaDataResModel> citaDataResModelList= new ArrayList<>();

        for (CitaDto citaDto : citaDtoList) {
            CitaDataResModel citaDataResModel= modelMapper.map(citaDto, CitaDataResModel.class);
            citaDataResModelList.add(citaDataResModel);            
        }

        return citaDataResModelList;

    }

    @GetMapping(path = "/{id}")
    public CitaDataResModel detalleCita(@PathVariable String id){

        CitaDto citaDto= iCitaService.detalleCita(id);

        CitaDataResModel citaDataResModel= modelMapper.map(citaDto,CitaDataResModel.class);

        return citaDataResModel;

    }

    @PutMapping(path = "/{id}")
    public CitaDataResModel actualizarCita(@PathVariable String id, 
                                           @RequestBody CitaCrearReqModel citaCrearReqModel){
    
    Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        
    String username = authentication.getPrincipal().toString();

    CitaDto citaDto= modelMapper.map(citaCrearReqModel,CitaDto.class);
    citaDto.setUsername(username);

    CitaDto citaDtoActualizado= iCitaService.actualizarCita(id, citaDto);

    CitaDataResModel citaDataResModelActualizado = modelMapper.map(citaDtoActualizado,CitaDataResModel.class);

    return citaDataResModelActualizado;
    }

    @DeleteMapping(path = "/{id}")
    public MensajeResModel eliminarCita(@PathVariable String id){
        
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        
        String username = authentication.getPrincipal().toString();

        PacienteDto pacienteDto= iPacienteService.leerPaciente(username);

        iCitaService.eliminarCita(id, pacienteDto.getId());
        
        MensajeResModel mensajeResModel= new MensajeResModel();
        mensajeResModel.setNombre("Eliminar");
        mensajeResModel.setResultado("Cita eliminado con exito");

        return mensajeResModel;

    }

}
