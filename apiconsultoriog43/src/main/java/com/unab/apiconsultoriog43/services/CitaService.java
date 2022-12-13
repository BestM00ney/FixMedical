package com.unab.apiconsultoriog43.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.apiconsultoriog43.models.dto.CitaDto;
import com.unab.apiconsultoriog43.models.entidades.CitaEntity;
import com.unab.apiconsultoriog43.models.entidades.MedicoEntity;
import com.unab.apiconsultoriog43.models.entidades.PacienteEntity;
import com.unab.apiconsultoriog43.repository.ICitaRepository;
import com.unab.apiconsultoriog43.repository.IMedicoRepository;
import com.unab.apiconsultoriog43.repository.IPacienteRepository;

@Service
public class CitaService implements ICitaService{

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ICitaRepository iCitaRepository;

    @Autowired
    IPacienteRepository iPacienteRepository;

    @Autowired
    IMedicoRepository iMedicoRepository;

    @Override
    public CitaDto crearCita(CitaDto citaDto) {
        
        PacienteEntity pacienteEntity= iPacienteRepository.findByUsernamePaciente(citaDto.getUsername());

        MedicoEntity medicoEntity= iMedicoRepository.findById(citaDto.getMedico());

        CitaEntity citaEntity= new CitaEntity();
        citaEntity.setIdCita(UUID.randomUUID().toString());

        citaEntity.setFechaCita(citaDto.getFechaCita());
        citaEntity.setHoraCita(citaDto.getHoraCita());
        citaEntity.setConsultorioCita(citaDto.getConsultorioCita());
        citaEntity.setEstadoCita(citaDto.getEstadoCita());
        citaEntity.setPacienteEntity(pacienteEntity);
        citaEntity.setMedicoEntity(medicoEntity);

        CitaEntity citaEntityCreado= iCitaRepository.save(citaEntity);
        CitaDto citaDtoCreado= modelMapper.map(citaEntityCreado,CitaDto.class);

        return citaDtoCreado;
    }

    @Override
    public List<CitaDto> leerCitas() {
        List<CitaEntity> citaEntityList= iCitaRepository.citasCreadas();

        List<CitaDto> citaDtoList= new ArrayList<>();

        for (CitaEntity citaEntity : citaEntityList) {
            CitaDto citaDto= modelMapper.map(citaEntity, CitaDto.class);
            citaDtoList.add(citaDto);
        }

        return citaDtoList;
    }

    @Override
    public CitaDto detalleCita(String idCita) {
        //Ejecutamos la consulta y guardamos el resultado en un PartidoEntity
        CitaEntity citaEntity= iCitaRepository.findByIdCita(idCita);
        //Mapeamos la PartidoEntity a PartidoDto
        CitaDto citaDto= modelMapper.map(citaEntity,CitaDto.class);
        //retornamos el partidoDto
        return citaDto;
        
    }

    @Override
    public CitaDto actualizarCita(String idCita, CitaDto citaDto) {


        PacienteEntity pacienteEntity= iPacienteRepository.findByUsernamePaciente(citaDto.getUsername());

        MedicoEntity medicoEntity= iMedicoRepository.findById(citaDto.getMedico());

        CitaEntity citaEntity=iCitaRepository.findByIdCita(idCita);

        if (citaEntity.getPacienteEntity().getId() != pacienteEntity.getId()) {
            throw new RuntimeException("Usted no puede realizar esta acción, ya que usted no creo esta cita");
        }

        // if (citaEntity.getMedicoEntity().getId() == medicoEntity.getId()) {
        //     throw new RuntimeException("El medico viene vacio");
        // }

        citaEntity.setFechaCita(citaDto.getFechaCita());
        citaEntity.setHoraCita(citaDto.getHoraCita());
        citaEntity.setConsultorioCita(citaDto.getConsultorioCita());
        citaEntity.setEstadoCita(citaDto.getEstadoCita());
        citaEntity.setMedicoEntity(medicoEntity);
        citaEntity.setPacienteEntity(pacienteEntity);

        CitaEntity citaEntityActualizada= iCitaRepository.save(citaEntity);
        CitaDto citaDtoActualizada= modelMapper.map(citaEntityActualizada,CitaDto.class);

        return citaDtoActualizada;

        // CitaEntity citaEntity=iCitaRepository.findByIdCita(idCita);
        // PacienteEntity pacienteEntity= iPacienteRepository.findByUsernamePaciente(citaDto.getUsername());
        // MedicoEntity medicoEntity= iMedicoRepository.findById(citaDto.getMedico());

        // if (citaEntity.getPacienteEntity().getId() != pacienteEntity.getId()) {
        //     throw new RuntimeException("Usted no puede realizar esta acción, ya que usted no creo esta cita");
        // }

        // citaEntity.setFechaCita(citaDto.getFechaCita());
        // citaEntity.setHoraCita(citaDto.getHoraCita());
        // citaEntity.setConsultorioCita(citaDto.getConsultorioCita());
        // citaEntity.setEstadoCita(citaDto.getEstadoCita());
        // citaEntity.setPacienteEntity(pacienteEntity);
        // citaEntity.setMedicoEntity(medicoEntity);
        
        // CitaEntity citaEntityActualizado= iCitaRepository.save(citaEntity);

        // CitaDto citaDtoActualizada = modelMapper.map(citaEntityActualizado, CitaDto.class);

        // return citaDtoActualizada;
    }

    @Override
    public void eliminarCita(String idCita, Long pacienteEntityId) {
        CitaEntity citaEntity= iCitaRepository.findByIdCita(idCita);

        if (citaEntity.getPacienteEntity().getId() != pacienteEntityId) {
            throw new RuntimeException("No se puede realizar esta acción");
        }

        iCitaRepository.delete(citaEntity);
        
    }
    
    

    
}
