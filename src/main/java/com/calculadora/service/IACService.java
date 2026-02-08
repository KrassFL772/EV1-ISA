package com.calculadora.service;

import com.calculadora.model.Persona;
import org.springframework.stereotype.Service;

@Service
public class IACService {
    
    public double calcularIAC(double caderas, double altura) {
        if (altura <= 0) {
            throw new IllegalArgumentException("La altura debe ser mayor a 0");
        }
        if (caderas <= 0) {
            throw new IllegalArgumentException("La medida de caderas debe ser mayor a 0");
        }
        return (caderas / Math.pow(altura, 1.5)) - 18;
    }
    
    public String clasificarIAC(double iac, String genero) {
        if ("M".equalsIgnoreCase(genero)) {
            if (iac < 20) {
                return "Bajo peso";
            } else if (iac <= 25) {
                return "Peso normal";
            } else {
                return "Sobrepeso/Obesidad";
            }
        } else if ("F".equalsIgnoreCase(genero)) {
            if (iac < 25) {
                return "Bajo peso";
            } else if (iac <= 30) {
                return "Peso normal";
            } else {
                return "Sobrepeso/Obesidad";
            }
        }
        throw new IllegalArgumentException("Género inválido");
    }
    
    public void calcularYClasificarIAC(Persona persona) {
        double iac = calcularIAC(persona.getCadera(), persona.getAltura());
        persona.setIac(iac);
        persona.setClasificacion(clasificarIAC(iac, persona.getGenero()));
        persona.setFechaCalculo(java.time.LocalDateTime.now());
    }
}
