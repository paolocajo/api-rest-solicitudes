package com.solicitud.restapi.controllers;

import com.solicitud.restapi.models.SolicitudEliminadaModel;
import com.solicitud.restapi.models.SolicitudFinalizadaModel;
import com.solicitud.restapi.models.SolicitudModel;
import com.solicitud.restapi.services.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/solicitud")
public class SolicitudController {

    @Autowired
    private SolicitudService solicitudService;

    @GetMapping()
    public ArrayList<SolicitudModel> getSolicitudes(){
        return this.solicitudService.getSolicitudes();
    }

    @GetMapping("/activa")
    public ArrayList<SolicitudModel> getSolicitudesActivas(){
        return this.solicitudService.getSolicitudesActivas();
    }

    @GetMapping("/{id}")
    public SolicitudModel getSolicitudById(@PathVariable("id") Long id) {
        return this.solicitudService.getSolicitudById(id);
    }

    /*@DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSolicitud(@PathVariable("id") Long id) {
        boolean deleted = solicitudService.eliminarSolicitud(id);

        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/

    @PostMapping
    public SolicitudModel crearSolicitud(@RequestBody SolicitudModel solicitud) {
        return solicitudService.guardarSolicitud(solicitud);
    }
    @PutMapping("/{id}")
    public Optional<SolicitudModel> actualizarSolicitud(@PathVariable("id") Long id, @RequestBody SolicitudModel solicitud) {
        return solicitudService.actualizarSolicitud(id, solicitud);
    }

    @PutMapping("actualizar-estado/{id}")
    public Optional<SolicitudModel> actualizarSolicitud(
            @PathVariable("id") Long id,
            @RequestParam String estado
    ) {
        return solicitudService.actualizarEstadoSolicitud(id, estado);
    }


}
