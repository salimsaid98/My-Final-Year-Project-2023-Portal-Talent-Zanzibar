import { Dialog } from '@angular/cdk/dialog';
import { HttpErrorResponse } from '@angular/common/http';
import { Component, TemplateRef, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { ActivatedRoute, Router } from '@angular/router';
import { ApplyJob } from 'src/app/models/apply-job';
import { JobServiceService } from 'src/app/services/job_service/job-service.service';
import { RegistrationServicesService } from 'src/app/services/registration/registration-services.service';
import { SeekerServiceService } from 'src/app/services/seeker/seeker-service.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-job-details',
  templateUrl: './job-details.component.html',
  styleUrls: ['./job-details.component.css'],

})
export class JobDetailsComponent {

  dataSource!: MatTableDataSource<any>;
  @ViewChild(MatSort) sort!: MatSort;
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  displayedColumns: string[] = ['ID', 'empName','Gender','Specialization','country_of_origin','status','Actions'];

  job_post_id:any;
  job_data:any;
  user_role:any;

  check:boolean = false;

  apply_job_model: ApplyJob  = new ApplyJob();

  constructor(
    private route:ActivatedRoute,
    private job_service:JobServiceService,
    private router:Router,
    private seeker_service:SeekerServiceService,
    private user_information_service: RegistrationServicesService
  ){}

  ngOnInit(): void {
    this.job_post_id = this.route.snapshot.params['id'];
    this.getJobPostInformation(this.job_post_id);
    this.user_role = sessionStorage.getItem("user_role");
    if(this.user_role == "Company"){
      this.getAllApplicantAppliedMyCompany();
    }

  }

  getJobPostInformation(data:any){
    this.job_service.getAllJobPostSpecificCompanyByJobPostId(data).subscribe((resp:any)=>{
      for(const element of resp) {
        this.job_data = element;
        if(sessionStorage.getItem("company_id") == element.company_id){
          this.check = true;
        }else{
          this.check = false;
        }
      }
    })
  }

  getAllApplicantAppliedMyCompany(){
    this.seeker_service.getAllApplicantAppliedMyCompany(sessionStorage.getItem("company_id")).subscribe((resp:any)=>{
      this.dataSource = new MatTableDataSource(resp);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    });
  }

  apply_this_job(data:any){
    Swal.fire({
      title: 'Are you sure you want to apply this post?',
      text: "You won't be able to revert this!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, apply this!'
    }).then((result) => {
      if (result.isConfirmed) {
        this.user_information_service.getSpecificUserInformation(sessionStorage.getItem("login_id")).subscribe((response:any)=>{
          this.seeker_service.getSeekerByUserInformationID(response.user_information_id).subscribe((resp:any)=>{
            let seeker_id = "";
            seeker_id = resp.seeker_id;
            this.seeker_service.checkExistingApplication(seeker_id,data).subscribe((resp:any)=>{
            Swal.fire({
              icon: 'error',
              title: 'Oops...',
              text: 'You have already applied to this application',
            })
            },
            (error:HttpErrorResponse)=>{
              let d = new Date();
              let apply_date = d.getDate() + '-' + (d.getMonth()+ 1) + '-' + d.getFullYear();
              this.apply_job_model.job_post_id = data;
              this.apply_job_model.seeker_id = seeker_id;
              this.apply_job_model.applied_date = apply_date;
              this.seeker_service.saveAppliedJob(this.apply_job_model).subscribe((resp:any) => {
                this.apply_job_model = new ApplyJob();
                this.ngOnInit();
                Swal.fire(
                  'Applied!',
                  'Job has been applied successfully',
                  'success'
                )
              });
            }
            )
          },
            (error:HttpErrorResponse)=>{
              Swal.fire(
                'Application Error!',
                'You have to put your education details first before applying the application',
                'error'
              )
              this.router.navigate(["job_portal/applicant_education_details"])
            }
          );
        });
      }
    })
  }

  goTo(data:any){
    this.router.navigate(["job_portal/approved_applicant/",data]);
  }

  gotToInformation(data:any){
    this.router.navigate(["job_portal/applicant_informations/",data.seeker_id,data.user_id,this.job_post_id]);
  }

  gotToConfirmedInformation(data:any){
    this.router.navigate(["job_portal/approved_applicant_informations/",data.seeker_id,data.user_id]);
  }

  check_login(data:any){
    if(sessionStorage.getItem("login_id") == null){
      Swal.fire(
        'Warning',
        'You have to login first to apply this job!',
        'warning'
      )
    }else{
    }
  }
}
