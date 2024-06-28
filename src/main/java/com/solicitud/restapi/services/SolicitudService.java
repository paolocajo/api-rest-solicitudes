package com.solicitud.restapi.services;

import com.solicitud.restapi.models.SolicitudEliminadaModel;
import com.solicitud.restapi.models.SolicitudFinalizadaModel;
import com.solicitud.restapi.models.SolicitudModel;
import com.solicitud.restapi.repositories.ISolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class SolicitudService {

    @Autowired
    ISolicitudRepository solicitudRepository;

    public ArrayList<SolicitudModel> getSolicitudes(){
        return (ArrayList<SolicitudModel>) solicitudRepository.findAll();
    }

    public SolicitudModel getSolicitudById(Long id) {
        return solicitudRepository.findById(id).orElse(null);
    }

    public boolean eliminarSolicitud(Long id) {
        try{
            solicitudRepository.deleteById(id);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public SolicitudModel guardarSolicitud(SolicitudModel solicitud) {
        return solicitudRepository.save(solicitud);
    }

    public Optional<SolicitudModel> actualizarSolicitud(Long id, SolicitudModel request) {
        Optional<SolicitudModel> existingSolicitudOptional = solicitudRepository.findById(id);
        if (existingSolicitudOptional.isPresent()) {
            SolicitudModel existingSolicitud = existingSolicitudOptional.get();

            // Actualizar
            existingSolicitud.setIdUsuario(request.getIdUsuario());
            existingSolicitud.setFechaRegistro(request.getFechaRegistro());
            existingSolicitud.setCodigo(request.getCodigo());
            existingSolicitud.setDetalle(request.getDetalle());
            existingSolicitud.setModificado(true);
            existingSolicitud.setEstado(request.getEstado());

            // Guardar
            SolicitudModel updatedSolicitud = solicitudRepository.save(existingSolicitud);
            return Optional.of(updatedSolicitud);
        } else {
            return Optional.empty();
        }
    }

    public ArrayList<SolicitudModel> getSolicitudesActivas() {
        return (ArrayList<SolicitudModel>) solicitudRepository.findByState("activa");
    }


    public Optional<SolicitudModel> actualizarEstadoSolicitud(Long id, String estado) {
        Optional<SolicitudModel> existingSolicitudOptional = solicitudRepository.findById(id);
        if (existingSolicitudOptional.isPresent()) {
            SolicitudModel existingSolicitud = existingSolicitudOptional.get();

            if (estado != null) {
                existingSolicitud.setEstado(estado);
            } else {
                throw new IllegalArgumentException("El estado no puede ser nulo al actualizar la solicitud.");
            }
            SolicitudModel updatedSolicitud = solicitudRepository.save(existingSolicitud);
            return Optional.of(updatedSolicitud);
        } else {
            return Optional.empty();
        }
    }
}
