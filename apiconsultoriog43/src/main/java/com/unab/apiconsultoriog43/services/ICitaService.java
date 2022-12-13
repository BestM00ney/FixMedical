package com.unab.apiconsultoriog43.services;

import java.util.List;

import com.unab.apiconsultoriog43.models.dto.CitaDto;

public interface ICitaService {

    public CitaDto crearCita(CitaDto citaDto);

    public List<CitaDto> leerCitas();

    public CitaDto detalleCita(String idCita);

    public CitaDto actualizarCita(String idCita, CitaDto citaDto);

    public void eliminarCita(String idCita, Long pacienteEntityId);
   
}
