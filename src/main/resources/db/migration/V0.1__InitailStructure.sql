/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Juan Chavarro
 * Created: 6/04/2021
 */
CREATE TABLE IF NOT EXISTS host_examen(
    id BIGINT AUTO_INCREMENT PRIMARY KEY);

CREATE TABLE IF NOT EXISTS examen(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_host_examen BIGINT NOT NULL,
    nombre_estudiante VARCHAR(255),
    FOREIGN KEY(id_host_examen) REFERENCES host_examen(id));

CREATE TABLE IF NOT EXISTS pregunta(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_examen BIGINT NOT NULL,
    descripcion VARCHAR(255),
    imagen VARCHAR(255),
    valor FLOAT,
    respuesta_correcta INT,
    respuesta_dada INT,
    respuesta_abierta VARCHAR(255),
    respuesta_calificada BOOLEAN,
    FOREIGN KEY (id_examen) REFERENCES examen(id));

CREATE TABLE IF NOT EXISTS respuestas(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_pregunta BIGINT NOT NULL,
    respuesta VARCHAR(255),
    FOREIGN KEY(id_pregunta) REFERENCES pregunta(id));

CREATE TABLE IF NOT EXISTS respuestas_correctas(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_pregunta BIGINT NOT NULL,
    respuesta_correcta INT,
    FOREIGN KEY(id_pregunta) REFERENCES pregunta(id));

CREATE TABLE IF NOT EXISTS respuestas_dadas(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_pregunta BIGINT NOT NULL,
    respuesta_dada INT,
    FOREIGN KEY(id_pregunta) REFERENCES pregunta(id));
