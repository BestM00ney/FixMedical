package com.unab.apiconsultoriog43.models.respuestas;

import java.time.LocalDate;
import java.time.LocalTime;

public class CitaDataResModel {
    private long id;
    private String idCita;
    private LocalDate fechaCita;	
	private LocalTime horaCita;    
    private Integer consultorioCita;    
    private String estadoCita;
    private PacienteDataResModel pacienteEntity;
    private MedicoDataResModel medicoEntity;


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdCita() {
        return this.idCita;
    }

    public void setIdCita(String idCita) {
        this.idCita = idCita;
    }

    public LocalDate getFechaCita() {
        return this.fechaCita;
    }

    public void setFechaCita(LocalDate fechaCita) {
        this.fechaCita = fechaCita;
    }

    public LocalTime getHoraCita() {
        return this.horaCita;
    }

    public void setHoraCita(LocalTime horaCita) {
        this.horaCita = horaCita;
    }

    public Integer getConsultorioCita() {
        return this.consultorioCita;
    }

    public void setConsultorioCita(Integer consultorioCita) {
        this.consultorioCita = consultorioCita;
    }

    public String getEstadoCita() {
        return this.estadoCita;
    }

    public void setEstadoCita(String estadoCita) {
        this.estadoCita = estadoCita;
    }

    public PacienteDataResModel getPacienteEntity() {
        return this.pacienteEntity;
    }

    public void setPacienteEntity(PacienteDataResModel pacienteEntity) {
        this.pacienteEntity = pacienteEntity;
    }

    public MedicoDataResModel getMedicoEntity() {
        return this.medicoEntity;
    }

    public void setMedicoEntity(MedicoDataResModel medicoEntity) {
        this.medicoEntity = medicoEntity;
    }

    

}


