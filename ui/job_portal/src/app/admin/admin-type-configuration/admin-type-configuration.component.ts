import { Component, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { AdminServicesService } from 'src/app/services/admin-services.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-admin-type-configuration',
  templateUrl: './admin-type-configuration.component.html',
  styleUrls: ['./admin-type-configuration.component.css']
})
export class AdminTypeConfigurationComponent {

  constructor(
    private router:Router,
    private admin_service:AdminServicesService
  ){}

  displayedColumns: string[] = ['position', 'type_name','action'];
  dataSource = new MatTableDataSource<any>;
  @ViewChild(MatPaginator)
  paginator!: MatPaginator;

  user_role:any;
  job_type:any;
  loading: boolean = false;
  type_id:any;
  check_edit:boolean = false;

  ngOnInit(): void {
      this.user_role = sessionStorage.getItem("user_role");
      this.getAllJobTypes();
  }

  getAllJobTypes(){
    this.loading = true;

    setTimeout(()=>{
      this.admin_service.getAllJobType().subscribe((resp:any)=>{
        this.dataSource = new MatTableDataSource(resp);
        this.dataSource.paginator = this.paginator;
        this.loading = false;
      });
    },3000);
  }

  saveJobType(){

    this.loading = true;
    const type_data = {
      job_type: this.job_type
    }
    setTimeout(()=>{
      this.admin_service.saveJobType(type_data).subscribe((resp:any)=>{
        this.loading = false;
        this.job_type = null;
        this.job_type = undefined;
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
          title: 'Job type has been added successfully',
        })
      });
    },2000);

  }

  editType(element:any){
    this.type_id = element.job_type_id;
    this.job_type = element.job_type;
    this.check_edit = true;
  }

  modifyType(){
    this.loading = true;
    const type_data = {
      job_type: this.job_type
    }
    setTimeout(()=>{
      this.admin_service.updateJobType(this.type_id,type_data).subscribe((resp:any)=>{
        this.loading = false;
        this.job_type = null;
        this.job_type = undefined;
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
          title: 'Job type has been modified successfully',
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
