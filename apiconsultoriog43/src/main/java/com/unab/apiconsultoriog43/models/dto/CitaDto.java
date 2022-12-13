package com.unab.apiconsultoriog43.models.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class CitaDto implements Serializable{

    private static final long serialVersionUID=1L;
    
    private long id;
    private String idCita;
    private String username;
    private LocalDate fechaCita;
	private LocalTime horaCita;
    private long medico;
    private Integer consultorioCita;    
    private String estadoCita;
    private PacienteDto pacienteEntity;
    private MedicoDto medicoEntity;



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

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public long getMedico() {
        return this.medico;
    }

    public void setMedico(long medico) {
        this.medico = medico;
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

    public PacienteDto getPacienteEntity() {
        return this.pacienteEntity;
    }

    public void setPacienteEntity(PacienteDto pacienteEntity) {
        this.pacienteEntity = pacienteEntity;
    }

    public MedicoDto getMedicoEntity() {
        return this.medicoEntity;
    }

    public void setMedicoEntity(MedicoDto medicoEntity) {
        this.medicoEntity = medicoEntity;
    }
    
    

}
