package com.job_portal.job_portal.controllers;


import com.job_portal.job_portal.services.CompanySpecializationService;
import com.job_portal.job_portal.specific.CompanySpecializationDTO;
import com.job_portal.job_portal.tables.company_specialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@CrossOrigin
@RequestMapping("job_portal/company_specialization")
public class CompanySpecializationController {

    @Autowired
    private CompanySpecializationService companySpecializationService;

    @PostMapping("/saveCompanySpecialization")
    private company_specialization SaveCompanySpecialization(@RequestBody CompanySpecializationDTO dto){
        return companySpecializationService.SaveCompanySpecialization(dto);
    }

    @GetMapping("/getAllCompanySpecializationForSpecificCompany/{user_id}")
    private List<Map<String, Objects>> getAllCompanySpecializationForSpecificCompany(@PathVariable("user_id") Integer user_id){
        return companySpecializationService.getAllCompanySpecializationForSpecificCompany(user_id);
    }
}
