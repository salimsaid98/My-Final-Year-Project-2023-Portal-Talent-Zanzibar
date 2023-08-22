package com.job_portal.job_portal.services;

import com.job_portal.job_portal.repositories.SpecializationRepository;
import com.job_portal.job_portal.specific.SpecializationDTO;
import com.job_portal.job_portal.tables.specialization;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SpecializationService {
    @Autowired
    public SpecializationRepository specializationRepository;

    public specialization SaveSpecialization(SpecializationDTO dto){
        specialization s = new specialization();
        s.setSpecialization_name(dto.getSpecialization_name());
        if(specializationRepository.exists(Example.of(s))){
            throw new ResponseStatusException(HttpStatus.FOUND,"Specialization Exist");
        }else{
            return specializationRepository.save(s);
        }
    }

    public specialization getSpecializationById(Integer id){
        Optional<specialization> s = specializationRepository.findById(id);
        if(s.isPresent()){
            return s.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Specialization Not found");
        }
    }

    public List<specialization> getAllSpecialization(){
        List<specialization> s = specializationRepository.findAll();
        if(s.size() > 0){
            return s;
        }else{
           return new ArrayList<>();
        }
    }

    @Transactional
    public Optional<specialization> updateSpecialization(Integer id, SpecializationDTO dto){
        return specializationRepository.findById(id).map(target->{
            target.setSpecialization_name(dto.getSpecialization_name());
            return target;
        });
    }
}
