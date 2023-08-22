import { Component, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { AdminServicesService } from 'src/app/services/admin-services.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-admin-specialization-configuration',
  templateUrl: './admin-specialization-configuration.component.html',
  styleUrls: ['./admin-specialization-configuration.component.css']
})
export class AdminSpecializationConfigurationComponent {

  constructor(
    private router:Router,
    private admin_service:AdminServicesService
  ){}

  displayedColumns: string[] = ['position', 'skill_name','action'];
  dataSource = new MatTableDataSource<any>;
  @ViewChild(MatPaginator)
  paginator!: MatPaginator;

  user_role:any;
  specialization_name:any;
  loading: boolean = false;
  specialization_id:any;
  check_edit:boolean = false;

  ngOnInit(): void {
      this.user_role = sessionStorage.getItem("user_role");
      this.getAllSPecializations();
  }

  getAllSPecializations(){
    this.loading = true;

    setTimeout(()=>{
      this.admin_service.getAllSpecializations().subscribe((resp:any)=>{
        this.dataSource = new MatTableDataSource(resp);
        this.dataSource.paginator = this.paginator;
        this.loading = false;
      });
    },3000);
  }

  saveSpecialization(){

    this.loading = true;
    const specialization_data = {
      specialization_name: this.specialization_name,
    }
    setTimeout(()=>{
      this.admin_service.saveSpecialization(specialization_data).subscribe((resp:any)=>{
        this.loading = false;
        this.specialization_name = null;
        this.specialization_name = undefined;
        this.ngOnInit();
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
          icon: 'success',
          title: 'Specialization has been added successfully',
        })
      });
    },2000);

  }

  editSpecialization(element:any){
    this.specialization_id = element.specialization_id;
    this.specialization_name = element.specialization_name;
    this.check_edit = true;
  }

  modifySpecialization(){
    this.loading = true;
    const specialization_data = {
      specialization_name: this.specialization_name,
    }
    setTimeout(()=>{
      this.admin_service.updateSpecialization(this.specialization_id,specialization_data).subscribe((resp:any)=>{
        this.loading = false;
        this.specialization_name = null;
        this.specialization_name = undefined;
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
          icon: 'success',
          title: 'Specialization has been modified successfully',
        })
        this.ngOnInit();
      });
    },2000);
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
