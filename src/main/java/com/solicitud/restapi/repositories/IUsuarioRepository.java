package com.solicitud.restapi.repositories;

import com.solicitud.restapi.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<UsuarioModel, Long> {
}
