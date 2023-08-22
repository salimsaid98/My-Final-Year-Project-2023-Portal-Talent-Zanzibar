import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Companylogo } from 'src/app/models/Companylogo';
import { CompanyRegistrationService } from 'src/app/services/company_registration/company-registration.service';
import { CompSpecializationService } from 'src/app/services/company_specialization_services/comp-specialization.service';
import { JobServiceService } from 'src/app/services/job_service/job-service.service';
import { SeekerServiceService } from 'src/app/services/seeker/seeker-service.service';

@Component({
  selector: 'app-company-profile',
  templateUrl: './company-profile.component.html',
  styleUrls: ['./company-profile.component.css']
})
export class CompanyProfileComponent {
    constructor(
       private company_spec_service: CompSpecializationService,
       private company_service:CompanyRegistrationService,
       private router:Router,
       public job_service:JobServiceService,
       public seeker_service:SeekerServiceService
    ){}

    company_data:any;
    company_specialization_data:any;
    count_my_jobs:any;

    company_image:any;

    count_all_application_submitted:any;
    count_all_success_application_submitted:any;

    ngOnInit(): void {
      this.getAllCompanyInformation();
      this.getAllCompanySpecialization();
      this.countAllByJobs();
      this.countAllApplicationSubmitted(sessionStorage.getItem("company_id"));
      this.countAllSuccessApplicationSubmitted(sessionStorage.getItem("company_id"));
      this.getCompanyLogo(sessionStorage.getItem("login_id"));
    }

    countAllByJobs(){
      this.job_service.countAllMyJobs(sessionStorage.getItem("company_id")).subscribe((out:any)=>{
        for(const element of out){
          this.count_my_jobs = element.total_job_post;
        };
      });

      this.company_service.getCompanyLogo(sessionStorage.getItem("company_id")).subscribe((resp:any)=>{
        this.company_image =  resp.company_logos;
      });
    }

  images: any = {};
  img_file:Companylogo[]=[]
  getCompanyLogo(id:any){
    this.company_service.getCompanyLogo(id).subscribe((resp:any)=>{
      // this.images = resp
      this.img_file.push(resp)
      console.log(this.img_file)

    });
    console.log("id is ",id)
  }
  getBase64Image(image: any): string {
    if (image && image.image_type && image.company_logos) {
      return 'data:' + image.image_type + ';base64,' + image.company_logos;
    }
    return ''; // Return an empty string if image data is not available
  }


    getAllCompanyInformation(){
      this.company_service.getCompanyInformationUsingUserId(sessionStorage.getItem("login_id")).subscribe((output:any)=>{
        this.company_data = output;
      })
    }

    getAllCompanySpecialization(){
      let dt = "";
      this.company_spec_service.getAllCompanySpecializationForSpecificCompany(sessionStorage.getItem("login_id")).subscribe((output:any)=>{
        for(let v = 0; v < output.length; v++){
          if(v == 0){
            dt = output[v].specialization_name;
          }else{
            dt = dt + " , " + output[v].specialization_name;
          }
          this.company_specialization_data = dt;
        }

      });
    }

    countAllApplicationSubmitted(company_id:any){
      this.seeker_service.countAllApplicationSubmitted(company_id).subscribe((resp:any)=>{
        this.count_all_application_submitted = resp[0].all_app;
      });
    }

    countAllSuccessApplicationSubmitted(company_id:any){
      this.seeker_service.countAllSuccessApplicationSubmitted(company_id).subscribe((resp:any)=>{
        this.count_all_success_application_submitted = resp[0].all_success_app;
      });
    }

    log_out(){
      sessionStorage.removeItem("login_id");
      sessionStorage.removeItem("username");
      sessionStorage.removeItem("user_role");
      sessionStorage.removeItem("company_id");
      sessionStorage.clear();
      this.router.navigate(['job_portal/home']).then(()=>{
        window.location.reload();
      });
    }

    gotoEditMyProfile(){
      this.router.navigate(['job_portal/company_modify_data']);
    }
}
