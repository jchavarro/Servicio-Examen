/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.servicioexamen.data.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Juan Chavarro
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("1")
public class PreguntaRespuestaUnica extends Pregunta implements Serializable {
    
    @Column(name = "respuesta_correcta")
    private int respuestaCorrecta;
    
    @Column(name = "respuesta_dada")
    private int respuestaDada;
        
}
