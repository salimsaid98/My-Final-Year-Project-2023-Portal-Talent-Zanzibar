import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import jsPDF from 'jspdf';
import { RegistrationServicesService } from 'src/app/services/registration/registration-services.service';
import { SeekerServiceService } from 'src/app/services/seeker/seeker-service.service';
import Swal from 'sweetalert2';
import html2canvas from 'html2canvas';

@Component({
  selector: 'app-approved-applicant-information',
  templateUrl: './approved-applicant-information.component.html',
  styleUrls: ['./approved-applicant-information.component.css']
})
export class ApprovedApplicantInformationComponent {
  constructor(
    private registrationService: RegistrationServicesService,
    private router: Router,
    private seeker_service: SeekerServiceService,
    private activated_router: ActivatedRoute
  ) {}

  seeker_id: any;
  all_information: any;
  language_information: any;

  user_info_data: any;
  user_id: any;
  check_details: boolean = true;

  ngOnInit(): void {
    this.seeker_id = this.activated_router.snapshot.params["seeker_id"];
    this.user_id = this.activated_router.snapshot.params["user_id"];
    this.getuserInformation(this.user_id);
    this.check_if_details_exist();
  }

  getuserInformation(user_id: any) {
    this.registrationService
      .getSpecificUserInformation(user_id)
      .subscribe((output: any) => {
        this.user_info_data = output;
      });
  }

  downloadPDF(){
      let DATA: any = document.getElementById('cv');
      html2canvas(DATA).then((canvas) => {
        let fileWidth = 208;
        let fileHeight = (canvas.height * fileWidth) / canvas.width;
        const FILEURI = canvas.toDataURL('image/png');
        let PDF = new jsPDF('p', 'mm', 'a4');
        let position = 0;
        PDF.addImage(FILEURI, 'PNG', 0, position, fileWidth, fileHeight);
        PDF.save('applicant_cv.pdf');
      });
  }

  check_if_details_exist() {
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
              }
              this.seeker_service
                .getAllSeekerLanguages(this.seeker_id)
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
}
