package com.calculadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.calculadora.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}