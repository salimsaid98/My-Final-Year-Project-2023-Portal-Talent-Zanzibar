package com.job_portal.job_portal.services;

import com.job_portal.job_portal.repositories.JobTypeRepository;
import com.job_portal.job_portal.specific.JobTypeDTO;
import com.job_portal.job_portal.tables.job_type;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobTypeService {
    @Autowired
    private JobTypeRepository jobTypeRepository;

    public job_type saveJobType(JobTypeDTO jobTypeDTO){
        job_type j = new job_type();
        j.setJob_type(jobTypeDTO.getJob_type());
        return jobTypeRepository.save(j);
    }

    @Transactional
    public Optional<job_type> update_job_type(Integer id,JobTypeDTO dto){
        return jobTypeRepository.findById(id).map(target->{
            target.setJob_type(dto.getJob_type());
            return target;
        });
    }

    public List<job_type> getAllJobType(){
        List<job_type> j = jobTypeRepository.findAll();
        if(j.size() > 0){
            return j;
        }else{
            return new ArrayList<>();
        }
    }

    public job_type getJobTypeById(Integer id){
        Optional<job_type> j = jobTypeRepository.findById(id);
        if(j.isPresent()){
            return j.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Job Type not found");
        }
    }

}
