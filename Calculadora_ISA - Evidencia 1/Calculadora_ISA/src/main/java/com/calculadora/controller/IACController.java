package com.calculadora.controller;

import com.calculadora.model.Persona;
import com.calculadora.service.IACService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/iac")
@CrossOrigin(origins = "*")
public class IACController {

    private final IACService iacService;

    @Autowired
    public IACController(IACService iacService) {
        this.iacService = iacService;
    }

    @PostMapping("/calcular")
    public ResponseEntity<?> calcularIAC(@RequestBody Persona persona) {
        try {
            Persona guardada = iacService.guardar(persona);
            return ResponseEntity.ok(guardada);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Persona>> listar() {
        return ResponseEntity.ok(iacService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> obtener(@PathVariable Long id) {
        Persona persona = iacService.obtener(id);
        if (persona == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(persona);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Persona> actualizar(@PathVariable Long id, @RequestBody Persona persona) {
        Persona actualizada = iacService.actualizar(id, persona);
        if (actualizada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Persona persona = iacService.obtener(id);
        if (persona == null) {
            return ResponseEntity.notFound().build();
        }
        iacService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/historial")
    public ResponseEntity<List<Persona>> obtenerHistorial() {
        return ResponseEntity.ok(iacService.listar());
    }
}
