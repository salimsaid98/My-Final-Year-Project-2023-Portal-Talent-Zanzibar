package com.job_portal.job_portal.controllers;

import com.job_portal.job_portal.services.JobPostServices;
import com.job_portal.job_portal.specific.JobPostDTO;
import com.job_portal.job_portal.tables.job_post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("job_portal/job_post")
public class JobPostController {
    @Autowired
    private JobPostServices jobPostServices;

    @PostMapping("/save_job_post")
    private job_post SaveJobPost(@RequestBody JobPostDTO dto){
        return jobPostServices.SaveJobPost(dto);
    }

    @PutMapping("/update_job_post/{id}")
    private Optional<job_post> update_job_post(@PathVariable("id") Integer id,@RequestBody JobPostDTO dto){
        return jobPostServices.update_job_post(id,dto);
    }

    @GetMapping("/getJobPostById/{id}")
    private job_post get_jobPostById(@PathVariable("id") Integer id){
        return jobPostServices.getJobPostByID(id);
    }

    @GetMapping("/list_of_job_post")
    private List<job_post> list_of_job_post(){
        return jobPostServices.List_of_job_post();
    }

    @GetMapping("/getAllJobPostStatusOne")
    private List<job_post> getAllJobPostStatusOne(){
        return jobPostServices.getAllJobPostStatusTrue();
    }

    @GetMapping("/getAllJobPostSpecificCompany/{company_id}")
    private List<job_post> getAllJobPostSpecificCompany(@PathVariable("company_id") Integer company_id){
        return jobPostServices.getAllJobPostSpecificCompany(company_id);
    }

    @GetMapping("/countAllMyJobs/{company_id}")
    private List<Map<String, Objects>> countAllJobsPostForSpecificCompany(@PathVariable("company_id") Integer company_id){
        return jobPostServices.countAllJobsPostForSpecificCompany(company_id);
    }
    @GetMapping("/getAllJobPostSpecificCompany2/{company_id}")
    private List<Map<String,Objects>> getAllJobPostSpecificCompany2(@PathVariable("company_id") Integer company_id){
        return jobPostServices.getAllJobPostSpecificCompany2(company_id);
    }
    @GetMapping("/getAllJobPostWithInformation")
    private List<Map<String,Objects>> getAllJobPostWithInformation(){
        return jobPostServices.getAllJobPostWithInformation();
    }

    @GetMapping("/getAllJobPostSpecificCompanyByJobPostId/{job_post_id}")
    private List<Map<String,Objects>> getAllJobPostSpecificCompanyByJobPostId(@PathVariable("job_post_id") Integer job_post_id){
        return jobPostServices.getAllJobPostSpecificCompanyByJobPostId(job_post_id);
    }

    @GetMapping("/getAllJobPostGroupByType")
    private List<Map<String,Objects>> getAllJobPostGroupByType(){
        return jobPostServices.getAllJobPostGroupByType();
    }
    @GetMapping("/searchAllJobPostSpecificCompany/{company_id}/{tittle}")
    private List<Map<String,Objects>> SearchAllJobPostSpecificCompany(@PathVariable("company_id") Integer company_id,@PathVariable("tittle") String tittle){
        return jobPostServices.SearchAllJobPostSpecificCompany(company_id,tittle);
    }
    @GetMapping("/searchAllJobPost/{tittle}")
    private List<Map<String,Objects>> SearchAllJobPost(@PathVariable("tittle") String tittle){
        return jobPostServices.SearchAllJobPost(tittle);
    }
    @GetMapping("/getJobsByExperienceAndCompany/{company_id}/{experience}")
    private List<Map<String,Objects>> getJobsByExperienceAndCompany(@PathVariable("company_id") Integer company_id,@PathVariable("experience") String experience){
        return jobPostServices.getJobsByExperienceAndCompany(company_id,experience);
    }
    @GetMapping("/getJobsByExperienceAndCompanyAndCategory/{company_id}/{experience}/{category}")
    private List<Map<String,Objects>> getJobsByExperienceAndCompanyAndCategory(@PathVariable("company_id") Integer company_id,@PathVariable("experience") String experience,@PathVariable("category") String category){
        return jobPostServices.getJobsByExperienceAndCompanyAndCategory(company_id,experience,category);
    }
    @GetMapping("/getJobsByExperienceAndCompanyAndCategoryAndType/{company_id}/{experience}/{category}/{type}")
    private List<Map<String,Objects>> SearchAllJobPostSpecificCompany(@PathVariable("company_id") Integer company_id,@PathVariable("experience") String experience,@PathVariable("category") String category,@PathVariable("type") int type){
        return jobPostServices.getJobsByExperienceAndCompanyAndCategoryAndType(company_id,experience,category,type);
    }
    @GetMapping("/getJobsByTypeNameAndCompany/{company_id}/{type_name}")
    private List<Map<String,Objects>> getJobsByTypeNameAndCompany(@PathVariable("company_id") Integer company_id,@PathVariable("type_name") String type_name){
        return jobPostServices.getJobsByTypeNameAndCompany(company_id,type_name);
    }

    @GetMapping("/getJobsByTypeName/{type_name}")
    private List<Map<String,Objects>> getJobsByTypeName(@PathVariable("type_name") String type_name){
        return jobPostServices.getJobsByTypeName(type_name);
    }

}
