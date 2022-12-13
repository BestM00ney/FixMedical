package com.unab.apiconsultoriog43.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unab.apiconsultoriog43.models.entidades.PacienteEntity;

@Repository
public interface IPacienteRepository extends CrudRepository<PacienteEntity, Long>{
    public PacienteEntity findByEmailPaciente(String email);
    public PacienteEntity findByUsernamePaciente(String username);
    
}
