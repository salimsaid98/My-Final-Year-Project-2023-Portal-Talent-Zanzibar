import { HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { error } from 'jquery';
import { CompanyRegistrationService } from 'src/app/services/company_registration/company-registration.service';
import { JobServiceService } from 'src/app/services/job_service/job-service.service';

@Component({
  selector: 'app-job-list',
  templateUrl: './job-list.component.html',
  styleUrls: ['./job-list.component.css'],

})
export class JobListComponent {

  company_id:any;
  experience_id:any;
  category_id:any
  job_type_id:any;


  company_name:any;
  count_my_jobs:any;
  count_my_jobs_2:any;

  check_role:any;

  jobs:any;
  jobs_2:any;

  search_result:any;

  loading: boolean = false;
  display_result: boolean = false;

  constructor(
    public job_service:JobServiceService,
    private router:Router,
    private company_services:CompanyRegistrationService,

  ){}
  ngOnInit(): void {
    this.loading = false;
    this.display_result = false;
    this.company_name = sessionStorage.getItem('company_name');
    this.check_role = sessionStorage.getItem("user_role");
    if(this.check_role == "Company"){
      this.getAllJobPostCompany(sessionStorage.getItem('company_id'));
      this.countAllByJobs();
    }else{
      this.getAllJobPosts();
      this.getAllCompanies();
    }
    this.getAllJobTypes();
  }

  countAllByJobs(){
    this.job_service.countAllMyJobs(sessionStorage.getItem("company_id")).subscribe((out:any)=>{
      for(const element of out){
        this.count_my_jobs = element.total_job_post;
      }
    });
  }

  getAllJobPostCompany(company_id:any){
    this.job_service.getAllJobPostSpecificCompany2(company_id).subscribe((resp:any)=>{
      this.jobs = resp;
    })
  }

  getAllJobPosts(){
    this.job_service.getAllJobPostWithInformation().subscribe((resp:any)=>{
      this.jobs_2 = resp;
      this.count_my_jobs_2 = resp.length;
    });
  }

  goToDetails(data:any){
    this.router.navigate(["job_portal/job_details",data])
  }

  searchJob(search_:any){
    this.loading  = true;
    this.search_result = search_;
    this.display_result = true;
    if(this.check_role == "Company"){
      this.job_service.searchAllJobPostSpecificCompany(sessionStorage.getItem("company_id"),search_).subscribe((resp:any)=>{
        this.jobs = resp;
        this.count_my_jobs = resp.length;
        this.loading = false;
      });
    }else{
      this.job_service.searchAllJobPost(search_).subscribe((resp:any)=>{
        this.jobs_2 = resp;
        this.count_my_jobs_2 = resp.length;
        this.loading = false;
      });
    }
  }
  company_data:any;
  getAllCompanies(){
    this.company_services.getAllCompany().subscribe((resp:any)=>{
      this.company_data = resp;
    });
  }

  job_type_data:any;
  getAllJobTypes(){
    this.job_service.getAllJobTypeList().subscribe((resp:any)=>{
      this.job_type_data = resp;
    })
  }


  getJobsByCompany(company_id:any){
    this.company_id = company_id;
    this.loading = true;
    this.job_service.getAllJobPostSpecificCompany2(company_id).subscribe((resp:any)=>{
      this.jobs_2 = resp;
      this.count_my_jobs_2 = resp.length;
      this.loading = false;
    },
    (error:HttpErrorResponse)=>{
      this.loading = false;
    }
    );
  }

  getJobsByExperienceAndCompany(experience:any){
    this.experience_id = experience;
    this.loading = true;
    console.log(experience);
    this.job_service.getJobsByExperienceAndCompany(this.company_id,experience).subscribe((resp:any)=>{
      this.jobs_2 = resp;
      this.count_my_jobs_2 = resp.length;
      this.loading = false;
    },
    (error:HttpErrorResponse)=>{
      this.loading = false;
    }
    )
  }

  getJobsByExperienceAndCompanyAndCategory(category_id:any){
    this.loading = true;
    this.category_id = category_id;
    this.job_service.getJobsByExperienceAndCompanyAndCategory(this.company_id,this.experience_id,category_id).subscribe((resp:any)=>{
      this.jobs_2 = resp;
      this.count_my_jobs_2 = resp.length;
      this.loading = false;
    },
    (error:HttpErrorResponse)=>{
      this.loading = false;
    }
    )
  }

  getJobsByExperienceAndCompanyAndCategoryAndType(type_id:any){
    this.loading = true;
    this.job_type_id = type_id;
    this.job_service.getJobsByExperienceAndCompanyAndCategoryAndType(this.company_id,this.experience_id,this.category_id,type_id).subscribe((resp:any)=>{
      this.jobs_2 = resp;
      this.count_my_jobs_2 = resp.length;
      this.loading = false;
    },
    (error:HttpErrorResponse)=>{
      this.loading = false;
    }
    );
  }

}
