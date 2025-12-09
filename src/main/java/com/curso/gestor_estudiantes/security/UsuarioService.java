package com.curso.gestor_estudiantes.security;

import com.curso.gestor_estudiantes.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    public Usuario buscarPorUsername(String username) {
        // Usuarios simulados
        if(username.equals("admin")) {
            return new Usuario("admin", "1234", "ADMIN");
        }
        if(username.equals("user")) {
            return new Usuario("user", "1234", "USER");
        }
        return null;
    }
}
