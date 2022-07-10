package com.example.clinicaDeOdontologia.service.impl;

import com.example.clinicaDeOdontologia.dto.PacienteDTO;
import com.example.clinicaDeOdontologia.dto.TurnoDTO;
import com.example.clinicaDeOdontologia.entity.Paciente;
import com.example.clinicaDeOdontologia.entity.Turno;
import com.example.clinicaDeOdontologia.repository.PacienteRepository;
import com.example.clinicaDeOdontologia.repository.TurnoRepository;
import com.example.clinicaDeOdontologia.service.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TurnoService implements ITurnoService {
    @Autowired
    private TurnoRepository turnoRepository;

    @Autowired
    ObjectMapper mapper;

    private void guardar(TurnoDTO turnoDTO){
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        turnoRepository.save(turno);
    }


    @Override
    public void agregar(TurnoDTO turnoDTO) {
        guardar(turnoDTO);
    }

    @Override
    public void modificar(TurnoDTO turnoDTO) {
        guardar(turnoDTO);
    }

    @Override
    public void eliminar(Long id) {
        turnoRepository.deleteById(id);
    }

    @Override
    public Set<TurnoDTO> buscarTodos() {
        List<Turno> turnos = turnoRepository.findAll();
        Set<TurnoDTO> turnosDTO = new HashSet<>();

        for(Turno t:turnos){
            turnosDTO.add(mapper.convertValue(t, TurnoDTO.class));
        }

        return turnosDTO;
    }

    @Override
    public TurnoDTO buscarPorId(Long id) {
        Optional<Turno> turno = turnoRepository.findById(id);
        TurnoDTO turnoDTO = null;
        if(turno.isPresent())
            turnoDTO = mapper.convertValue(turno, TurnoDTO.class);

        return turnoDTO;
    }
}
