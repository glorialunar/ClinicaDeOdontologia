package com.example.clinicaDeOdontologia.service.impl;

import com.example.clinicaDeOdontologia.dto.OdontologoDTO;
import com.example.clinicaDeOdontologia.entity.Odontologo;
import com.example.clinicaDeOdontologia.repository.OdontologoRepository;
import com.example.clinicaDeOdontologia.service.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoService implements IOdontologoService {
    @Autowired
    private OdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;

    private void guardar(OdontologoDTO odontologoDTO){
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        odontologoRepository.save(odontologo);
    }

    @Override
    public void agregar(OdontologoDTO odontologoDTO) {
        guardar(odontologoDTO);
    }

    @Override
    public void modificar(OdontologoDTO odontologoDTO) {
        guardar(odontologoDTO);
    }

    @Override
    public void eliminar(Long id) {
        odontologoRepository.deleteById(id);
    }

    @Override
    public Set<OdontologoDTO> buscarTodos() {
        List<Odontologo> odontologos = odontologoRepository.findAll();
        Set<OdontologoDTO> odontologosDTO = new HashSet<>();

        for(Odontologo o:odontologos){
            odontologosDTO.add(mapper.convertValue(o, OdontologoDTO.class));
        }

        return odontologosDTO;
    }

    @Override
    public OdontologoDTO buscarPorId(Long id) {
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        OdontologoDTO odontologoDTO = null;

        if(odontologo.isPresent())
            odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);

        return odontologoDTO;
    }
}
