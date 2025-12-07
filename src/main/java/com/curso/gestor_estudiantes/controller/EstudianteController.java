package com.curso.gestor_estudiantes.controller;

import com.curso.gestor_estudiantes.model.Estudiante;
import com.curso.gestor_estudiantes.service.EstudianteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")

public class EstudianteController {
    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;

    }

    //Get listar
    @GetMapping
    public List<Estudiante> listar() {
        return estudianteService.obtenerTodos();

    }

    //Post crear
    @PostMapping
    public Estudiante crear(@RequestBody Estudiante estudiante) {
        return estudianteService.crear(estudiante);
    }

    //Get buscar por ID
    @GetMapping("/{id}")
    public Estudiante obtener(@PathVariable Long id) {
        return estudianteService.obtenerPorId(id);
    }

    //Borrar por ID
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        boolean eliminado = estudianteService.eliminar(id);
        if (eliminado) {
            return "Estudiante con ID " + id + "  borrado de la lista";
        } else {
            return "Estudiante con ID " + id + " no se encontró en la lista";
        }
    }

    //Actualizar por ID
//    @PutMapping("/{id}")
//    public Estudiante actualizarEstudiante(@PathVariable Long id, @RequestBody Estudiante estudianteActualizado) {
//        Estudiante estudianteExistente = estudianteService.obtenerPorId(id);
//        if (estudianteExistente != null) {
//            estudianteExistente.setNombre(estudianteActualizado.getNombre());
//            estudianteExistente.setEmail(estudianteActualizado.getEmail());
//            estudianteExistente.setEdad(estudianteActualizado.getEdad());
//            return estudianteExistente;
//        } else {
//            return null;
//        }
//    }

    @PutMapping("/{id}")
    public Estudiante actualizarEstudiante(@PathVariable Long id, @RequestBody Estudiante estudianteActualizado) {
        return estudianteService.actualizar(id, estudianteActualizado);
    }
}
