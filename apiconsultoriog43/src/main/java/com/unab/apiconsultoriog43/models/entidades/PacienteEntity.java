package com.unab.apiconsultoriog43.models.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "paciente")
@Table(indexes = {
    @Index(columnList = "idPaciente", name = "index_idPaciente", unique = true),
    @Index(columnList = "emailPaciente", name = "index_emailPaciente", unique = true),
    @Index(columnList = "usernamePaciente", name = "index_usernamePaciente", unique = true)
})
public class PacienteEntity implements Serializable{

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String idPaciente;

    @Column(nullable = false, length = 10)
    private String cedulaPaciente;

    @Column(nullable = false, length = 100)
    private String nombrePaciente;

    @Column(nullable = false, length = 50)
    private String emailPaciente;

    @Column(nullable = false, length = 13)
    private String celularPaciente;

    @Column(nullable = false, length = 50)
    private String direccionPaciente;

    @Column(nullable = false, length = 15)
    private String usernamePaciente;

    @Column(nullable = false)
    private String passwordEncriptada;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacienteEntity")
    private List<CitaEntity> citaEntityList= new ArrayList<>();


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
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


    public String getPasswordEncriptada() {
        return this.passwordEncriptada;
    }

    public void setPasswordEncriptada(String passwordEncriptada) {
        this.passwordEncriptada = passwordEncriptada;
    }

    public List<CitaEntity> getCitaEntityList() {
        return this.citaEntityList;
    }

    public void setCitaEntityList(List<CitaEntity> citaEntityList) {
        this.citaEntityList = citaEntityList;
    }




    
}
