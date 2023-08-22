package com.job_portal.job_portal.controllers;

import com.job_portal.job_portal.services.AppliedJobService;
import com.job_portal.job_portal.specific.AppliedJobsDTO;
import com.job_portal.job_portal.tables.applied_jobs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("job_portal/apply_job")
public class AppliedJobController {

    @Autowired
    private AppliedJobService appliedJobService;

    @PostMapping("/post_applied_job")
    private applied_jobs SaveAppliedJob(@RequestBody AppliedJobsDTO dto){
        return appliedJobService.SaveAppliedJob(dto);
    }

    @PutMapping("/updateAppliedJob/{id}")
    private Optional<applied_jobs> updateAppliedJob(@PathVariable("id") Integer id,@RequestBody AppliedJobsDTO dto){
        return appliedJobService.updateAppliedJob(id,dto);
    }

    @GetMapping("/getSpecificAppliedJob/{id}")
    private applied_jobs getSpecificAppliedJob(@PathVariable("id") Integer id){
        return appliedJobService.getSpecificAppliedJob(id);
    }

    @GetMapping("/getAllAppliedJobs")
    private List<applied_jobs> getAllAppliedJobs(){
        return appliedJobService.getAllAppliedJobs();
    }

    @GetMapping("/checkExisting/{seeker_id}/{job_post_id}")
    private ResponseEntity<applied_jobs> checkExisting(@PathVariable("seeker_id") Integer seeker_id,@PathVariable("job_post_id") Integer job_post_id){
        applied_jobs a = appliedJobService.checkExisting(seeker_id,job_post_id);
        if(a.getApply_id() == 0){
            return ResponseEntity.notFound().build();
        }else{
            return new ResponseEntity<>(a, HttpStatus.OK);
        }
    }
    @GetMapping("/getAppliedJobData/{seeker_id}/{job_post_id}")
    private ResponseEntity<applied_jobs> getAppliedJobData(@PathVariable("seeker_id") Integer seeker_id,@PathVariable("job_post_id") Integer job_post_id){
        applied_jobs a = appliedJobService.getAppliedJobData(seeker_id,job_post_id);
        if(a.getApply_id() == 0){
            return ResponseEntity.notFound().build();
        }else{
            return new ResponseEntity<>(a, HttpStatus.OK);
        }
    }
    @GetMapping("/getAllApplicantAppliedMyCompany/{company_id}")
    private List<Map<String, Objects>> getAllApplicantAppliedMyCompany(@PathVariable("company_id") int company_id){
        return appliedJobService.getAllApplicantAppliedMyCompany(company_id);
    }
    @GetMapping("/getAllSuccessApplicantAppliedMyCompany/{company_id}/{job_post_id}")
    private List<Map<String, Objects>> getAllSuccessApplicantAppliedMyCompany(@PathVariable("company_id") int company_id,@PathVariable("job_post_id") int job_post_id){
        return appliedJobService.getAllSuccessApplicantAppliedMyCompany(company_id,job_post_id);
    }

    @GetMapping("/countAllJobApplied/{seekerId}")
    private List<Map<String, Objects>> countAllJobApplied(@PathVariable("seekerId") int seekerId){
        return appliedJobService.countAllJobApplied(seekerId);
    }

    @GetMapping("/countAllSuccessJobApplied/{seekerId}")
    private List<Map<String, Objects>> countAllSuccessJobApplied(@PathVariable("seekerId") int seekerId){
        return appliedJobService.countAllSuccessJobApplied(seekerId);
    }
    @GetMapping("/countAllNotApprovedJobApplied/{seekerId}")
    private List<Map<String, Objects>> countAllNotApprovedJobApplied(@PathVariable("seekerId") int seekerId){
        return appliedJobService.countAllNotApprovedJobApplied(seekerId);
    }

    @GetMapping("/countAllApplicationSubmitted/{company_id}")
    private List<Map<String, Objects>> countAllApplicationSubmitted(@PathVariable("company_id") int company_id){
        return appliedJobService.countAllApplicationSubmitted(company_id);
    }

    @GetMapping("/countAllSuccessApplicationSubmitted/{company_id}")
    private List<Map<String, Objects>> countAllSuccessApplicationSubmitted(@PathVariable("company_id") int company_id){
        return appliedJobService.countAllSuccessApplicationSubmitted(company_id);
    }
    @GetMapping("/getAllApplicationIApplied/{seeker_id}")
    private List<Map<String, Objects>> getAllApplicationIApplied(@PathVariable("seeker_id") int seeker_id){
        return appliedJobService.getAllApplicationIApplied(seeker_id);
    }

}
