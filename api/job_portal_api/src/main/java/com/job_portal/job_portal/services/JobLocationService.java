package com.job_portal.job_portal.services;


import com.job_portal.job_portal.repositories.JobLocationRepository;
import com.job_portal.job_portal.specific.JobLocationDTO;
import com.job_portal.job_portal.tables.job_location;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobLocationService {
    @Autowired
    private JobLocationRepository jobLocationRepository;

    public job_location saveJob_location(JobLocationDTO dto){
        job_location j = new job_location();
        j.setCity(dto.getCity()); j.setStreet(dto.getStreet());
        j.setState(dto.getState()); j.setCountry(dto.getCountry());
        return jobLocationRepository.save(j);
    }

    @Transactional
    public Optional<job_location> update_job_location(Integer id,JobLocationDTO dto){
        return jobLocationRepository.findById(id).map(target->{
            target.setCountry(dto.getCountry());
            target.setCity(dto.getCity());
            target.setState(dto.getState());
            target.setStreet(dto.getStreet());
            return target;
        });
    }

    public List<job_location> getAllJobLocation(){
        List<job_location> j = jobLocationRepository.findAll();
        if (j.size() > 0){
            return j;
        }else{
            return new ArrayList<>();
        }
    }

    public job_location getJobLocationById(Integer id){
        Optional<job_location> j = jobLocationRepository.findById(id);
        if(j.isPresent()){
            return j.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No job location available");
        }
    }
}
