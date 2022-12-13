package com.unab.apiconsultoriog43.models.peticiones;

import java.time.LocalDate;
import java.time.LocalTime;

public class CitaCrearReqModel {
    
	private LocalDate fechaCita;	
	private LocalTime horaCita;
    private Integer consultorioCita;    
    private String estadoCita;
    private long medico;


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

    public long getMedico() {
        return this.medico;
    }

    public void setMedico(long medico) {
        this.medico = medico;
    }




}
