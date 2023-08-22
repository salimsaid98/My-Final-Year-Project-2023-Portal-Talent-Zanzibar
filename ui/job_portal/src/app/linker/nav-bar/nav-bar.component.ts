import { Component } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent {

  constructor( private route:Router ){}

  check_login: boolean = true;

  job_post: boolean = false;

  login_id:any;

  check_role:any;

  username:any;

  user_role:any;

  ngOnInit(): void {


      this.login_id = sessionStorage.getItem("login_id");
      this.username = sessionStorage.getItem("username");
      this.user_role = sessionStorage.getItem("user_role");
      this.check_role = sessionStorage.getItem("user_role");
      if( this.login_id == null){
        this.check_login = false;
      }
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
        this.route.navigate(['job_portal/home']).then(()=>{
          window.location.reload();
        });
      } else if (result.isDenied) {
      }
    })
  }

  home_page(){
    this.route.navigate(['job_portal/home']);
  }
  job_post_page(){
    this.route.navigate(['job_portal/job_post']);
  }
  job_list_page(){
    this.route.navigate(['job_portal/job_list']);
  }
  my_profile_page(){
    if(sessionStorage.getItem('user_role') == 'Company'){
      this.route.navigate(['job_portal/my_profile_company']);
    }else{
      this.route.navigate(['job_portal/my_profile']);
    }
  }
  sign_in_page(){
    this.route.navigate(['job_portal/login_page']);
  }
  registration_in_page(){
    this.route.navigate(['job_portal/registration']);
  }
}
