package com.calculadora.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String genero;
    private Double altura;
    private Double cadera;
    private Double iac;
    private String clasificacion;
    private LocalDateTime fechaCalculo;

    public Persona() {}

    public Persona(String nombre, String genero, Double altura, Double cadera) {
        this.nombre = nombre;
        this.genero = genero;
        this.altura = altura;
        this.cadera = cadera;
        this.fechaCalculo = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public Double getAltura() { return altura; }
    public void setAltura(Double altura) { this.altura = altura; }

    public Double getCadera() { return cadera; }
    public void setCadera(Double cadera) { this.cadera = cadera; }

    public Double getIac() { return iac; }
    public void setIac(Double iac) { this.iac = iac; }

    public String getClasificacion() { return clasificacion; }
    public void setClasificacion(String clasificacion) { this.clasificacion = clasificacion; }

    public LocalDateTime getFechaCalculo() { return fechaCalculo; }
    public void setFechaCalculo(LocalDateTime fechaCalculo) { this.fechaCalculo = fechaCalculo; }
}
