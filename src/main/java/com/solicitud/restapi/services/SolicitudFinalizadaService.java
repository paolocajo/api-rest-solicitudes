package com.solicitud.restapi.services;

import com.solicitud.restapi.models.SolicitudEliminadaModel;
import com.solicitud.restapi.models.SolicitudFinalizadaModel;
import com.solicitud.restapi.models.SolicitudModel;
import com.solicitud.restapi.repositories.ISolicitudFinalizadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class SolicitudFinalizadaService {
    @Autowired
    ISolicitudFinalizadaRepository solicitudFinalizadaRepository;
    public ArrayList<SolicitudFinalizadaModel> getSolicitudesFinalizadas() {
        return (ArrayList<SolicitudFinalizadaModel>) solicitudFinalizadaRepository.findAll();
    }
    public SolicitudFinalizadaModel guardarSolicitudFinalizada(SolicitudFinalizadaModel solicitud) {
        return solicitudFinalizadaRepository.save(solicitud);
    }

    public SolicitudFinalizadaModel getSolicitudFinalizadaById(Long id) {
        return solicitudFinalizadaRepository.findById(id).orElse(null);
    }
}
