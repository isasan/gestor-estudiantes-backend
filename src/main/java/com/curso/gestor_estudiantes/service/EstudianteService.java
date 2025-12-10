package com.curso.gestor_estudiantes.service;

import com.curso.gestor_estudiantes.model.Estudiante;
import com.curso.gestor_estudiantes.repository.EstudianteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {

    private final EstudianteRepository repository;

    public EstudianteService(EstudianteRepository repository) {
        this.repository = repository;
    }

    public List<Estudiante> obtenerTodos() {
        return repository.findAll();
    }

    public Estudiante crear(Estudiante estudiante) {
        return repository.save(estudiante);
    }

    public Estudiante obtenerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public boolean eliminar(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Transactional
    public Estudiante actualizar(Long id, Estudiante nuevo) {
        Estudiante existente = obtenerPorId(id);
        if (existente == null) return null;

        existente.setNombre(nuevo.getNombre());
        existente.setEmail(nuevo.getEmail());
        existente.setEdad(nuevo.getEdad());
        existente.setTelefono(nuevo.getTelefono());

        return repository.save(existente);
    }


    public List<Estudiante> buscarPorNombre(String nombre) {
        return repository.findByNombreIgnoreCaseContaining(nombre);
    }
}
