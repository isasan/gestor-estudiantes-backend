package com.curso.gestor_estudiantes.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    // Generar una clave automaticamente (es una forma más segura que hardcodearla)
    private final SecretKey SECRET = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generarToken(String username, String rol) {
        return Jwts.builder()
                .setSubject(username)
                .claim("rol", rol)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 hora
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    public String getUsername(String token) {
        return Jwts.parser().setSigningKey(SECRET)
                .parseClaimsJws(token).getBody().getSubject();
    }

    public String getRol(String token) {
        return (String) Jwts.parser().setSigningKey(SECRET)
                .parseClaimsJws(token).getBody().get("rol");
    }
}
