-- Sistema de información para la gestión de albergues, censo de familias afectadas
-- y trazabilidad de ayudas humanitarias en emergencias: caso Valle de Aburrá
-- Script de creación de la base de datos (DDL) para MySQL 8.
-- Generado desde el diccionario de datos (sección 1.8.1) y el modelo relacional (sección 3.1).
-- Versión 1.1 · 11 de noviembre de 2026 · Se versiona en Git al abrir la compuerta M2.

CREATE DATABASE IF NOT EXISTS albergues CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci;
USE albergues;

-- Alojamiento temporal habilitado para recibir hogares.
CREATE TABLE ALBERGUE (
  id_albergue INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(80) NOT NULL,
  direccion VARCHAR(120) NOT NULL,
  municipio VARCHAR(60) NOT NULL,
  capacidad_maxima INT NOT NULL,
  activo BOOLEAN NOT NULL DEFAULT TRUE,
  CONSTRAINT pk_albergue PRIMARY KEY (id_albergue),
  CONSTRAINT ck_albergue_capacidad_maxima CHECK (capacidad_maxima > 0)  -- RN-11
) ENGINE=InnoDB;

-- Persona que opera el sistema con uno de los tres roles.
CREATE TABLE USUARIO (
  id_usuario INT NOT NULL AUTO_INCREMENT,
  nombre_completo VARCHAR(120) NOT NULL,
  nombre_usuario VARCHAR(40) NOT NULL,
  clave_hash VARCHAR(255) NOT NULL,
  rol ENUM('FUNCIONARIO','COORDINADOR','ADMINISTRADOR') NOT NULL,
  id_albergue INT,
  activo BOOLEAN NOT NULL DEFAULT TRUE,
  CONSTRAINT pk_usuario PRIMARY KEY (id_usuario),
  CONSTRAINT uq_usuario_nombre_usuario UNIQUE (nombre_usuario)  -- RN-02
) ENGINE=InnoDB;

