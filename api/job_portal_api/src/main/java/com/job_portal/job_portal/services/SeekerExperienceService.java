package com.job_portal.job_portal.services;


import com.job_portal.job_portal.repositories.SeekerExperienceRepository;
import com.job_portal.job_portal.specific.SeekerExperienceDTO;
import com.job_portal.job_portal.tables.seeker_experience;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SeekerExperienceService {

    @Autowired
    private SeekerExperienceRepository seekerExperienceRepository;

    public seeker_experience SaveSeekerExperience(SeekerExperienceDTO dto){
        seeker_experience s = new seeker_experience();
        s.setSeeker_id(dto.getSeeker_id()); s.setStart_date(dto.getStart_date());
        s.setEnd_date(dto.getEnd_date()); s.setIs_current_job(dto.getIs_current_job());
        s.setDescription(dto.getDescription());
        s.setCompany_name(dto.getCompany_name()); s.setLocation(dto.getLocation());
        s.setJob_tittle(dto.getJob_tittle());
        s.setPerson_in_charge_name(dto.getPerson_in_charge_name());
        s.setPerson_in_charge_address(dto.getPerson_in_charge_address());
        s.setPerson_in_charge_phone(dto.getPerson_in_charge_phone());
        return seekerExperienceRepository.save(s);
    }

    @Transactional
    public Optional<seeker_experience> updateSeekerExperience(Integer id,SeekerExperienceDTO dto){
        return seekerExperienceRepository.findById(id).map(s->{
            s.setSeeker_id(dto.getSeeker_id()); s.setStart_date(dto.getStart_date());
            s.setEnd_date(dto.getEnd_date()); s.setIs_current_job(dto.getIs_current_job());
            s.setDescription(dto.getDescription());
            s.setCompany_name(dto.getCompany_name()); s.setLocation(dto.getLocation());
            s.setJob_tittle(dto.getJob_tittle());
            s.setPerson_in_charge_name(dto.getPerson_in_charge_name());
            s.setPerson_in_charge_address(dto.getPerson_in_charge_address());
            s.setPerson_in_charge_phone(dto.getPerson_in_charge_phone());
            return s;
        });
    }

    public List<seeker_experience> list_of_seeker_experience(){
        List<seeker_experience> s =  seekerExperienceRepository.findAll();
        if(s.size() > 0){
            return s;
        }else{
            return new ArrayList<>();
        }
    }

    public seeker_experience getSeekerExperience(Integer id){
        Optional<seeker_experience> s = seekerExperienceRepository.findById(id);
        if(s.isPresent()){
            return s.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Not found");
        }
    }

    public List<seeker_experience> getAllSeekerExperienceForSpecificUser(Integer seeker_id){
        List<seeker_experience> s = seekerExperienceRepository.getAllSeekerExperienceForSpecificUser(seeker_id);
        if(s.size() > 0){
            return s;
        }else{
            return new ArrayList<>();
        }
    }
}
