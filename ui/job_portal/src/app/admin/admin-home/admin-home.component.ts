import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AdminServicesService } from 'src/app/services/admin-services.service';
import { CompanyRegistrationService } from 'src/app/services/company_registration/company-registration.service';
import { JobServiceService } from 'src/app/services/job_service/job-service.service';
import { LoginServicesService } from 'src/app/services/login/login-services.service';
import { SeekerServiceService } from 'src/app/services/seeker/seeker-service.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent {


  constructor(
    private router:Router,
    private admin_service:AdminServicesService,
    private login_service:LoginServicesService,
    private seeker_service:SeekerServiceService,
    private company_service:CompanyRegistrationService,
    private job_service:JobServiceService
  ){}

  specialization:any;
  job_type:any;
  skills:any;
  users:any;
  jobs:any;
  seekers:any;
  companies:any;

  user_role:any;
  loading: boolean = false;

  ngOnInit(): void {
    this.loading = true;
    this.specialization = 0;
    this.job_type = 0;
    this.skills = 0;
    this.users = 0;
    this.jobs = 0;
    this.seekers = 0;
    this.companies = 0;

      this.user_role = sessionStorage.getItem("user_role");
      setTimeout(()=>{
        this.getAllCountData();
        this.loading = false;
      },3000);
  }

  getAllCountData(){
      this.admin_service.getAllSpecializations().subscribe((resp:any)=>{
          this.specialization = resp.length;
      });

      this.admin_service.getAllSkills().subscribe((resp:any)=>{
          this.skills = resp.length;
      });

      this.admin_service.getAllJobType().subscribe((resp:any)=>{
        this.job_type = resp.length;
      });

      this.login_service.getAllUsers().subscribe((resp:any)=>{
        this.users = resp.length;
      });

      this.company_service.getAllCompany().subscribe((resp:any)=>{
        this.companies = resp.length;
      });

      this.job_service.getAllJobPost().subscribe((resp:any)=>{
        this.jobs = resp.length;
      });

      this.seeker_service.getAllSeekers().subscribe((resp:any)=>{
        this.seekers = resp.length;
      });
  }

  log_out(){

    Swal.fire({
      title: 'Do you want to signout ?',
      showDenyButton: true,
      showCancelButton: true,
      confirmButtonText: 'Yes',
      denyButtonText: `No`,
    }).then((result) => {
      if (result.isConfirmed) {
        sessionStorage.removeItem("login_id");
        sessionStorage.removeItem("username");
        sessionStorage.removeItem("user_role");
        sessionStorage.removeItem("company_id");
        sessionStorage.removeItem("company_name");
        sessionStorage.clear();
        this.router.navigate(['job_portal/home']).then(()=>{
          window.location.reload();
        });
      } else if (result.isDenied) {
      }
    })
  }

  gotoAdminHomePage(){
    this.router.navigate(['job_portal/admin_home']);
  }

  goToSpecializationPage(){
    this.router.navigate(['job_portal/specialization_configurations']);
  }

  goToSkillsPage(){
    this.router.navigate(['job_portal/skill_configurations']);
  }

  goToJobTypes(){
    this.router.navigate(['job_portal/job_type_configurations']);
  }

  goToUserManagement(){
    this.router.navigate(['job_portal/user_management']);
  }

  goToCompanies(){
    this.router.navigate(['job_portal/companies']);
  }

  gotoSeekers(){
    this.router.navigate(['job_portal/seekers']);
  }

  gotoJobList(){
    this.router.navigate(['job_portal/job_list_admin']);
  }

}
