/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.servicioexamen.web.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 *
 * @author Juan Chavarro
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
class RespuestasCorrectasDto {

    private Long id;
    private int respuestaCorrecta;
    
}
