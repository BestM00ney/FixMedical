package com.unab.apiconsultoriog43.models.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "cita")
@Table(indexes = {
    @Index(columnList = "idCita", name = "index_idCita", unique = true)
})
public class CitaEntity implements Serializable{
    
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String idCita;

    @Column(name = "fecha_cita", nullable = false)
	private LocalDate fechaCita;

	@Column(name = "hora_cita", nullable = false)
	private LocalTime horaCita;

    @Column(nullable = false, length = 20)
    private Integer consultorioCita;

    @Column(nullable = false, length = 20)
    private String estadoCita;

    @ManyToOne
    @JoinColumn(name="id_paciente")
    private PacienteEntity pacienteEntity;

    @ManyToOne
    @JoinColumn(name="id_medico")
    private MedicoEntity medicoEntity;


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

    public PacienteEntity getPacienteEntity() {
        return this.pacienteEntity;
    }

    public void setPacienteEntity(PacienteEntity pacienteEntity) {
        this.pacienteEntity = pacienteEntity;
    }

    public MedicoEntity getMedicoEntity() {
        return this.medicoEntity;
    }

    public void setMedicoEntity(MedicoEntity medicoEntity) {
        this.medicoEntity = medicoEntity;
    }

    

}
