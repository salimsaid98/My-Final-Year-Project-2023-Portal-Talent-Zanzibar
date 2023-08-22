package com.job_portal.job_portal.controllers;

import com.job_portal.job_portal.services.SkillServices;
import com.job_portal.job_portal.specific.SkillDTO;
import com.job_portal.job_portal.tables.skills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("job_portal/skills")
public class SkillController {

    @Autowired
    private SkillServices skillServices;

    @GetMapping("/getAllSkills")
    private ResponseEntity<List<skills>> getAllSkills(){
      List<skills> skill = skillServices.getAllSkills();
      return new ResponseEntity<List<skills>>(skill,HttpStatus.OK);
    }


    @PostMapping("/save")
    private skills saveSkill(@RequestBody SkillDTO skill){
       return skillServices.saveSkills(skill);
    }

    @PutMapping("/updateSkill/{id}")
    private Optional<skills> updateSkill(@PathVariable("id") Integer id, @RequestBody SkillDTO skill){
        return skillServices.updateSkills(id,skill);
    }

    @GetMapping("/skill_information/{id}")
    private skills getSkillInformation(@PathVariable("id") Integer id){
        return skillServices.getSkillsInformation(id);
    }
}
