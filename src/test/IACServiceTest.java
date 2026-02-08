package com.calculadora.service;

import com.calculadora.model.Persona;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IACServiceTest {
    
    private IACService iacService;
    
    @BeforeEach
    public void setUp() {
        iacService = new IACService();
    }
    
    @Test
    public void testCalcularIACValido() {
        double iac = iacService.calcularIAC(95, 1.65);
        assertTrue(iac > 0);
    }
    
    @Test
    public void testCalcularIACConAlturaCero() {
        assertThrows(IllegalArgumentException.class, 
            () -> iacService.calcularIAC(95, 0));
    }
    
    @Test
    public void testClasificarIACHombreBajoPeso() {
        String clasificacion = iacService.clasificarIAC(19, "M");
        assertEquals("Bajo peso", clasificacion);
    }
    
    @Test
    public void testClasificarIACHombreNormal() {
        String clasificacion = iacService.clasificarIAC(22, "M");
        assertEquals("Peso normal", clasificacion);
    }
    
    @Test
    public void testClasificarIACMujerNormal() {
        String clasificacion = iacService.clasificarIAC(27, "F");
        assertEquals("Peso normal", clasificacion);
    }
}
