import { Component, TemplateRef, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { DomSanitizer, SafeUrl } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { seeker_logo } from 'src/app/models/seeker_logo';
import { CompanyRegistrationService } from 'src/app/services/company_registration/company-registration.service';
import { RegistrationServicesService } from 'src/app/services/registration/registration-services.service';
import { SeekerServiceService } from 'src/app/services/seeker/seeker-service.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-my-profile',
  templateUrl: './my-profile.component.html',
  styleUrls: ['./my-profile.component.css']
})
export class MyProfileComponent {
  constructor(
    private registrationService: RegistrationServicesService,
    private route:Router,
    private seeker_service: SeekerServiceService,
    private dialog:MatDialog,
    private company_service:CompanyRegistrationService,
    private sanitizer: DomSanitizer,
  ){}

  displayedColumns: string[] = ['position', 'name_seeker','job_tittle','company','specialization','gender','applied_date','status'];
  dataSource = new MatTableDataSource<any>;

  @ViewChild(MatPaginator)
  paginator!: MatPaginator;

  @ViewChild('callDialog') callDialog!: TemplateRef<any>;

    count_all_job_applied:any;
    count_all_success_job:any;
    count_all_not_approved:any;

    user_info_data:any;
    username:any;
    img_file:seeker_logo[]=[]

  ngOnInit(): void {
    this.getuserInformation(sessionStorage.getItem("login_id"));
    this.username = sessionStorage.getItem("username");
    this.getAllCompanies();
    this.getSeekerLogo(sessionStorage.getItem("login_id"));
  }

  company_data:any;
  getAllCompanies(){
    this.company_service.getAllCompany().subscribe((resp:any)=>{
      this.company_data  =  resp;
    });
  }
  images: any = {};

  getSeekerLogo(user_id:any){
    this.seeker_service.getSeekerLogo(user_id).subscribe((resp:any)=>{
      // this.images = resp
      this.img_file.push(resp)
      console.log(this.img_file)

    });
  }
  getBase64Image(image: any): string {
    if (image && image.image_type && image.seeker_logo) {
      return 'data:' + image.image_type + ';base64,' + image.seeker_logo;
    }
    return ''; // Return an empty string if image data is not available
  }


  getuserInformation(user_id:any){
    this.registrationService.getSpecificUserInformation(user_id).subscribe((output:any)=>{
      this.user_info_data = output;
      this.seeker_service.getSeekerByUserInformationID(output.user_information_id).subscribe((resp:any)=>{
        this.getReport(resp.seeker_id);
      });
    })
  }

  getReport(seeker_id:any){
      this.seeker_service.countAllJobApplied(seeker_id).subscribe((resp:any)=>{
        this.count_all_job_applied = resp[0].total_job_applied;
      });
      this.seeker_service.countAllSuccessJobApplied(seeker_id).subscribe((resp:any)=>{
        this.count_all_success_job = resp[0].total_success_job_applied;;
      });
      this.seeker_service.countAllNotApprovedJobApplied(seeker_id).subscribe((resp:any)=>{
        this.count_all_not_approved = resp[0].total_job_applied;
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
        this.route.navigate(['job_portal/home']).then(()=>{
          window.location.reload();
        });
      } else if (result.isDenied) {
      }
    })
  }

  gotToAddMoreEducationDetails(){
    this.route.navigate(['job_portal/add_more_education']);
  }

  goToMyInformation(){
    this.route.navigate(['job_portal/my_profile']);
  }

  goToModifyMyInformation(){
    this.route.navigate(['job_portal/seeker_modify_data']);
  }

  openDialog(){
      this.dialog.open(this.callDialog,
      { panelClass: ['animate__animated', 'animate__slideInRight'], width: "1050px" });

      this.registrationService.getSpecificUserInformation(sessionStorage.getItem("login_id")).subscribe((output:any)=>{
        this.seeker_service.getSeekerByUserInformationID(output.user_information_id).subscribe((resp:any)=>{
          this.seeker_service.getAllApplicationIApplied(resp.seeker_id).subscribe((response:any)=>{
            this.dataSource = new MatTableDataSource(response);
            this.dataSource.paginator = this.paginator;
          });
        });
      })
  }
}
