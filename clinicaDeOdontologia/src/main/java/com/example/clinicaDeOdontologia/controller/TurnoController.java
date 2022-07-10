package com.example.clinicaDeOdontologia.controller;

import com.example.clinicaDeOdontologia.dto.TurnoDTO;
import com.example.clinicaDeOdontologia.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    private ITurnoService turnoService;

    @PostMapping("/guardar")
    public ResponseEntity<?> guardarTurno (@RequestBody TurnoDTO turnoDTO) {
        turnoService.agregar(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/modificar")
    public ResponseEntity<?> modificarTurno (@RequestBody TurnoDTO turnoDTO)  {
        turnoService.modificar(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTurno (@PathVariable Long id)  {
        turnoService.eliminar(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<TurnoDTO> listarTurnos()  {
        return turnoService.buscarTodos();
    }

    @GetMapping("/{id}")
    public TurnoDTO buscarPorID(@PathVariable Long id){
        return turnoService.buscarPorId(id);
    }
}
