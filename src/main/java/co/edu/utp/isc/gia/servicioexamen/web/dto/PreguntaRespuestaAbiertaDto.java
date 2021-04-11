/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.servicioexamen.web.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Juan Chavarro
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PreguntaRespuestaAbiertaDto extends PreguntaDto implements Serializable {
    
    private String respuestaAbierta;
    private boolean respuestaCalificada;
    
}
