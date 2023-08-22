import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ApplyJob } from 'src/app/models/apply-job';
import { EducationDetails } from 'src/app/models/education-details';
import { Seeker } from 'src/app/models/seeker';
import { SeekerExperience } from 'src/app/models/seeker-experience';
import { SeekerLanguage } from 'src/app/models/seeker-language';
import { SeekerSkills } from 'src/app/models/seeker-skills';
import { RegistrationServicesService } from 'src/app/services/registration/registration-services.service';
import { SeekerServiceService } from 'src/app/services/seeker/seeker-service.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-applicant-information',
  templateUrl: './applicant-information.component.html',
  styleUrls: ['./applicant-information.component.css']
})
export class ApplicantInformationComponent {


  constructor(
    private registrationService: RegistrationServicesService,
    private router: Router,
    private activated_router:ActivatedRoute,
    private seeker_service: SeekerServiceService
  ) {}

  user_information_id: any;

  seeker_id:any;
  user_id: any;
  job_post_id:any;

  applied_model: ApplyJob = new ApplyJob();

  all_information: any;
  language_information: any;

  user_info_data: any;

  check_details: boolean = true;

  user_role:any;

  check_approval:any;

  ngOnInit(): void {
    this.seeker_id = this.activated_router.snapshot.params['seeker_id'];
    this.user_id = this.activated_router.snapshot.params['user_id'];
    this.job_post_id = this.activated_router.snapshot.params['job_post_id'];
    this.getuserInformation(this.user_id);
    this.check_if_details_exist();
    this.user_role = sessionStorage.getItem('user_role');
  }

  getuserInformation(user_id: any) {
    this.registrationService
      .getSpecificUserInformation(user_id)
      .subscribe((output: any) => {
        this.user_info_data = output;
        this.user_id = output.user_id;
        this.user_information_id = output.user_information_id;
      });
  }

  check_if_details_exist() {
    let seeker_id = '';
    this.registrationService
      .getSpecificUserInformation(this.user_id)
      .subscribe((output: any) => {
        this.seeker_service
          .getSeekerAllInformation(output.user_information_id)
          .subscribe((resp: any) => {
            if (resp.length > 0) {
              this.check_details = true;
              for (const element of resp) {
                this.all_information = element;
                seeker_id = element.seeker_id;
              }
              this.seeker_service
                .getAllSeekerLanguages(seeker_id)
                .subscribe((resp: any) => {
                  this.language_information = resp;
                });
            } else {
              this.check_details = false;
            }
          });
      });
  }

  log_out() {
    Swal.fire({
      title: 'Do you want to signout ?',
      showDenyButton: true,
      showCancelButton: true,
      confirmButtonText: 'Yes',
      denyButtonText: `No`,
    }).then((result) => {
      if (result.isConfirmed) {
        sessionStorage.removeItem('login_id');
        sessionStorage.removeItem('username');
        sessionStorage.removeItem('user_role');
        sessionStorage.removeItem('company_id');
        sessionStorage.removeItem('company_name');
        sessionStorage.clear();
        this.router.navigate(['job_portal/home']).then(() => {
          window.location.reload();
        });
      } else if (result.isDenied) {
      }
    });
  }

  approveApplicant(data:any){
    Swal.fire({
      title: 'Do you want to confirm this applicant ?',
      showDenyButton: true,
      showCancelButton: true,
      confirmButtonText: 'Yes',
      denyButtonText: `No`,
    }).then((result) => {
      if (result.isConfirmed) {
        this.seeker_service.getAppliedJobData(this.seeker_id,this.job_post_id).subscribe((resp:any)=>{
          this.applied_model.applied_date = resp.applied_date;
          this.applied_model.job_post_id = resp.job_post_id;
          this.applied_model.seeker_id = resp.seeker_id;
          this.applied_model.status = 1;
          let dd = new Date();
          let month = dd.getMonth() + 1;
          let new_date = dd.getDate() + '-' + month + '-' + dd.getFullYear();
          this.applied_model.confirmed_date = new_date;
          this.seeker_service.updateAppliedJob(resp.apply_id, this.applied_model).subscribe((resp:any)=>{
            Swal.fire({
              icon: 'success',
              title: 'Congratultion',
              text: 'You have approved this applicant',
            })
            this.router.navigate(['job_portal/approved_applicant/',resp.job_post_id]);
          })
        });
      } else if (result.isDenied) {
      }
    });
  }

}
