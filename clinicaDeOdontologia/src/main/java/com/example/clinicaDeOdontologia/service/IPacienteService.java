package com.example.clinicaDeOdontologia.service;

import com.example.clinicaDeOdontologia.dto.PacienteDTO;

import java.util.Set;

public interface IPacienteService {
    void agregar(PacienteDTO pacienteDTO) ;
    void modificar(PacienteDTO pacienteDTO) ;
    void eliminar(Long id) ;
    Set<PacienteDTO> buscarTodos() ;
    PacienteDTO buscarPorId(Long id) ;
}
