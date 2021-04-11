/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.servicioexamen.data.entity;

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
@DiscriminatorValue("3")
public class PreguntaRespuestaAbierta extends Pregunta{
    
    @Column(name = "respuesta_abierta")
    private String respuestaAbierta;
            
    @Column(name = "respuesta_calificada")
    private boolean respuestaCalificada;
}
