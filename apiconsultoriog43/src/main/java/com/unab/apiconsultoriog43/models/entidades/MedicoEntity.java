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

@Entity(name="medico")
@Table(indexes = {
    @Index(columnList = "id", name = "index_id", unique = true),
})
public class MedicoEntity implements Serializable {
    
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 50)
    private String nombreMedico;

    @Column(nullable = false, length = 50)
    private String emailMedico;

    @Column(nullable = false, length = 50)
    private String celularMedico;

    @Column(nullable = false, length = 50)
    private String especialidadMedico;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicoEntity")
    private List<CitaEntity> citaEntityList= new ArrayList<>();
    


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
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

    public List<CitaEntity> getCitaEntityList() {
        return this.citaEntityList;
    }

    public void setCitaEntityList(List<CitaEntity> citaEntityList) {
        this.citaEntityList = citaEntityList;
    }
    



}
