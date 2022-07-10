package com.example.clinicaDeOdontologia.service;

import com.example.clinicaDeOdontologia.dto.OdontologoDTO;

import java.util.Set;

public interface IOdontologoService {
    void agregar(OdontologoDTO odontologoDTO) ;
    void modificar(OdontologoDTO odontologoDTO) ;
    void eliminar(Long id) ;
    Set<OdontologoDTO> buscarTodos() ;
    OdontologoDTO buscarPorId(Long id) ;
}
