import { Component, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { CompanyRegistrationService } from 'src/app/services/company_registration/company-registration.service';
import { LoginServicesService } from 'src/app/services/login/login-services.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-admin-companies',
  templateUrl: './admin-companies.component.html',
  styleUrls: ['./admin-companies.component.css']
})
export class AdminCompaniesComponent {
  constructor(
    private router:Router,
    private company_service:CompanyRegistrationService
  ){}

  displayedColumns: string[] = ['position', 'name','owner','edate','country','email'];
  dataSource = new MatTableDataSource<any>;
  @ViewChild(MatPaginator)
  paginator!: MatPaginator;

  user_role:any;
  loading: boolean = false;

  ngOnInit(): void {
      this.user_role = sessionStorage.getItem("user_role");
      this.getAllCompanies();
  }

  getAllCompanies(){
    this.loading = true;
    setTimeout(()=>{
      this.company_service.getAllCompany().subscribe((resp:any)=>{
        this.dataSource = new MatTableDataSource(resp);
        this.dataSource.paginator = this.paginator;
        this.loading = false;
      });
    },3000);
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

  goToCompanyInformation(element:any){
    this.router.navigate(['job_portal/company_admin_informations', element.company_id]);
  }
  gotoJobList(){
    this.router.navigate(['job_portal/job_list_admin']);
  }
}
