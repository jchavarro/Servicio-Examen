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
public class PreguntaRespuestaUnicaDto extends PreguntaDto implements Serializable {
    
    private int respuestaCorrecta;
    private int respuestaDada;

    public int getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(int respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public int getRespuestaDada() {
        return respuestaDada;
    }

    public void setRespuestaDada(int respuestaDada) {
        this.respuestaDada = respuestaDada;
    }
    
}
