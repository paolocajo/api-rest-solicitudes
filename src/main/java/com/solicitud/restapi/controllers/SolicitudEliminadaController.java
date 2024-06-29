package com.solicitud.restapi.controllers;

import com.solicitud.restapi.models.SolicitudEliminadaModel;
import com.solicitud.restapi.models.SolicitudFinalizadaModel;
import com.solicitud.restapi.models.SolicitudModel;
import com.solicitud.restapi.services.SolicitudEliminadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/solicitud/eliminada")
public class SolicitudEliminadaController {

    @Autowired
    private SolicitudEliminadaService solicitudEliminadaService;

    @GetMapping
    public ArrayList<SolicitudEliminadaModel> getSolicitudesEliminadas(){
        return this.solicitudEliminadaService.getSolicitudesEliminadas();
    }
    @GetMapping("/{id}")
    public SolicitudEliminadaModel getSolicitudEliminadaById(@PathVariable("id") Long id) {
        return this.solicitudEliminadaService.getSolicitudEliminadaById(id);
    }
    @PostMapping
    public SolicitudEliminadaModel crearSolicitud(@RequestBody SolicitudEliminadaModel solicitud) {
        return solicitudEliminadaService.guardarSolicitudEliminada(solicitud);
    }
}
