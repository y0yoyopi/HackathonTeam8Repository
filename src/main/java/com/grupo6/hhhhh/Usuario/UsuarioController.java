package com.grupo6.hhhhh.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @PostMapping("/register")
    public ResponseEntity<Usuario> register(@RequestBody Usuario usuario) {
        usuario.setFechaRegistro(LocalDate.now());
        usuario.setPasswordHash(passwordEncoder.encode(usuario.getPasswordHash())); // Implementa PasswordEncoder
        Usuario nuevoUsuario = usuarioRepositorio.save(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> loginData) {
        Optional<Usuario> usuarioOpt = usuarioRepositorio.findByEmail(loginData.get("email"));
        if (usuarioOpt.isPresent() && passwordEncoder.matches(loginData.get("password"), usuarioOpt.get().getPasswordHash())) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}
