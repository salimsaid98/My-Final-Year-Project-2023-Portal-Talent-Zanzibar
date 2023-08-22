package com.job_portal.job_portal.controllers;


import com.job_portal.job_portal.services.SeekerExperienceService;
import com.job_portal.job_portal.specific.SeekerExperienceDTO;
import com.job_portal.job_portal.tables.seeker_experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/job_portal/seeker_experience")
public class SeekerExperienceController {

    @Autowired
    private SeekerExperienceService seekerExperienceService;


    @PostMapping("/saveSeekerExperience")
    private seeker_experience saveSeekerExperience(@RequestBody SeekerExperienceDTO dto){
      return seekerExperienceService.SaveSeekerExperience(dto);
    }

    @PutMapping("/updateSeekerExperience/{id}")
    private Optional<seeker_experience> updateSeekerExperience(@PathVariable("id") Integer id,@RequestBody SeekerExperienceDTO dto){
        return seekerExperienceService.updateSeekerExperience(id,dto);
    }

    @GetMapping("getSeekerExperienceByID/{id}")
    private seeker_experience getSeekerExperience(@PathVariable("id") Integer id){
        return seekerExperienceService.getSeekerExperience(id);
    }

    @GetMapping("/getAllSeekerExperience")
    private List<seeker_experience> list_of_seeker_experience(){
        return seekerExperienceService.list_of_seeker_experience();
    }

    @GetMapping("/getAllSeekerExperienceForSpecificUser/{seeker_id}")
    private List<seeker_experience> getAllSeekerExperienceForSpecificUser(@PathVariable("seeker_id") Integer seeker_id){
        return seekerExperienceService.getAllSeekerExperienceForSpecificUser(seeker_id);
    }
}
