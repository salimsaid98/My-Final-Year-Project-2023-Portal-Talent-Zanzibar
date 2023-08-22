package com.job_portal.job_portal.services;


import com.job_portal.job_portal.repositories.JobPostRepository;
import com.job_portal.job_portal.specific.JobPostDTO;
import com.job_portal.job_portal.tables.job_post;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class JobPostServices {

    @Autowired
    public JobPostRepository jobPostRepository;


    public job_post SaveJobPost(JobPostDTO dto){
        job_post j = new job_post();
        j.setJob_type_id(dto.getJob_type_id());
        j.setJob_tittle(dto.getJob_tittle());
        j.setJob_category(dto.getJob_category());
        j.setJob_location_id(dto.getJob_location_id());
        j.setCompany_id(dto.getCompany_id());
        j.setPosted_by(dto.getPosted_by());
        j.setJob_description(dto.getJob_description());
        j.setStarting_date(dto.getStarting_date());
        j.setEnd_date(dto.getEnd_date());
        j.setSalary_information(dto.getSalary_information());
        j.setExperience_level(dto.getExperience_level());
        j.setKey_responsibilities(dto.getKey_responsibilities());
        j.setMinimum_requirement(dto.getMinimum_requirement());
        j.setRequired_people(dto.getRequired_people());
        j.setStatus(1);
        return jobPostRepository.save(j);
    }

    public job_post getJobPostByID(Integer id){
        Optional<job_post> j = jobPostRepository.findById(id);
        if(j.isPresent()){
            return j.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Job was not found");
        }
    }

    public List<job_post> List_of_job_post(){
        List<job_post> j = jobPostRepository.findAll();
        if(j.size() > 0){
            return j;
        }else{
            return new ArrayList<>();
        }
    }

    @Transactional
    public Optional<job_post> update_job_post(Integer id,JobPostDTO dto){
        return jobPostRepository.findById(id).map(j->{
            j.setJob_type_id(dto.getJob_type_id());
            j.setJob_location_id(dto.getJob_location_id());
            j.setCompany_id(dto.getCompany_id());
            j.setPosted_by(dto.getPosted_by());
            j.setJob_category(dto.getJob_category());
            j.setJob_description(dto.getJob_description());
            j.setStarting_date(dto.getStarting_date());
            j.setEnd_date(dto.getEnd_date());
            j.setJob_tittle(dto.getJob_tittle());
            j.setStatus(dto.getStatus());
            j.setSalary_information(dto.getSalary_information());
            j.setExperience_level(dto.getExperience_level());
            j.setKey_responsibilities(dto.getKey_responsibilities());
            j.setMinimum_requirement(dto.getMinimum_requirement());
            j.setRequired_people(dto.getRequired_people());
            return j;
        });
    }

    public List<job_post> getAllJobPostStatusTrue(){
        List<job_post> j = jobPostRepository.getAllJobPostStatusTrue();
        if(j.size() > 0){
            return j;
        }else{
            return new ArrayList<>();
        }
    }

    public List<job_post> getAllJobPostSpecificCompany(Integer company_id){
        List<job_post> j = jobPostRepository.getAllJobPostSpecificCompany(company_id);
        if(j.size() > 0){
            return j;
        }else{
            return new ArrayList<>();
        }
    }
    public List<Map<String,Objects>> getAllJobPostSpecificCompany2(Integer company_id){
        List<Map<String,Objects>> j = jobPostRepository.getAllJobPostSpecificCompany2(company_id);
        if(j.size() > 0){
            return j;
        }else{
            return new ArrayList<>();
        }
    }
    public List<Map<String,Objects>> getAllJobPostWithInformation(){
        List<Map<String,Objects>> j = jobPostRepository.getAllJobPostWithInformation();
        if(j.size() > 0){
            return j;
        }else{
            return new ArrayList<>();
        }
    }

    public List<Map<String,Objects>> getAllJobPostSpecificCompanyByJobPostId(Integer job_post_id){
        List<Map<String,Objects>> j = jobPostRepository.getAllJobPostSpecificCompanyByJobPostId(job_post_id);
        if(j.size() > 0){
            return j;
        }else{
            return new ArrayList<>();
        }
    }



    public List<Map<String, Objects>> countAllJobsPostForSpecificCompany(Integer company_id){
        List<Map<String,Objects>> c = jobPostRepository.countAllJobsPostForSpecificCompany(company_id);
        if(c.size() > 0){
            return c;
        }else{
            return new ArrayList<>();
        }
    }
    public List<Map<String, Objects>> getAllJobPostGroupByType(){
        List<Map<String,Objects>> c = jobPostRepository.getAllJobPostGroupByType();
        if(c.size() > 0){
            return c;
        }else{
            return new ArrayList<>();
        }
    }

    public List<Map<String,Objects>> SearchAllJobPostSpecificCompany(Integer company_id,String title){
        List<Map<String,Objects>> j = jobPostRepository.SearchAllJobPostSpecificCompany(company_id,title);
        if(j.size() > 0){
            return j;
        }else{
            return new ArrayList<>();
        }
    }
    public List<Map<String,Objects>> SearchAllJobPost(String title){
        List<Map<String,Objects>> j = jobPostRepository.SearchAllJobPost(title);
        if(j.size() > 0){
            return j;
        }else{
            return new ArrayList<>();
        }
    }
    public List<Map<String,Objects>> getJobsByExperienceAndCompany(int company_id,String experience){
        List<Map<String,Objects>> j = jobPostRepository.getJobsByExperienceAndCompany(company_id,experience);
        if(j.size() > 0){
            return j;
        }else{
            return new ArrayList<>();
        }
    }
    public List<Map<String,Objects>> getJobsByExperienceAndCompanyAndCategory(int company_id,String experience,String category){
        List<Map<String,Objects>> j = jobPostRepository.getJobsByExperienceAndCompanyAndCategory(company_id,experience,category);
        if(j.size() > 0){
            return j;
        }else{
            return new ArrayList<>();
        }
    }
    public List<Map<String,Objects>> getJobsByExperienceAndCompanyAndCategoryAndType(int company_id,String experience,String category,int type_id){
        List<Map<String,Objects>> j = jobPostRepository.getJobsByExperienceAndCompanyAndCategoryAndType(company_id,experience,category,type_id);
        if(j.size() > 0){
            return j;
        }else{
            return new ArrayList<>();
        }
    }

    public List<Map<String,Objects>> getJobsByTypeNameAndCompany(int company_id,String type_name){
        List<Map<String,Objects>> j = jobPostRepository.getJobsByTypeNameAndCompany(company_id,type_name);
        if(j.size() > 0){
            return j;
        }else{
            return new ArrayList<>();
        }
    }

    public List<Map<String,Objects>> getJobsByTypeName(String type_name){
        List<Map<String,Objects>> j = jobPostRepository.getJobsByTypeName(type_name);
        if(j.size() > 0){
            return j;
        }else{
            return new ArrayList<>();
        }
    }
}
