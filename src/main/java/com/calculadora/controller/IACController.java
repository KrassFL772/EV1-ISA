package com.calculadora.controller;

import com.calculadora.model.Persona;
import com.calculadora.service.IACService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/api/iac")
@CrossOrigin(origins = "*")
public class IACController {

    private final IACService iacService;
    // historial en memoria (sin DB)
    private final List<Persona> historial = new CopyOnWriteArrayList<>();

    @Autowired
    public IACController(IACService iacService) {
        this.iacService = iacService;
    }

    @PostMapping("/calcular")
    public ResponseEntity<?> calcularIAC(@RequestBody Persona persona) {
        try {
            iacService.calcularYClasificarIAC(persona);
            // guardar sólo en memoria para permitir revisión local
            historial.add(persona);
            return ResponseEntity.ok(persona);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/historial")
    public ResponseEntity<List<Persona>> obtenerHistorial() {
        return ResponseEntity.ok(historial);
    }
}
