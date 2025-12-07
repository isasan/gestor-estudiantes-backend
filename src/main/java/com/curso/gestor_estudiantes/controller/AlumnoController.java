package com.curso.gestor_estudiantes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlumnoController {
    @GetMapping("/saludosAlumnos")
    public String saludos() {
        return "Hola estudiante, bienvenido al curso";
    }
}
