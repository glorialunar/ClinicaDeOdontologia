package com.example.clinicaDeOdontologia.service.impl;

import com.example.clinicaDeOdontologia.dto.PacienteDTO;
import com.example.clinicaDeOdontologia.entity.Paciente;
import com.example.clinicaDeOdontologia.repository.PacienteRepository;
import com.example.clinicaDeOdontologia.service.IPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PacienteService implements IPacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper mapper;

    private void guardar(PacienteDTO pacienteDTO){
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        pacienteRepository.save(paciente);
    }


    @Override
    public void agregar(PacienteDTO pacienteDTO) {
        guardar(pacienteDTO);
    }

    @Override
    public void modificar(PacienteDTO pacienteDTO) {
        guardar(pacienteDTO);
    }

    @Override
    public void eliminar(Long id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public Set<PacienteDTO> buscarTodos() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        Set<PacienteDTO> pacientesDTO = new HashSet<>();

        for(Paciente p:pacientes){
            pacientesDTO.add(mapper.convertValue(p, PacienteDTO.class));
        }

        return pacientesDTO;
    }

    @Override
    public PacienteDTO buscarPorId(Long id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        PacienteDTO pacienteDTO = null;
        if(paciente.isPresent())
            pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);

        return pacienteDTO;
    }
}
