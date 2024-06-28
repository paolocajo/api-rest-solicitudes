package com.solicitud.restapi.services;

import com.solicitud.restapi.models.UsuarioModel;
import com.solicitud.restapi.repositories.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UsuarioService {
    @Autowired
    IUsuarioRepository usuarioRepository;


    public ArrayList<UsuarioModel> getUsuarios() {
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }
}
