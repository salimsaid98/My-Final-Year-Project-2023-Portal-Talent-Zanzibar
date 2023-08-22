package com.job_portal.job_portal.controllers;

import com.job_portal.job_portal.services.SpecializationService;
import com.job_portal.job_portal.specific.SpecializationDTO;
import com.job_portal.job_portal.tables.specialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("job_portal/specialization")
public class SpecializationController {

    @Autowired
    private SpecializationService specializationService;

    @PostMapping("/saveSpecialization")
    private specialization SaveSpecialization(@RequestBody SpecializationDTO specializationDTO){
            return specializationService.SaveSpecialization(specializationDTO);
    }

    @GetMapping("/getSpecializationById/{id}")
    private specialization getSpecializationById(@PathVariable("id") Integer id){
        return specializationService.getSpecializationById(id);
    }

    @GetMapping("/getAllSpecialization")
    private List<specialization> getAllSpecialization(){
        return specializationService.getAllSpecialization();
    }

    @PutMapping("/updateSpecialization/{id}")
    private Optional<specialization> updateSpecialization(@PathVariable("id") Integer id, @RequestBody SpecializationDTO specializationDTO){
        return specializationService.updateSpecialization(id,specializationDTO);
    }
}
