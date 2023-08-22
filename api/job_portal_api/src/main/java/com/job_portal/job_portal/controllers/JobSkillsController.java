package com.job_portal.job_portal.controllers;

import com.job_portal.job_portal.services.JobSkillsServices;
import com.job_portal.job_portal.specific.JobSkillsDTO;
import com.job_portal.job_portal.tables.job_skills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("job_portal/job_skills")
public class JobSkillsController {

    @Autowired
    private JobSkillsServices jobSkillsServices;

    @PostMapping("/save_job_skill")
    private job_skills saveJobSkill(@RequestBody JobSkillsDTO dto){
        return jobSkillsServices.saveJobSkills(dto);
    }

    @PutMapping("/update_job_skill/{id}")
    private Optional<job_skills> update_job_skill(@PathVariable("id") Integer id,@RequestBody JobSkillsDTO dto){
        return jobSkillsServices.updateJobSkills(id,dto);
    }

    @GetMapping("/get_job-skill_by_id/{id}")
    private job_skills getJobSkillById(@PathVariable("id") Integer id){
        return jobSkillsServices.getJobSkillById(id);
    }
}
