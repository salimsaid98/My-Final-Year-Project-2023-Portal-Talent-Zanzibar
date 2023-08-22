import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { JobServiceService } from 'src/app/services/job_service/job-service.service';

@Component({
  selector: 'app-search-job',
  templateUrl: './search-job.component.html',
  styleUrls: ['./search-job.component.css']
})
export class SearchJobComponent {

  search_result:any;
  display_result: boolean = false;
  display_category: boolean = false;
  check_role:any;
  jobs:any;
  jobs_2:any;

  type_data:any;
  type_name!:string;

  constructor(
    private job_service:JobServiceService,
    private router:Router
  ){}

  ngOnInit(): void {
    this.getJobsByType();
    this.display_result = false;
    this.display_category = false;
    this.check_role = sessionStorage.getItem("user_role");
  }

  getJobsByType(){
    this.job_service.getAllJobPostGroupByType().subscribe((resp:any)=>{
      this.type_data = resp;
    })
  }

  searchJob(search_:any){
    this.search_result = search_;
    this.display_result = true;
    if(this.check_role == "Company"){
      this.job_service.searchAllJobPostSpecificCompany(sessionStorage.getItem("company_id"),search_).subscribe((resp:any)=>{
        this.jobs = resp;
      });
    }else{
      this.job_service.searchAllJobPost(search_).subscribe((resp:any)=>{
        this.jobs_2 = resp;
      });
    }
  }

  goToList(data:any){
    this.display_result = false;
    this.display_category = true;
    this.type_name = data;
    if(this.check_role == "Company"){
      this.job_service.getJobsByTypeNameAndCompany(sessionStorage.getItem("company_id"),this.type_name).subscribe((resp:any)=>{
        this.jobs = resp;
      })
    }else{
      this.job_service.getJobsByTypeName(this.type_name).subscribe((resp:any)=>{
        this.jobs_2 = resp;
      })
    }
  }

  goToDetails(data:any){
    this.router.navigate(["job_portal/job_details",data])
  }
}
