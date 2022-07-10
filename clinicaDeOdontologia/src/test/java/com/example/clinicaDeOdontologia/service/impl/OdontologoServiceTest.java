package com.example.clinicaDeOdontologia.service.impl;

import com.example.clinicaDeOdontologia.dto.OdontologoDTO;
import com.example.clinicaDeOdontologia.entity.Odontologo;
import com.example.clinicaDeOdontologia.service.IOdontologoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OdontologoServiceTest {
    @Autowired
    private IOdontologoService odontologoService;

    @Test
    public void testCrearOdontologo(){

        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("Pelusin");
        odontologoDTO.setApellido("Raucheo");

        odontologoService.agregar(odontologoDTO);

        assertTrue(odontologoDTO !=null);

    }

}