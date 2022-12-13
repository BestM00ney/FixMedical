package com.unab.apiconsultoriog43.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unab.apiconsultoriog43.models.entidades.CitaEntity;

@Repository
public interface ICitaRepository extends PagingAndSortingRepository<CitaEntity, Long>{
    //Obtiene la lista de Partidos por id de usuario ordenado por fecha de creación den orden descendente
    
    //Esto es para leer los partidos por Id de paciente
    //List<CitaEntity> getByPacienteEntityIdOrderByIdDesc(long pacienteEntityId);

    @Query("SELECT c FROM cita c WHERE id_paciente = :id")
    List<CitaEntity> misCitas(@Param("id") Long id);
    
    //Esta consulta es para mostrar todas las citas medicas
    @Query(nativeQuery = true, value = "SELECT * FROM cita ORDER BY Id ASC ")
    List<CitaEntity> citasCreadas();

    CitaEntity findByIdCita(String id);
}
