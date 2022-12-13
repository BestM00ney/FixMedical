package com.unab.apiconsultoriog43.models.dto;

import java.io.Serializable;
import java.util.List;

public class MedicoDto implements Serializable{
    
    private static final long serialVersionUID=1L;

    private Long id;
    private String nombreMedico;
    private String emailMedico;
    private String celularMedico;
    private String especialidadMedico;
    private List<CitaDto> CitaDtoList;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreMedico() {
        return this.nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public String getEmailMedico() {
        return this.emailMedico;
    }

    public void setEmailMedico(String emailMedico) {
        this.emailMedico = emailMedico;
    }

    public String getCelularMedico() {
        return this.celularMedico;
    }

    public void setCelularMedico(String celularMedico) {
        this.celularMedico = celularMedico;
    }

    public String getEspecialidadMedico() {
        return this.especialidadMedico;
    }

    public void setEspecialidadMedico(String especialidadMedico) {
        this.especialidadMedico = especialidadMedico;
    }

    public List<CitaDto> getCitaDtoList() {
        return this.CitaDtoList;
    }

    public void setCitaDtoList(List<CitaDto> CitaDtoList) {
        this.CitaDtoList = CitaDtoList;
    }

}
