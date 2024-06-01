package com.grupo6.ggggg.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario register(Usuario usuario) {
        usuario.setFechaRegistro(LocalDate.now());
        usuario.setPasswordHash(passwordEncoder.encode(usuario.getPasswordHash()));
        return usuarioRepositorio.save(usuario);
    }

    public Optional<Usuario> findByEmail(String email) {
        return usuarioRepositorio.findByEmail(email);
    }

    public boolean checkPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}