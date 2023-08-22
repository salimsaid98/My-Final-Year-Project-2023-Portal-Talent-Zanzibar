import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { JobServiceService } from 'src/app/services/job_service/job-service.service';
import { ReportServiceService } from 'src/app/services/report/report-service.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-job-list-applicant',
  templateUrl: './job-list-applicant.component.html',
  styleUrls: ['./job-list-applicant.component.css']
})
export class JobListApplicantComponent {

  constructor(
    public job_service:JobServiceService,
    private report_service:ReportServiceService,
    private router:Router
  ){}

  jobs:any;
  job_type:any;
  ngOnInit(): void {
    this.getAllJobPost();
    this.getAllJobPostGroupByType();
  }
  getAllJobPost(){
    this.job_service.getAllJobPostWithInformation().subscribe((output:any)=>{
      this.jobs = output;
    })
  }

  getAllJobPostGroupByType(){
    this.job_service.getAllJobPostGroupByType().subscribe((output:any)=>{
      this.job_type = output;
      console.log(output);

    });
  }

  goToDetails(data:any){
    this.router.navigate(["job_portal/job_details",data])
  }
}
