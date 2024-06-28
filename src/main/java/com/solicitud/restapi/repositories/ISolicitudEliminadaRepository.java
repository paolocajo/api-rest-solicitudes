package com.solicitud.restapi.repositories;

import com.solicitud.restapi.models.SolicitudEliminadaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ISolicitudEliminadaRepository extends JpaRepository<SolicitudEliminadaModel, Long> {

}