-- Unidad familiar afectada; unidad básica del censo.
CREATE TABLE HOGAR (
  id_hogar INT NOT NULL AUTO_INCREMENT,
  direccion VARCHAR(120) NOT NULL,
  barrio VARCHAR(80) NOT NULL,
  municipio VARCHAR(60) NOT NULL,
  telefono_contacto VARCHAR(10),
  fecha_registro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  estado_sincronizacion ENUM('SINCRONIZADO','PENDIENTE','CONFLICTO') NOT NULL DEFAULT 'SINCRONIZADO',
  id_usuario_registro INT NOT NULL,
  activo BOOLEAN NOT NULL DEFAULT TRUE,
  CONSTRAINT pk_hogar PRIMARY KEY (id_hogar),
  CONSTRAINT fk_hogar_id_usuario_registro FOREIGN KEY (id_usuario_registro) REFERENCES USUARIO (id_usuario) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB;

-- Persona que pertenece a un hogar censado.
CREATE TABLE INTEGRANTE (
  id_integrante INT NOT NULL AUTO_INCREMENT,
  id_hogar INT NOT NULL,
  tipo_documento ENUM('RC','TI','CC','CE','PA','PPT') NOT NULL,
  numero_documento VARCHAR(15) NOT NULL,
  nombres VARCHAR(60) NOT NULL,
  apellidos VARCHAR(60) NOT NULL,
  fecha_nacimiento DATE NOT NULL,
  activo BOOLEAN NOT NULL DEFAULT TRUE,
  CONSTRAINT pk_integrante PRIMARY KEY (id_integrante),
  CONSTRAINT uq_integrante_numero_documento UNIQUE (tipo_documento, numero_documento),  -- RN-07
  CONSTRAINT fk_integrante_id_hogar FOREIGN KEY (id_hogar) REFERENCES HOGAR (id_hogar) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB;

-- Condiciones de enfoque diferencial de un integrante (ninguna, una o varias).
CREATE TABLE INTEGRANTE_CONDICION (
  id_integrante INT NOT NULL,
  condicion ENUM('NINO','ADULTO_MAYOR','DISCAPACIDAD','GESTANTE','MINORIA_ETNICA') NOT NULL,
  CONSTRAINT pk_integrante_condicion PRIMARY KEY (id_integrante, condicion),
  CONSTRAINT fk_integrante_condicion_id_integrante FOREIGN KEY (id_integrante) REFERENCES INTEGRANTE (id_integrante) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB;

-- Estancia de un hogar en un albergue, desde su ingreso hasta su salida.
CREATE TABLE ASIGNACION_ALBERGUE (
  id_asignacion INT NOT NULL AUTO_INCREMENT,
  id_hogar INT NOT NULL,
  id_albergue INT NOT NULL,
  fecha_ingreso DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  fecha_salida DATETIME NOT NULL,
  id_usuario_asigna INT NOT NULL,
  id_usuario_salida INT,
  CONSTRAINT pk_asignacion_albergue PRIMARY KEY (id_asignacion),
  CONSTRAINT fk_asignacion_albergue_id_hogar FOREIGN KEY (id_hogar) REFERENCES HOGAR (id_hogar) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT fk_asignacion_albergue_id_albergue FOREIGN KEY (id_albergue) REFERENCES ALBERGUE (id_albergue) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT fk_asignacion_albergue_id_usuario_asigna FOREIGN KEY (id_usuario_asigna) REFERENCES USUARIO (id_usuario) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT fk_asignacion_albergue_id_usuario_salida FOREIGN KEY (id_usuario_salida) REFERENCES USUARIO (id_usuario) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB;

-- Catálogo de tipos de ayuda del inventario. Las existencias no se almacenan: se calculan (RN-20).
CREATE TABLE TIPO_AYUDA (
  id_tipo_ayuda INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(60) NOT NULL,
  unidad_medida VARCHAR(20) NOT NULL,
  activo BOOLEAN NOT NULL DEFAULT TRUE,
  CONSTRAINT pk_tipo_ayuda PRIMARY KEY (id_tipo_ayuda),
  CONSTRAINT uq_tipo_ayuda_nombre UNIQUE (nombre)  -- RN-19
) ENGINE=InnoDB;

-- Ingreso de ayuda al inventario con su procedencia. No se modifica ni se inactiva.
CREATE TABLE DONACION (
  id_donacion INT NOT NULL AUTO_INCREMENT,
  id_tipo_ayuda INT NOT NULL,
  cantidad INT NOT NULL,
  origen VARCHAR(120) NOT NULL,
  fecha_recepcion DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  id_usuario_registro INT NOT NULL,
  CONSTRAINT pk_donacion PRIMARY KEY (id_donacion),
  CONSTRAINT ck_donacion_cantidad CHECK (cantidad > 0),  -- RN-17
  CONSTRAINT fk_donacion_id_tipo_ayuda FOREIGN KEY (id_tipo_ayuda) REFERENCES TIPO_AYUDA (id_tipo_ayuda) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT fk_donacion_id_usuario_registro FOREIGN KEY (id_usuario_registro) REFERENCES USUARIO (id_usuario) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB;

-- Ayuda entregada a un beneficiario censado. No se modifica ni se inactiva.
CREATE TABLE ENTREGA (
  id_entrega INT NOT NULL AUTO_INCREMENT,
  id_integrante INT NOT NULL,
  id_tipo_ayuda INT NOT NULL,
  cantidad INT NOT NULL,
  fecha_hora DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  firma_beneficiario TEXT NOT NULL,
  id_usuario_responsable INT NOT NULL,
  CONSTRAINT pk_entrega PRIMARY KEY (id_entrega),
  CONSTRAINT ck_entrega_cantidad CHECK (cantidad > 0),  -- RN-17
  CONSTRAINT fk_entrega_id_integrante FOREIGN KEY (id_integrante) REFERENCES INTEGRANTE (id_integrante) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT fk_entrega_id_tipo_ayuda FOREIGN KEY (id_tipo_ayuda) REFERENCES TIPO_AYUDA (id_tipo_ayuda) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT fk_entrega_id_usuario_responsable FOREIGN KEY (id_usuario_responsable) REFERENCES USUARIO (id_usuario) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB;

-- Persona voluntaria identificada durante la emergencia.
CREATE TABLE VOLUNTARIO (
  id_voluntario INT NOT NULL AUTO_INCREMENT,
  tipo_documento ENUM('RC','TI','CC','CE','PA','PPT') NOT NULL,
  numero_documento VARCHAR(15) NOT NULL,
  nombres VARCHAR(60) NOT NULL,
  apellidos VARCHAR(60) NOT NULL,
  telefono VARCHAR(10) NOT NULL,
  id_usuario_registro INT NOT NULL,
  activo BOOLEAN NOT NULL DEFAULT TRUE,
  CONSTRAINT pk_voluntario PRIMARY KEY (id_voluntario),
  CONSTRAINT fk_voluntario_id_usuario_registro FOREIGN KEY (id_usuario_registro) REFERENCES USUARIO (id_usuario) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB;

-- Llave foránea del Coordinador hacia su albergue (RN-16).
ALTER TABLE USUARIO ADD CONSTRAINT fk_usuario_id_albergue FOREIGN KEY (id_albergue) REFERENCES ALBERGUE (id_albergue) ON DELETE RESTRICT ON UPDATE RESTRICT;
