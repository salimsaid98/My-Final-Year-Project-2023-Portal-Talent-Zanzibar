package com.job_portal.job_portal.controllers;


import com.job_portal.job_portal.services.SeekerSkillService;
import com.job_portal.job_portal.specific.SeekerSkillDTO;
import com.job_portal.job_portal.tables.seeker_skills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/job_portal/seeker_skill")
public class SeekerSkillsController {

    @Autowired
    private SeekerSkillService seekerSkillService;

    @PostMapping("/saveSeekerSkills")
    private seeker_skills SaveSeekerSkills(@RequestBody SeekerSkillDTO dto){
        return seekerSkillService.saveSeekerSkills(dto);
    }

    @PutMapping("/update_seeker_skill/{id}")
    private Optional<seeker_skills> UpdateSeekerSkills(@PathVariable("id") Integer id,@RequestBody SeekerSkillDTO dto){
        return seekerSkillService.updateSeekerSkills(id,dto);
    }

    @GetMapping("/getSeekerSkillsByID/{id}")
    private seeker_skills GetSeekerSkillsByID(@PathVariable("id") Integer id){
        return seekerSkillService.getSeekerSkillsById(id);
    }

    @GetMapping("/getAllSeekerSkillsOfSeeker/{seeker_id}")
    private List<seeker_skills> getAllSeekerSkillsOfSeeker(@PathVariable("seeker_id") Integer seeker_id){
        return seekerSkillService.getAllSeekerSkillsOfSeeker(seeker_id);
    }

}
