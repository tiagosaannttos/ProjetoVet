package com.hospitalvet.backend.controller;

import com.hospitalvet.backend.model.Usuario;
import com.hospitalvet.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    
    @PostMapping("/cadastro")
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario) {
        String senhaCriptografada = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senhaCriptografada);
        return usuarioRepository.save(usuario);
    }

    
    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {
        Optional<Usuario> user = usuarioRepository.findByEmail(usuario.getEmail());
        if (user.isPresent() && passwordEncoder.matches(usuario.getSenha(), user.get().getSenha())) {
            return "Login realizado com sucesso!";
        } else {
            return "Email ou senha inválidos.";
        }
    }
}
