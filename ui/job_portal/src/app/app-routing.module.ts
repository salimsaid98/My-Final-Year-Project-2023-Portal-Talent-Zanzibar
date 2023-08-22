import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './general/dashboard/dashboard.component';
import { LoginComponent } from './general/login/login.component';
import { RegistrationComponent } from './general/registration/registration.component';
import { JobPostComponent } from './general/job-post/job-post.component';
import { JobListComponent } from './general/job-list/job-list.component';
import { MyProfileComponent } from './general/my-profile/my-profile.component';
import { SearchJobComponent } from './general/search-job/search-job.component';
import { CompanyRegistrationComponent } from './general/company-registration/company-registration.component';
import { AdminHomeComponent } from './admin/admin-home/admin-home.component';
import { CompanyProfileComponent } from './general/company-profile/company-profile.component';
import { JobDetailsComponent } from './general/job-details/job-details.component';
import { ApprovedApplicantComponent } from './general/approved-applicant/approved-applicant.component';
import { JobListApplicantComponent } from './general/job-list-applicant/job-list-applicant.component';
import { ApplicantSkillEducationComponent } from './general/applicant-skill-education/applicant-skill-education.component';
import { ApplicantExperienceComponent } from './general/applicant-experience/applicant-experience.component';
import { ApplicantInformationComponent } from './general/applicant_information/applicant-information/applicant-information.component';
import { ApprovedApplicantInformationComponent } from './general/approved-applicant-information/approved-applicant-information.component';
import { ModifyCompanyDataComponent } from './general/modify-company-data/modify-company-data.component';
import { AddMoreEducationDetailsComponent } from './general/add-more-education-details/add-more-education-details.component';
import { SeekerModifyDataComponent } from './general/seeker-modify-data/seeker-modify-data.component';
import { AdminTypeConfigurationComponent } from './admin/admin-type-configuration/admin-type-configuration.component';
import { AdminSkillsConfigurationComponent } from './admin/admin-skills-configuration/admin-skills-configuration.component';
import { AdminSpecializationConfigurationComponent } from './admin/admin-specialization-configuration/admin-specialization-configuration.component';
import { AdminUserManagementComponent } from './admin/admin-user-management/admin-user-management.component';
import { AdminCompaniesComponent } from './admin/admin-companies/admin-companies.component';
import { AdminSeekersComponent } from './admin/admin-seekers/admin-seekers.component';
import { SeekerInformationsComponent } from './admin/seeker-informations/seeker-informations.component';
import { CompanyInformationAdminComponent } from './admin/company-information-admin/company-information-admin.component';
import { JobListAdminComponent } from './admin/job-list-admin/job-list-admin.component';

const routes: Routes = [
  { path: '',redirectTo:'job_portal/home',pathMatch:'full'},
  { path: "job_portal/home",component:DashboardComponent},
  { path: "job_portal/login_page",component:LoginComponent },
  { path: "job_portal/registration",component:RegistrationComponent },
  { path: "job_portal/job_post",component:JobPostComponent},
  { path: "job_portal/job_list",component:JobListComponent},
  { path: "job_portal/my_profile",component:MyProfileComponent},
  { path: "job_portal/my_profile_company",component:CompanyProfileComponent},
  { path: "job_portal/job_search", component:SearchJobComponent},
  { path: "job_portal/company_registration",component:CompanyRegistrationComponent},
  { path: "job_portal/admin_home",component:AdminHomeComponent},
  { path: "job_portal/add_more_education",component:AddMoreEducationDetailsComponent},
  { path: "job_portal/job_details/:id",component:JobDetailsComponent},
  { path: "job_portal/approved_applicant/:id",component:ApprovedApplicantComponent},
  { path: "job_portal/job_list_applicant",component:JobListApplicantComponent},
  { path: "job_portal/applicant_education_details",component:ApplicantSkillEducationComponent},
  { path: "job_portal/applicant_experience",component:ApplicantExperienceComponent},
  { path: "job_portal/company_modify_data",component:ModifyCompanyDataComponent},
  { path: "job_portal/seeker_modify_data",component:SeekerModifyDataComponent},
  { path: "job_portal/applicant_informations/:seeker_id/:user_id/:job_post_id",component:ApplicantInformationComponent},
  { path: "job_portal/approved_applicant_informations/:seeker_id/:user_id",component:ApprovedApplicantInformationComponent},

  { path: "job_portal/skill_configurations",component:AdminSkillsConfigurationComponent},
  { path: "job_portal/specialization_configurations",component:AdminSpecializationConfigurationComponent},
  { path: "job_portal/job_type_configurations",component:AdminTypeConfigurationComponent},
  { path: "job_portal/user_management",component:AdminUserManagementComponent},
  { path: "job_portal/companies",component:AdminCompaniesComponent},
  { path: "job_portal/seekers",component:AdminSeekersComponent},
  { path: "job_portal/job_list_admin",component:JobListAdminComponent},

  { path: "job_portal/seeker_admin_informations/:user_id",component:SeekerInformationsComponent},
  { path: "job_portal/company_admin_informations/:company_id",component:CompanyInformationAdminComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
