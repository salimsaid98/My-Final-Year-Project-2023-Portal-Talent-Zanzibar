package com.job_portal.job_portal.services;

import com.job_portal.job_portal.repositories.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
    @Autowired
    private ReportRepository reportRepository;


    public int cuntAllCompanies(){
        return reportRepository.CountAllCompanies();
    }

    public int countAllApplicant(){
        return reportRepository.countAllApplicant();
    }

    public int countAllJobPost(){
       return reportRepository.countAllJobPost();
    }
}
