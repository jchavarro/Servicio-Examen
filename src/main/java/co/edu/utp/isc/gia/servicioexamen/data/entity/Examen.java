/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.servicioexamen.data.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Table(name = "examen")
public class Examen implements Serializable {
    
    @Id
    private Long id;
    
    @Column(name = "nombre_estudiante")
    private String nombreEstudiante;
    
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "id_host_examen")
    private HostExamen hostExamen;
    
    @OneToMany(mappedBy = "examen",
            cascade = CascadeType.ALL)
    private List<Pregunta> preguntas; 
}
