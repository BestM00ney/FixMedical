package com.unab.apiconsultoriog43.models.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PacienteDto implements Serializable{  

    private static final long serialVersionUID=1L;

    private Long id;
    private String idPaciente;
    private String cedulaPaciente;
    private String nombrePaciente;
    private String emailPaciente;
    private String celularPaciente;
    private String direccionPaciente;
    private String usernamePaciente;
    private String password;
    private String passwordEncriptada;
    private List<CitaDto> CitaDtoList= new ArrayList<>();


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdPaciente() {
        return this.idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getCedulaPaciente() {
        return this.cedulaPaciente;
    }

    public void setCedulaPaciente(String cedulaPaciente) {
        this.cedulaPaciente = cedulaPaciente;
    }

    public String getNombrePaciente() {
        return this.nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getEmailPaciente() {
        return this.emailPaciente;
    }

    public void setEmailPaciente(String emailPaciente) {
        this.emailPaciente = emailPaciente;
    }

    public String getCelularPaciente() {
        return this.celularPaciente;
    }

    public void setCelularPaciente(String celularPaciente) {
        this.celularPaciente = celularPaciente;
    }

    public String getDireccionPaciente() {
        return this.direccionPaciente;
    }

    public void setDireccionPaciente(String direccionPaciente) {
        this.direccionPaciente = direccionPaciente;
    }

    public String getUsernamePaciente() {
        return this.usernamePaciente;
    }

    public void setUsernamePaciente(String usernamePaciente) {
        this.usernamePaciente = usernamePaciente;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getPasswordEncriptada() {
        return this.passwordEncriptada;
    }

    public void setPasswordEncriptada(String passwordEncriptada) {
        this.passwordEncriptada = passwordEncriptada;
    }


    public List<CitaDto> getCitaDtoList() {
        return this.CitaDtoList;
    }

    public void setCitaDtoList(List<CitaDto> CitaDtoList) {
        this.CitaDtoList = CitaDtoList;
    }


}
