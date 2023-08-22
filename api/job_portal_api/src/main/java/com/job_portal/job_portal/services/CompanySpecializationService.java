package com.job_portal.job_portal.services;


import com.job_portal.job_portal.repositories.CompanySpecializationRepository;
import com.job_portal.job_portal.specific.CompanySpecializationDTO;
import com.job_portal.job_portal.tables.company_specialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class CompanySpecializationService {

    @Autowired
    private CompanySpecializationRepository companySpecializationRepository;

    public company_specialization SaveCompanySpecialization(CompanySpecializationDTO dto){
        company_specialization c = new company_specialization();
        c.setCompany_id(dto.getCompany_id());
        c.setSpecialization_id(dto.getSpecialization_id());
        return companySpecializationRepository.save(c);
    }

    public List<Map<String, Objects>> getAllCompanySpecializationForSpecificCompany(Integer user_id){
        List<Map<String, Objects>> c = companySpecializationRepository.getAllCompanySpecializationForSpecificCompany(user_id);
        if(c.size() > 0){
            return c;
        }else{
            return new ArrayList<>();
        }
    }
}
