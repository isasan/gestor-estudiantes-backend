package com.curso.gestor_estudiantes.service;

import com.curso.gestor_estudiantes.model.Estudiante;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Locale.filter;

@Service
public class EstudianteService {
    private List<Estudiante> estudiantes = new ArrayList<>();
    private Long contadorId = 1L;

    //Listar
    public List<Estudiante> obtenerTodos() {
        return estudiantes;
    }

    //Crear
    public Estudiante crear(Estudiante estudiante) {
        estudiante.setId(contadorId++);
        estudiantes.add(estudiante);
        return estudiante;
    }

    //Buscar por ID
    public Estudiante obtenerPorId(Long id) {
        return estudiantes.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    //Eliminar
    public boolean eliminar(Long id) {
        return estudiantes.removeIf(e -> e.getId().equals(id));
    }
}
