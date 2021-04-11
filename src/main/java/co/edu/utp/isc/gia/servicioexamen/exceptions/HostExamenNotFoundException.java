/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.servicioexamen.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Juan Chavarro
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class HostExamenNotFoundException extends RuntimeException{
    public HostExamenNotFoundException(String message) {
        super(message);
    }
}
