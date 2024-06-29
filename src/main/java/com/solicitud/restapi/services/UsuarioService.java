package com.solicitud.restapi.services;

import com.solicitud.restapi.models.UsuarioModel;
import com.solicitud.restapi.repositories.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.ArrayList;

@Service
public class UsuarioService {
    @Autowired
    IUsuarioRepository usuarioRepository;

    public Optional<UsuarioModel> validarUsuario(String username, String password) {
        return usuarioRepository.findByNombreUsuarioAndContrasena(username, password);
    }
    public ArrayList<UsuarioModel> getUsuarios() {
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }
}
