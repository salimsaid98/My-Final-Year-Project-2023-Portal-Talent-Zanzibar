package com.job_portal.job_portal.controllers;


import com.job_portal.job_portal.services.CompanyServices;
import com.job_portal.job_portal.specific.CompanyDTO;
import com.job_portal.job_portal.tables.company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("job_portal/company")
public class CompanyInformationController {
    @Autowired
    public CompanyServices companyServices;

    @PostMapping("/saveCompany")
    public company SaveCompany(@RequestBody CompanyDTO dto){
        return companyServices.SaveCompany(dto);
    }

    @PutMapping("/updateCompany/{company_id}")
    public Optional<company> modifyCompany(@PathVariable("company_id") int company_id,@RequestBody CompanyDTO dto){
        return companyServices.editCompany(company_id, dto);
    }
    @GetMapping("/getAllCompanies")
    public List<company> getAllCompanies(){
        return companyServices.getAllCompanies();
    }

    @GetMapping("/getCompanyById/{id}")
    public company getCompanyInformation(@PathVariable("id") Integer id){
        return companyServices.getCompanyInformation(id);
    }
    @GetMapping("/getCompanyInformationUsingUserId/{user_id}")
    public company getCompanyInformationUsingUserId(@PathVariable("user_id") Integer user_id){
        return companyServices.getCompanyInformationUsingUserId(user_id);
    }

}
