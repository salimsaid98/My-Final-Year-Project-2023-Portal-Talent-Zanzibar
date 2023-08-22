package com.job_portal.job_portal.services;

import com.job_portal.job_portal.repositories.CompanyImageRepository;
import com.job_portal.job_portal.tables.CompanyLogo;
import com.job_portal.job_portal.utility.ImageUtility;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Data
public class CompanyImageService {
    @Autowired
    private final CompanyImageRepository companyImageRepository;
    public CompanyLogo getCompanyLogoImage(Integer company_id){
        Optional<CompanyLogo> logo = companyImageRepository.getCompanyLogoImage(company_id);
        if(logo.isPresent()){
            CompanyLogo companyLogo = new CompanyLogo();
            companyLogo.setCompany_id(logo.get().getCompany_id());
            companyLogo.setName(logo.get().getName());
            companyLogo.setLogo_id(logo.get().getLogo_id());
            companyLogo.setCompany_logos(logo.get().getCompany_logos());
            companyLogo.setImage_type(logo.get().getImage_type());
            return logo.get();
        }else {
            return new CompanyLogo();
        }
    }
}
