/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.servicioexamen.services;

import co.edu.utp.isc.gia.servicioexamen.data.entity.Examen;
import co.edu.utp.isc.gia.servicioexamen.data.entity.HostExamen;
import co.edu.utp.isc.gia.servicioexamen.data.repository.HostExamenRepository;
import co.edu.utp.isc.gia.servicioexamen.exceptions.BadRequestException;
import co.edu.utp.isc.gia.servicioexamen.exceptions.HostExamenNotFoundException;
import co.edu.utp.isc.gia.servicioexamen.web.dto.ExamenDto;
import co.edu.utp.isc.gia.servicioexamen.web.dto.HostExamenDto;
import java.io.Serializable;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Chavarro
 */
@Service
public class EstudianteService implements Serializable{

    private HostExamenRepository ExamenRepository;
    private ModelMapper modelMapper = new ModelMapper();
    private HostExamenRepository hostExamenRepository;
    private ProfesorService profesorService;
    
    public EstudianteService(HostExamenRepository ExamenRepository, ModelMapper modelMapper) {
        this.hostExamenRepository = hostExamenRepository;
        this.ExamenRepository = ExamenRepository;
        this.modelMapper = modelMapper;
    }
    
    public boolean saveExamen (ExamenDto Examen, Long id){
        HostExamenDto hostExamen = profesorService.findOneHost(id);
         if (Examen != null){
            if(!Examen.getPreguntasDto().isEmpty()){
                Examen myExamen = modelMapper.map(Examen, Examen.class);
                return modelMapper.map(hostExamen, HostExamen.class).getExamenes().add(myExamen);
            }else{
                throw new BadRequestException("Preguntas nulas");
            }               
        }else {
            throw new BadRequestException("Examen nulo");
        }
    }
    
    public ExamenDto findExamenProfesor(Long id) {
        Optional<HostExamen> hostExamen =  hostExamenRepository.findById(id);
        if (hostExamen.isPresent()) {
            Examen examenProfesor = hostExamen.get().getExamenes().get(0);
            return modelMapper.map(examenProfesor, ExamenDto.class);
        }else{
            throw new HostExamenNotFoundException("No se pudo encontrar el host con el id :" + id);
        }
    }
}
