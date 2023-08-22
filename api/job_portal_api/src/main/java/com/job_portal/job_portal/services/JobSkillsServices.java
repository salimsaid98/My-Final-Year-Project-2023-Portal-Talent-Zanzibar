package com.job_portal.job_portal.services;

import com.job_portal.job_portal.repositories.JobSkillsRepository;
import com.job_portal.job_portal.specific.JobSkillsDTO;
import com.job_portal.job_portal.tables.job_skills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class JobSkillsServices {

    @Autowired
    public JobSkillsRepository jobSkillsRepository;

    public job_skills saveJobSkills(JobSkillsDTO dto){
        job_skills j = new job_skills();
        j.setSkill_id(dto.getSkill_id());
        j.setJob_post_id(dto.getJob_post_id());
        return jobSkillsRepository.save(j);
    }

    public Optional<job_skills> updateJobSkills(Integer id,JobSkillsDTO dto){
        return jobSkillsRepository.findById(id).map(target->{
            target.setSkill_id(dto.getSkill_id());
            target.setJob_post_id(dto.getJob_post_id());
            return target;
        });
    }

    public job_skills getJobSkillById(Integer id){
        Optional<job_skills> j = jobSkillsRepository.findById(id);
        if(j.isPresent()){
            return j.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Not found");
        }
    }
}
