/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.servicioexamen.web.dto;

import co.edu.utp.isc.gia.servicioexamen.data.entity.Pregunta;
import java.io.Serializable;
import java.util.List;
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
@Builder
public class ExamenDto implements Serializable {
    
    private Long id;
    private String nombreEstudiante;
    private List<PreguntaDto> preguntasDto; 
    
}
