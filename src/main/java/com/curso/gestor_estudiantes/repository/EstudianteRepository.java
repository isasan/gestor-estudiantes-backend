package com.curso.gestor_estudiantes.repository;

import com.curso.gestor_estudiantes.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
}

