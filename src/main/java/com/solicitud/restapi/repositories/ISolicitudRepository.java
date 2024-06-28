package com.solicitud.restapi.repositories;

import com.solicitud.restapi.models.SolicitudModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ISolicitudRepository extends JpaRepository<SolicitudModel, Long> {

    @Query("SELECT s FROM SolicitudModel s WHERE s.estado = :estado")
    ArrayList<SolicitudModel> findByState(String estado);
}