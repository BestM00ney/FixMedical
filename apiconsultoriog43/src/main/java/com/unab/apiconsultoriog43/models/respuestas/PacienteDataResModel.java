package com.unab.apiconsultoriog43.models.respuestas;

import java.util.List;

public class PacienteDataResModel {
    
    private Long id;
    private String idPaciente;
    private String cedulaPaciente;
    private String nombrePaciente;
    private String emailPaciente;
    private String celularPaciente;
    private String direccionPaciente;
    private String usernamePaciente;
    private List<CitaDataResModel> CitaDataResModelList;



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
    
    public List<CitaDataResModel> getCitaDataResModelList() {
        return this.CitaDataResModelList;
    }

    public void setCitaDataResModelList(List<CitaDataResModel> CitaDataResModelList) {
        this.CitaDataResModelList = CitaDataResModelList;
    }



}
