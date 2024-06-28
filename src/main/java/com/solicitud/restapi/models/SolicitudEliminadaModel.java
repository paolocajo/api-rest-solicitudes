package com.solicitud.restapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="solicitud_eliminada")
public class SolicitudEliminadaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEliminado;

    @OneToOne
    @JoinColumn(name = "idSolicitud", nullable = false)
    private SolicitudModel idSolicitud;

    @ManyToOne
    @JoinColumn(name = "idUsuarioEliminador", nullable = false)
    @JsonProperty("idUsuarioEliminador")
    private UsuarioModel idUsuario;

    @Column(nullable = false)
    private String motivo;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fechaEliminacion;

    public Long getIdEliminado() {
        return idEliminado;
    }

    public void setIdEliminado(Long idEliminado) {
        this.idEliminado = idEliminado;
    }

    public SolicitudModel getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(SolicitudModel idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public UsuarioModel getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UsuarioModel idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getFechaEliminacion() {
        return fechaEliminacion;
    }

    public void setFechaEliminacion(Date fechaEliminacion) {
        this.fechaEliminacion = fechaEliminacion;
    }
}
