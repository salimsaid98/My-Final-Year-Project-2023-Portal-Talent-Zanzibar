import { HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginModel } from 'src/app/models/login-model';
import { CompanyRegistrationService } from 'src/app/services/company_registration/company-registration.service';
import { LoginServicesService } from 'src/app/services/login/login-services.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  constructor(
    private login_service:LoginServicesService,
    private route:Router,
    private company_service:CompanyRegistrationService
     ){}

  login_model: LoginModel = new LoginModel();

  ngOnInit(): void {}

  processLogin(){
    this.login_service.login_authentication
    (this.login_model.username,this.login_model.password)
    .subscribe((output:any)=>{
      sessionStorage.setItem("login_id",output.user_id);
      sessionStorage.setItem("username",output.username);
      sessionStorage.setItem("user_role",output.role);
      if(output.role == "Company"){
        this.company_service.getCompanyInformationUsingUserId(output.user_id).subscribe((resp:any)=>{
          this.check_role(output.role,resp.company_id,resp.company_name);
        })
      }else if(output.role == "Administrator"){
        this.route.navigate(["../../job_portal/admin_home"]);
      }else{
        this.route.navigate([""])
      }
    },
    (error:HttpErrorResponse)=>{
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
        title: 'Incorrect credentials',
      })
    });
  }

  check_role(role:any,company_id:any,company_name:any){
    if(role == "Company"){
      sessionStorage.setItem("company_id",company_id);
      sessionStorage.setItem("company_name",company_name);
      this.route.navigate([""]);
    }
  }
}
