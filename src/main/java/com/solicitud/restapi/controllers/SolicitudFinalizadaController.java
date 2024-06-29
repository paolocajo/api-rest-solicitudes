package com.solicitud.restapi.controllers;

import com.solicitud.restapi.models.SolicitudEliminadaModel;
import com.solicitud.restapi.models.SolicitudFinalizadaModel;
import com.solicitud.restapi.models.SolicitudModel;
import com.solicitud.restapi.services.SolicitudFinalizadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/solicitud/finalizada")
public class SolicitudFinalizadaController {

    @Autowired
    private SolicitudFinalizadaService solicitudFinalizadaService;

    @GetMapping
    public ArrayList<SolicitudFinalizadaModel> getSolicitudesFinalizadas(){
        return this.solicitudFinalizadaService.getSolicitudesFinalizadas();
    }

    @GetMapping("/{id}")
    public SolicitudFinalizadaModel getSolicitudFinalizadaById(@PathVariable("id") Long id) {
        return this.solicitudFinalizadaService.getSolicitudFinalizadaById(id);
    }
    @PostMapping
    public SolicitudFinalizadaModel crearSolicitud(@RequestBody SolicitudFinalizadaModel solicitud) {
        return solicitudFinalizadaService.guardarSolicitudFinalizada(solicitud);
    }
}
