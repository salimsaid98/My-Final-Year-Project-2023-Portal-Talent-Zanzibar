package com.job_portal.job_portal.services;

import com.job_portal.job_portal.repositories.SkillsRepository;
import com.job_portal.job_portal.specific.SkillDTO;
import com.job_portal.job_portal.tables.skills;
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
public class SkillServices {
    @Autowired
    private SkillsRepository skillsRepository;

    public List<skills> getAllSkills(){
        List<skills> skills = skillsRepository.findAll();
        if(skills.size() > 0){
            return skills;
        }else{
            return new ArrayList<>();
        }
    }

    public skills saveSkills(SkillDTO sk){
        skills s = new skills();
        s.setSkill_name(sk.getSkill_name());
        s.setStatus(sk.getStatus());
        if(skillsRepository.exists(Example.of(s))){
            throw new ResponseStatusException(HttpStatus.FOUND,"Exist Skill");
        }else{
           return skillsRepository.save(s);
        }
    }

    @Transactional
    public Optional<skills> updateSkills(int id,SkillDTO skill){
        return skillsRepository.findById(id).map(target->{
            target.setSkill_name(skill.getSkill_name());
            target.setStatus(skill.getStatus());
           return target;
        });
    }

    public skills getSkillsInformation(int id){
        Optional<skills> sk = skillsRepository.findById(id);
        if(sk.isPresent()){
            return sk.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"skill not found");
        }
    }

}
