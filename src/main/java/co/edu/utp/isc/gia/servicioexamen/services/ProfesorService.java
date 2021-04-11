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
public class ProfesorService implements Serializable {
    
    private HostExamenRepository hostExamenRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public ProfesorService(HostExamenRepository hostExamenRepository, ModelMapper modelMapper) {
        this.hostExamenRepository = hostExamenRepository;
        this.modelMapper = modelMapper;
    }
    
    public HostExamenDto saveNewHost(ExamenDto Examen) {
        HostExamen hostExamen = new HostExamen();
        if (Examen != null){
            if(!Examen.getPreguntasDto().isEmpty()){
                Examen myExamen = modelMapper.map(Examen, Examen.class);
                hostExamen.getExamenes().add(myExamen);
                return modelMapper.map(hostExamen, HostExamenDto.class);
            }else{
                throw new BadRequestException("Preguntas nulas");
            }               
        }else {
            throw new BadRequestException("Examen nulo");
        }
    }
    
    public HostExamenDto findOneHost(Long id) {
        Optional<HostExamen> hostExamen = hostExamenRepository.findById(id);
        if (hostExamen.isPresent()) {
            return modelMapper.map(hostExamen.get(), HostExamenDto.class);
        }else{
            throw new HostExamenNotFoundException("No se pudo encontrar el host con el id :" + id);
        }
    }
    
    public HostExamenDto updateOneHost(Long id, HostExamenDto hostExamen) {
        hostExamen.setId(id);
        hostExamenRepository.save(modelMapper.map(hostExamen, HostExamen.class));
        return findOneHost(id);
    }
    
    public HostExamenDto removeOneHost(Long id) {
        Optional<HostExamen> hostExamen = hostExamenRepository.findById(id);
        HostExamenDto hostExamenDto = new HostExamenDto();
        if (hostExamen.isPresent()) {
            hostExamenDto = modelMapper.map(hostExamen, HostExamenDto.class);
            hostExamenRepository.deleteById(id);
            return hostExamenDto;
        }else {
            throw new HostExamenNotFoundException("No se pudo encontrar el host con el id :" + id);
        }
    }
    
}
