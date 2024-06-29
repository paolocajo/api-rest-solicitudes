package com.solicitud.restapi.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="solicitud_finalizada")
public class SolicitudFinalizadaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFinalizado;

    @OneToOne
    @JoinColumn(name = "idSolicitud", nullable = false)
    private SolicitudModel idSolicitud;

    @ManyToOne
    @JoinColumn(name = "idUsuarioFinalizador", nullable = false)
    @JsonProperty("idUsuarioFinalizador")
    private UsuarioModel idUsuario;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fechaFinalizacion;

    public Long getIdFinalizado() {
        return idFinalizado;
    }

    public void setIdFinalizado(Long idFinalizado) {
        this.idFinalizado = idFinalizado;
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

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }
}
