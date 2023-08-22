package com.job_portal.job_portal.services;

import com.job_portal.job_portal.repositories.EducationDetailsRepository;
import com.job_portal.job_portal.specific.EducationDetailsDTO;
import com.job_portal.job_portal.tables.education_details;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EducationDetailsServices {

    @Autowired
    private EducationDetailsRepository educationDetailsRepository;

    public education_details SaveEducationDetails(EducationDetailsDTO dto){
        education_details e = new education_details();
        e.setSeeker_id(dto.getSeeker_id());
        e.setCountry(dto.getCountry());
        e.setUser_id(dto.getUser_id()); e.setGpa(dto.getGpa());
        e.setCertificate_level_name(dto.getCertificate_level_name());
        e.setInstitute_name(dto.getInstitute_name());
        e.setFaculty(dto.getFaculty()); e.setAcademic_year(dto.getAcademic_year());
        e.setStarting_date(dto.getStarting_date());
        e.setEnd_date(dto.getEnd_date());
        return educationDetailsRepository.save(e);
    }

    public education_details getEducationDetailsById(Integer id){
        Optional<education_details> e = educationDetailsRepository.findById(id);
        if(e.isPresent()){
            return e.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No data found");
        }
    }

    @Transactional
    public Optional<education_details> updateEducationDetails(Integer id,EducationDetailsDTO dto){
        return educationDetailsRepository.findById(id).map(e->{
            e.setUser_id(dto.getUser_id()); e.setGpa(dto.getGpa());
            e.setCertificate_level_name(dto.getCertificate_level_name());
            e.setInstitute_name(dto.getInstitute_name());
            e.setFaculty(dto.getFaculty()); e.setAcademic_year(dto.getAcademic_year());
            e.setStarting_date(dto.getStarting_date());
            e.setEnd_date(dto.getEnd_date());
            e.setSeeker_id(dto.getSeeker_id());
            e.setCountry(dto.getCountry());
            return e;
        });
    }

    public List<education_details> list_of_education_details(){
        List<education_details> l = educationDetailsRepository.findAll();
        if(l.size() > 0){
            return l;
        }else{
            return new ArrayList<>();
        }
    }
    public List<education_details> list_of_education_details_for_this_user(Integer user_id){
        List<education_details> l = educationDetailsRepository.list_of_education_details_for_this_user(user_id);
        if(l.size() > 0){
            return l;
        }else{
            return new ArrayList<>();
        }
    }

}
