package com.job_portal.job_portal.services;


import com.job_portal.job_portal.repositories.SeekerSkillRepository;
import com.job_portal.job_portal.specific.SeekerSkillDTO;
import com.job_portal.job_portal.tables.seeker_skills;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SeekerSkillService {

    @Autowired
    private SeekerSkillRepository seekerSkillRepository;

    public seeker_skills saveSeekerSkills(SeekerSkillDTO dto){
        seeker_skills seeker = new seeker_skills();
        seeker.setSeeker_id(dto.getSeeker_id());
        seeker.setSkill_name(dto.getSkill_name());
        return seekerSkillRepository.save(seeker);
    }

    public List<seeker_skills> getAllSeekerSkillsOfSeeker(Integer seeker_id){
        List<seeker_skills> s = seekerSkillRepository.getAllSeekerSkillsOfSeeker(seeker_id);
        if(s.size() > 0){
            return s;
        }else{
            return new ArrayList<>();
        }
    }

    @Transactional
    public Optional<seeker_skills> updateSeekerSkills(Integer id,SeekerSkillDTO dto){
        return seekerSkillRepository.findById(id).map(seeker->{
            seeker.setSeeker_id(dto.getSeeker_id());
            seeker.setSkill_name(dto.getSkill_name());
            return seeker;
        });
    }

    public seeker_skills getSeekerSkillsById(Integer id){
        Optional<seeker_skills> s = seekerSkillRepository.findById(id);
        if(s.isPresent()){
            return s.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Not found");
        }
    }
}
