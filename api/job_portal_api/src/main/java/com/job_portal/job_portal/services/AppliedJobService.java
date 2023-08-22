package com.job_portal.job_portal.services;

import com.job_portal.job_portal.repositories.AppliedJobRepository;
import com.job_portal.job_portal.specific.AppliedJobsDTO;
import com.job_portal.job_portal.tables.applied_jobs;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class AppliedJobService {

    @Autowired
    public AppliedJobRepository appliedJobRepository;


    public applied_jobs SaveAppliedJob(AppliedJobsDTO dto){
        applied_jobs a = new applied_jobs();
        a.setApplied_date(dto.getApplied_date());
        a.setJob_post_id(dto.getJob_post_id());
        a.setSeeker_id(dto.getSeeker_id());
        a.setStatus(0);
        return appliedJobRepository.save(a);
    }

    @Transactional
    public Optional<applied_jobs> updateAppliedJob(Integer id,AppliedJobsDTO dto){
        return appliedJobRepository.findById(id).map(a->{
            a.setApplied_date(dto.getApplied_date());
            a.setJob_post_id(dto.getJob_post_id());
            a.setSeeker_id(dto.getSeeker_id());
            a.setStatus(dto.getStatus());
            a.setConfirmed_date(dto.getConfirmed_date());
            return a;
        });
    }

    public applied_jobs getSpecificAppliedJob(Integer id){
        Optional<applied_jobs> a = appliedJobRepository.findById(id);
        if(a.isPresent()){
            return a.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Not found");
        }
    }

    public List<applied_jobs> getAllAppliedJobs(){
        List<applied_jobs> a = appliedJobRepository.findAll();
        if(!a.isEmpty()){
            return a;
        }else{
            return new ArrayList<>();
        }
    }
    public applied_jobs checkExisting(Integer seeker_id,Integer job_post_id){
        Optional<applied_jobs> a = appliedJobRepository.checkExisting(seeker_id,job_post_id);
        return a.orElse(new applied_jobs());
    }
    public applied_jobs getAppliedJobData(Integer seeker_id,Integer job_post_id){
        Optional<applied_jobs> a = appliedJobRepository.getAppliedJobData(seeker_id,job_post_id);
        return a.orElse(new applied_jobs());
    }

    public List<Map<String, Objects>> getAllApplicantAppliedMyCompany(int company_id){
        List<Map<String, Objects>> a = appliedJobRepository.getAllApplicantAppliedMyCompany(company_id);
        if(!a.isEmpty()){
            return a;
        }else{
            return new ArrayList<>();
        }
    }

    public List<Map<String, Objects>> getAllSuccessApplicantAppliedMyCompany(int company_id,int job_post_id){
        List<Map<String, Objects>> a = appliedJobRepository.getAllSuccessApplicantAppliedMyCompany(company_id,job_post_id);
        if(!a.isEmpty()){
            return a;
        }else{
            return new ArrayList<>();
        }
    }

    public List<Map<String, Objects>> countAllJobApplied(int seeker_id){
        List<Map<String, Objects>> a = appliedJobRepository.countAllJobApplied(seeker_id);
        if(!a.isEmpty()){
            return a;
        }else{
            return new ArrayList<>();
        }
    }

    public List<Map<String, Objects>> countAllSuccessJobApplied(int seeker_id){
        List<Map<String, Objects>> a = appliedJobRepository.countAllSuccessJobApplied(seeker_id);
        if(!a.isEmpty()){
            return a;
        }else{
            return new ArrayList<>();
        }
    }

    public List<Map<String, Objects>> countAllNotApprovedJobApplied(int seeker_id){
        List<Map<String, Objects>> a = appliedJobRepository.countAllNotApprovedJobApplied(seeker_id);
        if(!a.isEmpty()){
            return a;
        }else{
            return new ArrayList<>();
        }
    }
    public List<Map<String, Objects>> countAllApplicationSubmitted(int company_id){
        List<Map<String, Objects>> a = appliedJobRepository.countAllApplicationSubmitted(company_id);
        if(!a.isEmpty()){
            return a;
        }else{
            return new ArrayList<>();
        }
    }

    public List<Map<String, Objects>> countAllSuccessApplicationSubmitted(int company_id){
        List<Map<String, Objects>> a = appliedJobRepository.countAllSuccessApplicationSubmitted(company_id);
        if(!a.isEmpty()){
            return a;
        }else{
            return new ArrayList<>();
        }
    }
    public List<Map<String, Objects>> getAllApplicationIApplied(int seeker_id){
        List<Map<String, Objects>> a = appliedJobRepository.getAllApplicationIApplied(seeker_id);
        if(!a.isEmpty()){
            return a;
        }else{
            return new ArrayList<>();
        }
    }

}
