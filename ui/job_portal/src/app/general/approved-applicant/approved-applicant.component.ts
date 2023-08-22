import { Component, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { ActivatedRoute, Router } from '@angular/router';
import { JobServiceService } from 'src/app/services/job_service/job-service.service';
import DataTable from 'datatables.net-dt';
import { SeekerServiceService } from 'src/app/services/seeker/seeker-service.service';

@Component({
  selector: 'app-approved-applicant',
  templateUrl: './approved-applicant.component.html',
  styleUrls: ['./approved-applicant.component.css']
})
export class ApprovedApplicantComponent {

  dataSource!: MatTableDataSource<any>;
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  displayedColumns: string[] = ['ID'];


  job_post_id:any;
  job_data:any;
  user_role:any;

  success_applicant:any;

  constructor(
    private route:ActivatedRoute,
    private job_service:JobServiceService,
    private seeker_service:SeekerServiceService,
    private router:Router
  ){}

  ngOnInit(): void {
    this.success_applicant = [];
    this.job_post_id = this.route.snapshot.params['id'];
    this.getJobPostInformation(this.job_post_id);
    let table = new DataTable('#myTable');
    this.user_role = sessionStorage.getItem("user_role");
    this.getAllSuccessApplicantAppliedMyCompany(sessionStorage.getItem('company_id'),this.job_post_id);
  }

  getJobPostInformation(data:any){
    this.job_service.getAllJobPostSpecificCompanyByJobPostId(data).subscribe((resp:any)=>{
      for(const element of resp) {
        this.job_data = element;
      }
    });
  }

  getAllSuccessApplicantAppliedMyCompany(company_id:any,job_post_id:any) {
    this.seeker_service.getAllSuccessApplicantAppliedMyCompany(company_id,job_post_id).subscribe((resp:any)=>{
      this.success_applicant = resp;
    });
  }

  gotToConfirmedInformation(data:any){
    this.router.navigate(["job_portal/approved_applicant_informations/",data.seeker_id,data.user_id]);
  }
}
