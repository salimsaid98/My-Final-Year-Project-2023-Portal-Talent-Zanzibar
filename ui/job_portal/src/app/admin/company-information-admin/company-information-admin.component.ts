import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CompanyRegistrationService } from 'src/app/services/company_registration/company-registration.service';
import { CompSpecializationService } from 'src/app/services/company_specialization_services/comp-specialization.service';

@Component({
  selector: 'app-company-information-admin',
  templateUrl: './company-information-admin.component.html',
  styleUrls: ['./company-information-admin.component.css']
})
export class CompanyInformationAdminComponent {


  constructor(
    private company_spec_service: CompSpecializationService,
    private company_service:CompanyRegistrationService,
    private activated_router:ActivatedRoute,
    private router:Router
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
  //  this.countAllApplicationSubmitted(sessionStorage.getItem("company_id"));
  //  this.countAllSuccessApplicationSubmitted(sessionStorage.getItem("company_id"));
   this.company_service.getCompanyLogo(sessionStorage.getItem("company_id")).subscribe((resp:any)=>{
     this.company_image =  resp.company_logos;
   });
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
