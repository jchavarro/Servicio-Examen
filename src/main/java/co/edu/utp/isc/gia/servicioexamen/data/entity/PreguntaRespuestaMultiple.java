/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.servicioexamen.data.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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
@DiscriminatorValue("2")
public class PreguntaRespuestaMultiple extends Pregunta implements Serializable{
    
    @OneToMany(mappedBy = "preguntaRespuestaMultiple", 
            cascade = CascadeType.ALL)
    private List<RespuestasCorrectas> respuestasCorrectas;
    
    @OneToMany(mappedBy = "preguntaRespuestaMultiple", 
            cascade = CascadeType.ALL)
    private List<RespuestasDadas> respuestasDadas;
}
