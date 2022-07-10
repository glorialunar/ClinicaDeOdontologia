package com.example.clinicaDeOdontologia.controller;

import com.example.clinicaDeOdontologia.dto.PacienteDTO;
import com.example.clinicaDeOdontologia.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private IPacienteService pacienteService;

    @PostMapping("/guardar")
    public ResponseEntity<?> guardarPaciente (@RequestBody PacienteDTO pacienteDTO){
        pacienteService.agregar(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/modificar")
    public ResponseEntity<?> modificarPaciente (@RequestBody PacienteDTO pacienteDTO) {
        pacienteService.modificar(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPaciente (@PathVariable Long id) {
        pacienteService.eliminar(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<PacienteDTO> listarPacientes() {
        return pacienteService.buscarTodos();
    }

    @GetMapping("/{id}")
    public PacienteDTO buscarPorID(@PathVariable Long id) {
        return pacienteService.buscarPorId(id);
    }
}
