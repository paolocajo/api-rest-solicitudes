package com.solicitud.restapi.repositories;

import com.solicitud.restapi.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;
public interface IUsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    @Query("SELECT u FROM UsuarioModel u WHERE u.nombreUsuario = :username AND u.contrasena = :password")
    Optional<UsuarioModel> findByNombreUsuarioAndContrasena(@Param("username") String username, @Param("password") String password);
}
