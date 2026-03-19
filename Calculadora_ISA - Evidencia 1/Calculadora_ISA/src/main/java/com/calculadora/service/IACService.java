package com.calculadora.service;

import com.calculadora.model.Persona;
import com.calculadora.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class IACService {

    private final PersonaRepository repository;

    @Autowired
    public IACService(PersonaRepository repository) {
        this.repository = repository;
    }

    public double calcularIAC(double caderas, double altura) {
        if (altura <= 0) throw new IllegalArgumentException("La altura debe ser mayor a 0");
        if (caderas <= 0) throw new IllegalArgumentException("La medida de caderas debe ser mayor a 0");
        return (caderas / Math.pow(altura, 1.5)) - 18;
    }

    public String clasificarIAC(double iac, String genero) {
        if ("M".equalsIgnoreCase(genero)) {
            if (iac < 20) return "Bajo peso";
            if (iac <= 25) return "Peso normal";
            return "Sobrepeso/Obesidad";
        } else if ("F".equalsIgnoreCase(genero)) {
            if (iac < 25) return "Bajo peso";
            if (iac <= 30) return "Peso normal";
            return "Sobrepeso/Obesidad";
        }
        throw new IllegalArgumentException("Género inválido");
    }

    public Persona guardar(Persona persona) {
        calcularYClasificarIAC(persona);
        return repository.save(persona);
    }

    public List<Persona> listar() {
        return repository.findAll();
    }

    public Persona obtener(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Persona actualizar(Long id, Persona nueva) {
        Persona p = obtener(id);
        if (p != null) {
            p.setNombre(nueva.getNombre());
            p.setGenero(nueva.getGenero());
            p.setAltura(nueva.getAltura());
            p.setCadera(nueva.getCadera());
            calcularYClasificarIAC(p);
            return repository.save(p);
        }
        return null;
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    public void calcularYClasificarIAC(Persona persona) {
        double iac = calcularIAC(persona.getCadera(), persona.getAltura());
        persona.setIac(iac);
        persona.setClasificacion(clasificarIAC(iac, persona.getGenero()));
        persona.setFechaCalculo(java.time.LocalDateTime.now());
    }
}
