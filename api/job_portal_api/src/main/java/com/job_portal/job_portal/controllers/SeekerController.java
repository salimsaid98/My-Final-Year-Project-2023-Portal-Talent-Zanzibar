package com.job_portal.job_portal.controllers;


import com.job_portal.job_portal.services.SeekerServices;
import com.job_portal.job_portal.specific.SeekerDTO;
import com.job_portal.job_portal.tables.seeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/job_portal/seeker")
public class SeekerController {

    @Autowired
    private SeekerServices seekerServices;

    @GetMapping("/getAllSeekers")
    private List<seeker> List_of_Seekers(){
        return seekerServices.List_of_Seekers();
    }

    @GetMapping("/getSeekerById/{id}")
    private seeker getSeekerById(@PathVariable("id") Integer id){
        return seekerServices.getSeekerById(id);
    }

    @PostMapping("/saveSeeker")
    private seeker SaveSeeker(@RequestBody SeekerDTO dto){
        return seekerServices.saveSeeker(dto);
    }

    @PutMapping("/updateSeeker/{id}")
    private Optional<seeker> updateSeeker(@PathVariable("id") Integer id,@RequestBody SeekerDTO dto){
        return seekerServices.updateSeeker(id,dto);
    }

    @GetMapping("/getSeekerAllInformation/{user_information_id}")
    private List<Map<String, Objects>> getSeekerAllInformation(@PathVariable("user_information_id") Integer user_information_id){
        return seekerServices.getSeekerAllInformation(user_information_id);
    }

    @GetMapping("/getSeekerByUserInformationID/{user_information_id}")
    private seeker getSeekerByInformationID(@PathVariable("user_information_id") int user_information_id){
        return seekerServices.getSeekerByInformationID(user_information_id);

    }
}
