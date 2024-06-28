CREATE DATABASE dbsolicitud
USE dbsolicitud
CREATE TABLE usuario (
    id_usuario BIGINT IDENTITY(1,1) PRIMARY KEY,
    nombre_usuario NVARCHAR(255) NOT NULL,
    contrasena NVARCHAR(255) NOT NULL
);
CREATE TABLE solicitud (
    id_solicitud BIGINT IDENTITY(1,1) PRIMARY KEY,
    id_usuario_solicitante BIGINT NOT NULL,
    fecha_registro DATE NOT NULL,
    codigo NVARCHAR(255) NOT NULL,
    detalle NVARCHAR(1000) NOT NULL,
    modificado BIT DEFAULT 0 NOT NULL,
    estado NVARCHAR(50) DEFAULT 'activa' NOT NULL,
    FOREIGN KEY (id_usuario_solicitante) REFERENCES usuario(id_usuario)
);

CREATE TABLE solicitud_finalizada (
    id_finalizado BIGINT IDENTITY(1,1) PRIMARY KEY,
    id_solicitud BIGINT NOT NULL,
    id_usuario_finalizador BIGINT NOT NULL,
    fecha_finalizacion DATE NOT NULL,
    FOREIGN KEY (id_solicitud) REFERENCES solicitud(id_solicitud),
    FOREIGN KEY (id_usuario_finalizador) REFERENCES usuario(id_usuario)
);

CREATE TABLE solicitud_eliminada (
    id_eliminado BIGINT IDENTITY(1,1) PRIMARY KEY,
    id_solicitud BIGINT NOT NULL,
    id_usuario_eliminador BIGINT NOT NULL,
    motivo NVARCHAR(1000) NOT NULL,
    fecha_eliminacion DATE NOT NULL,
    FOREIGN KEY (id_solicitud) REFERENCES solicitud(id_solicitud),
    FOREIGN KEY (id_usuario_eliminador) REFERENCES usuario(id_usuario)
);


INSERT INTO usuario (nombre_usuario, contrasena) VALUES ('user1', 'password1');
INSERT INTO usuario (nombre_usuario, contrasena) VALUES ('user2', 'password2');
INSERT INTO usuario (nombre_usuario, contrasena) VALUES ('user3', 'password3');
INSERT INTO usuario (nombre_usuario, contrasena) VALUES ('user4', 'password4');
INSERT INTO usuario (nombre_usuario, contrasena) VALUES ('user5', 'password5');

INSERT INTO solicitud (id_usuario_solicitante, fecha_registro, codigo, detalle, modificado, estado) VALUES (1, '2023-06-01', 'C001', 'Detalle de solicitud 1', 0, 'finalizada');
INSERT INTO solicitud (id_usuario_solicitante, fecha_registro, codigo, detalle, modificado, estado) VALUES (2, '2023-06-02', 'C002', 'Detalle de solicitud 2', 0, 'finalizada');
INSERT INTO solicitud (id_usuario_solicitante, fecha_registro, codigo, detalle, modificado, estado) VALUES (3, '2023-06-03', 'C003', 'Detalle de solicitud 3', 0, 'finalizada');
INSERT INTO solicitud (id_usuario_solicitante, fecha_registro, codigo, detalle, modificado, estado) VALUES (4, '2023-06-04', 'C004', 'Detalle de solicitud 4', 0, 'eliminada');
INSERT INTO solicitud (id_usuario_solicitante, fecha_registro, codigo, detalle, modificado, estado) VALUES (5, '2023-06-05', 'C005', 'Detalle de solicitud 5', 0, 'eliminada');
INSERT INTO solicitud (id_usuario_solicitante, fecha_registro, codigo, detalle, modificado, estado) VALUES (4, '2023-06-04', 'C004', 'Detalle de solicitud 4', 0, 'activa');
INSERT INTO solicitud (id_usuario_solicitante, fecha_registro, codigo, detalle, modificado, estado) VALUES (5, '2023-06-05', 'C005', 'Detalle de solicitud 5', 0, 'activa');


INSERT INTO solicitud_finalizada (id_solicitud, id_usuario_finalizador, fecha_finalizacion) VALUES (1, 3, '2023-06-10');
INSERT INTO solicitud_finalizada (id_solicitud, id_usuario_finalizador, fecha_finalizacion) VALUES (2, 4, '2023-06-11');
INSERT INTO solicitud_finalizada (id_solicitud, id_usuario_finalizador, fecha_finalizacion) VALUES (3, 5, '2023-06-12');


INSERT INTO solicitud_eliminada (id_solicitud, id_usuario_eliminador, motivo, fecha_eliminacion) VALUES (4, 5, 'Eliminada por solicitud obsoleta', '2023-06-18');
INSERT INTO solicitud_eliminada (id_solicitud, id_usuario_eliminador, motivo, fecha_eliminacion) VALUES (5, 1, 'Eliminada por solicitud no necesaria', '2023-06-19');