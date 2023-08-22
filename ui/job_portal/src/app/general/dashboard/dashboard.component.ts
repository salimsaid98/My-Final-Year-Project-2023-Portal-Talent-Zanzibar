import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { JobServiceService } from 'src/app/services/job_service/job-service.service';
import { ReportServiceService } from 'src/app/services/report/report-service.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {

  jobs:any;
  count_company:any;
  count_live_jobs:any;
  count_applicants:any;

  login_check: boolean = false;


  constructor(
    public job_service:JobServiceService,
    private report_service:ReportServiceService,
    private router:Router
  ){}

  ngOnInit(): void {
    if(sessionStorage.getItem("login_id") == null){
      this.login_check = false;
    }else{
      this.login_check = true;
    }
    this.getAllJobPost();
    this.countAllApplicant();
    this.countAllCompanies();
    this.countAllJobPost();
  }

  check_login(){
    if(sessionStorage.getItem("login_id") == null){
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'You have to login first to post job!',
      })
    }else{
      if(sessionStorage.getItem("user_role") == "Company"){
        this.router.navigate(["job_portal/job_post"]);
      }else{
        const Toast = Swal.mixin({
          toast: true,
          position: 'top-end',
          showConfirmButton: false,
          timer: 3000,
          timerProgressBar: true,
          didOpen: (toast) => {
            toast.addEventListener('mouseenter', Swal.stopTimer)
            toast.addEventListener('mouseleave', Swal.resumeTimer)
          }
        })

        Toast.fire({
          icon: 'error',
          title: 'You are an applicant , you can not post a job'
        })
      }
    }
  }

  goToDetails(data:any){
    this.router.navigate(["job_portal/job_details",data])
  }

  getAllJobPost(){
    this.job_service.getAllJobPostWithInformation().subscribe((output:any)=>{
      this.jobs = output;
    })
  }

  countAllCompanies(){
    this.report_service.countCompanies().subscribe((output:any)=>{
      this.count_company = output;
    })
  }

  countAllApplicant(){
    this.report_service.countAllApplicant().subscribe((output:any)=>{
      this.count_applicants = output;
    })
  }

  countAllJobPost(){
    this.report_service.countAllJobPost().subscribe((output:any)=>{
      this.count_live_jobs = output;
    })
  }

}
