package com.solicitud.restapi.repositories;

import com.solicitud.restapi.models.SolicitudFinalizadaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ISolicitudFinalizadaRepository extends JpaRepository<SolicitudFinalizadaModel, Long> {

}
