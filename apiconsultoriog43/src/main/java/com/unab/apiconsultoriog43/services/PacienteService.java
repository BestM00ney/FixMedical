package com.unab.apiconsultoriog43.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.unab.apiconsultoriog43.models.dto.CitaDto;
import com.unab.apiconsultoriog43.models.dto.PacienteDto;
import com.unab.apiconsultoriog43.models.entidades.CitaEntity;
import com.unab.apiconsultoriog43.models.entidades.PacienteEntity;
import com.unab.apiconsultoriog43.repository.ICitaRepository;
import com.unab.apiconsultoriog43.repository.IPacienteRepository;

@Service
public class PacienteService implements IPacienteService{

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IPacienteRepository iPacienteRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    ICitaRepository iCitaRepository;

    @Override
    public PacienteDto crearPaciente(PacienteDto pacienteDto) {
        
        if (iPacienteRepository.findByEmailPaciente(pacienteDto.getEmailPaciente()) != null) {
            throw new RuntimeException("Este correo ya se encuentra registrado");
        }

        if (iPacienteRepository.findByUsernamePaciente(pacienteDto.getUsernamePaciente()) != null) {
            throw new RuntimeException("Este nombre de usuario ya se encuentra registrado");
        }

        PacienteEntity pacienteEntity= modelMapper.map(pacienteDto,PacienteEntity.class);
        pacienteEntity.setIdPaciente(UUID.randomUUID().toString());
        pacienteEntity.setPasswordEncriptada(bCryptPasswordEncoder.encode(pacienteDto.getPassword()));
        PacienteEntity pacienteEntityCreado = iPacienteRepository.save(pacienteEntity);
        PacienteDto pacienteDtoCreado = modelMapper.map(pacienteEntityCreado,PacienteDto.class);

        return pacienteDtoCreado;
    }

    @Override
    public PacienteDto leerPaciente(String username) {
        
        PacienteEntity pacienteEntity= iPacienteRepository.findByUsernamePaciente(username);

        if (pacienteEntity==null) {
            throw new UsernameNotFoundException(username);
        }

        PacienteDto pacienteDto= modelMapper.map(pacienteEntity,PacienteDto.class);
        
        return pacienteDto;
    }

    @Override
    public List<CitaDto> leerMiscitas(String username) {
        
        PacienteEntity pacienteEntity= iPacienteRepository.findByUsernamePaciente(username);
        if (pacienteEntity==null) {
            throw new UsernameNotFoundException(username);
        }
        //Obtenemos la información de todas las citas del paciente y las guardamos en una lista de CitaEntity
        List<CitaEntity> citaEntityList= iCitaRepository.misCitas(pacienteEntity.getId());

        List<CitaDto> citaDtoList= new ArrayList<CitaDto>();

        for (CitaEntity citaEntity : citaEntityList) {
            CitaDto citaDto= modelMapper.map(citaEntity, CitaDto.class);
            citaDtoList.add(citaDto);
        }

        return citaDtoList;
    }

    //este metodo lo creo la libreria para obtener la información del usuario para la autenticación.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PacienteEntity pacienteEntity= iPacienteRepository.findByUsernamePaciente(username);
        if(pacienteEntity == null){
            throw new UsernameNotFoundException(username);
        }
        //Trabajar user de SpringBootSecurity
        User usuario= new User(pacienteEntity.getUsernamePaciente(), pacienteEntity.getPasswordEncriptada(), new ArrayList<>());

        return usuario;
    }    

    

    
}
