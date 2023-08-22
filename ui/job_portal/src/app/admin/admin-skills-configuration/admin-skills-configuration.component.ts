import { Component, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { AdminServicesService } from 'src/app/services/admin-services.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-admin-skills-configuration',
  templateUrl: './admin-skills-configuration.component.html',
  styleUrls: ['./admin-skills-configuration.component.css']
})
export class AdminSkillsConfigurationComponent {
  constructor(
    private router:Router,
    private admin_service:AdminServicesService
  ){}

  displayedColumns: string[] = ['position', 'skill_name','action'];
  dataSource = new MatTableDataSource<any>;
  @ViewChild(MatPaginator)
  paginator!: MatPaginator;

  user_role:any;
  skill_name:any;
  loading: boolean = false;
  skill_id:any;
  check_edit:boolean = false;

  ngOnInit(): void {
      this.user_role = sessionStorage.getItem("user_role");
      this.getAllSkills();
  }

  getAllSkills(){
    this.loading = true;

    setTimeout(()=>{
      this.admin_service.getAllSkills().subscribe((resp:any)=>{
        this.dataSource = new MatTableDataSource(resp);
        this.dataSource.paginator = this.paginator;
        this.loading = false;
      });
    },3000);
  }

  saveSkill(){

    this.loading = true;
    const skill_data = {
      skill_name: this.skill_name,
      status: 1
    }
    setTimeout(()=>{
      this.admin_service.saveSkill(skill_data).subscribe((resp:any)=>{
        this.loading = false;
        this.skill_name = null;
        this.skill_name = undefined;
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
          title: 'Skill has been added successfully',
        })
      });
    },2000);

  }

  editSkill(element:any){
    this.skill_id = element.skill_id;
    this.skill_name = element.skill_name;
    this.check_edit = true;
  }

  modifySkill(){
    this.loading = true;
    const skill_data = {
      skill_name: this.skill_name,
      status: 1
    }
    setTimeout(()=>{
      this.admin_service.updateSkill(this.skill_id,skill_data).subscribe((resp:any)=>{
        this.loading = false;
        this.skill_name = null;
        this.skill_name = undefined;
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
          title: 'Skill has been modified successfully',
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
