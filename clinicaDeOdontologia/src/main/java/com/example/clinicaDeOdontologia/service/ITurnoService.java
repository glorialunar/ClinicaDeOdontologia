package com.example.clinicaDeOdontologia.service;

import com.example.clinicaDeOdontologia.dto.TurnoDTO;

import java.util.Set;

public interface ITurnoService {
    void agregar(TurnoDTO turnoDTO);
    void modificar(TurnoDTO turnoDTO);
    void eliminar(Long id);
    Set<TurnoDTO> buscarTodos();
    TurnoDTO buscarPorId(Long id);
}
