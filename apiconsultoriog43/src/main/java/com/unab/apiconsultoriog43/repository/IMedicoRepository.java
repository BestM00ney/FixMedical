package com.unab.apiconsultoriog43.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unab.apiconsultoriog43.models.entidades.MedicoEntity;

@Repository
public interface IMedicoRepository extends CrudRepository<MedicoEntity, Long>{

    public MedicoEntity findById(long id);    
}
