package com.solicitud.restapi.services;

import com.solicitud.restapi.models.SolicitudEliminadaModel;
import com.solicitud.restapi.models.SolicitudFinalizadaModel;
import com.solicitud.restapi.repositories.ISolicitudEliminadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class SolicitudEliminadaService {
    @Autowired
    ISolicitudEliminadaRepository solicitudEliminadaRepository;

    public ArrayList<SolicitudEliminadaModel> getSolicitudesEliminadas() {
        return (ArrayList<SolicitudEliminadaModel>) solicitudEliminadaRepository.findAll();
    }

    public SolicitudEliminadaModel guardarSolicitudEliminada(SolicitudEliminadaModel solicitud) {
        return solicitudEliminadaRepository.save(solicitud);
    }
    public SolicitudEliminadaModel getSolicitudEliminadaById(Long id) {
        return solicitudEliminadaRepository.findById(id).orElse(null);
    }
}
