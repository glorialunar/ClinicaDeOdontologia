package com.example.clinicaDeOdontologia.controller;

import com.example.clinicaDeOdontologia.dto.OdontologoDTO;
import com.example.clinicaDeOdontologia.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    @Autowired
    IOdontologoService odontologoService;

    @PostMapping("/guardar")
    public ResponseEntity<?> guardarOdontologo (@RequestBody OdontologoDTO odontologoDTO) {
        odontologoService.modificar(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/modificar")
    public ResponseEntity<?> modificarOdontologo (@RequestBody OdontologoDTO odontologoDTO) {
        odontologoService.modificar(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarOdontologo (@PathVariable Long id) {
        odontologoService.eliminar(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<OdontologoDTO> listarOdontologos() {
        return odontologoService.buscarTodos();

    }

    @GetMapping("/{id}")
    public OdontologoDTO buscarPorID(@PathVariable Long id) {
        return odontologoService.buscarPorId(id);
    }
}
