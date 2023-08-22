package com.job_portal.job_portal.controllers;

import com.job_portal.job_portal.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("job_portal/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/countCompanies")
    private int cuntAllCompanies(){
        return reportService.cuntAllCompanies();
    }

    @GetMapping("/countAllApplicant")
    private int countAllApplicant(){
        return reportService.countAllApplicant();
    }

    @GetMapping("/countAllJobPost")
    private int countAllJobPost(){
        return reportService.countAllJobPost();
    }
}
