package com.unab.apiconsultoriog43.models.peticiones;

public class PacienteCrearReqModel {
    private String cedulaPaciente;
    private String nombrePaciente;
    private String emailPaciente;
    private String celularPaciente;
    private String direccionPaciente;
    private String usernamePaciente;
    private String password;


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

}
