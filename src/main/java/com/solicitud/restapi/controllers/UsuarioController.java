package com.solicitud.restapi.controllers;

import com.solicitud.restapi.models.UsuarioModel;
import com.solicitud.restapi.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel> getSolicitudes(){
        return this.usuarioService.getUsuarios();
    }
}
