package com.curso.gestor_estudiantes.controller;

import com.curso.gestor_estudiantes.model.Usuario;
import com.curso.gestor_estudiantes.security.JwtUtil;
import com.curso.gestor_estudiantes.security.UsuarioService;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/auth")

public class LoginController {

    private final UsuarioService usuarioService;
    private final JwtUtil jwtUtil;

    public LoginController(UsuarioService usuarioService, JwtUtil jwtUtil) {
        this.usuarioService = usuarioService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public String login(@RequestBody Usuario user) {

        Usuario u = usuarioService.buscarPorUsername(user.getUsername());

        if (u == null) return "ERROR";

        if (!u.getPassword().equals(user.getPassword()))
            return "ERROR";

        return jwtUtil.generarToken(u.getUsername(), u.getRol());
    }
}