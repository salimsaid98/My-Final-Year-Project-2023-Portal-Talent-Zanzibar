import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DashboardComponent } from './general/dashboard/dashboard.component';
import { LoginComponent } from './general/login/login.component';
import { RegistrationComponent } from './general/registration/registration.component';
import { JobPostComponent } from './general/job-post/job-post.component';
import { JobListComponent } from './general/job-list/job-list.component';
import { JobDetailsComponent } from './general/job-details/job-details.component';
import { ApplicantProfileComponent } from './general/applicant-profile/applicant-profile.component';
import { CompanyProfileComponent } from './general/company-profile/company-profile.component';
import { NavBarComponent } from './linker/nav-bar/nav-bar.component';
import { FooterComponent } from './linker/footer/footer.component';
import { MyProfileComponent } from './general/my-profile/my-profile.component';
import { SearchJobComponent } from './general/search-job/search-job.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatDialogModule } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { CommonModule } from '@angular/common';
import { MatRippleModule } from '@angular/material/core';


import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatSelectModule } from '@angular/material/select';
import { MatSliderModule } from '@angular/material/slider';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatMenuModule } from '@angular/material/menu';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatCardModule } from '@angular/material/card';
import { MatDividerModule } from '@angular/material/divider';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatListModule } from '@angular/material/list';
import { MatStepperModule } from '@angular/material/stepper';
import { MatTabsModule } from '@angular/material/tabs';
import { MatTreeModule } from '@angular/material/tree';
import { MatButtonModule } from '@angular/material/button';
import { MatButtonToggleModule } from '@angular/material/button-toggle';
import { MatBadgeModule } from '@angular/material/badge';
import { MatChipsModule } from '@angular/material/chips';
import { MatIconModule } from '@angular/material/icon';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatProgressBarModule } from '@angular/material/progress-bar';
import { MatBottomSheetModule } from '@angular/material/bottom-sheet';
import { MatTooltipModule } from '@angular/material/tooltip';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { MatTableModule } from '@angular/material/table';
import { CompanyRegistrationComponent } from './general/company-registration/company-registration.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AdminHomeComponent } from './admin/admin-home/admin-home.component';
import { ApprovedApplicantComponent } from './general/approved-applicant/approved-applicant.component';
import { ApplicantInformationComponent } from './general/applicant_information/applicant-information/applicant-information.component';
import { JobListApplicantComponent } from './general/job-list-applicant/job-list-applicant.component';
import { ApplicantSkillEducationComponent } from './general/applicant-skill-education/applicant-skill-education.component';
import { ApplicantExperienceComponent } from './general/applicant-experience/applicant-experience.component';
import { ApprovedApplicantInformationComponent } from './general/approved-applicant-information/approved-applicant-information.component';
import { ModifyCompanyDataComponent } from './general/modify-company-data/modify-company-data.component';
import { AddMoreEducationDetailsComponent } from './general/add-more-education-details/add-more-education-details.component';
import { SeekerModifyDataComponent } from './general/seeker-modify-data/seeker-modify-data.component';
import { AdminSpecializationConfigurationComponent } from './admin/admin-specialization-configuration/admin-specialization-configuration.component';
import { AdminSkillsConfigurationComponent } from './admin/admin-skills-configuration/admin-skills-configuration.component';
import { AdminTypeConfigurationComponent } from './admin/admin-type-configuration/admin-type-configuration.component';
import { AdminUserManagementComponent } from './admin/admin-user-management/admin-user-management.component';
import { AdminSeekersComponent } from './admin/admin-seekers/admin-seekers.component';
import { AdminCompaniesComponent } from './admin/admin-companies/admin-companies.component';
import { SeekerInformationsComponent } from './admin/seeker-informations/seeker-informations.component';
import { CompanyInformationAdminComponent } from './admin/company-information-admin/company-information-admin.component';
import { JobListAdminComponent } from './admin/job-list-admin/job-list-admin.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    LoginComponent,
    RegistrationComponent,
    JobPostComponent,
    JobListComponent,
    JobDetailsComponent,
    ApplicantProfileComponent,
    CompanyProfileComponent,
    NavBarComponent,
    FooterComponent,
    MyProfileComponent,
    SearchJobComponent,
    CompanyRegistrationComponent,
    AdminHomeComponent,
    ApprovedApplicantComponent,
    ApplicantInformationComponent,
    JobListApplicantComponent,
    ApplicantSkillEducationComponent,
    ApplicantExperienceComponent,
    ApprovedApplicantInformationComponent,
    ModifyCompanyDataComponent,
    AddMoreEducationDetailsComponent,
    SeekerModifyDataComponent,
    AdminSpecializationConfigurationComponent,
    AdminSkillsConfigurationComponent,
    AdminTypeConfigurationComponent,
    AdminUserManagementComponent,
    AdminSeekersComponent,
    AdminCompaniesComponent,
    SeekerInformationsComponent,
    CompanyInformationAdminComponent,
    JobListAdminComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatDialogModule,
    MatFormFieldModule,
    CommonModule,
    MatAutocompleteModule,
    MatCheckboxModule,
    MatDatepickerModule,
    MatFormFieldModule,
    MatDialogModule,
    MatSelectModule,
    MatSliderModule,
    MatSlideToggleModule,
    MatMenuModule,
    MatSidenavModule,
    MatToolbarModule,
    MatCardModule,
    MatDividerModule,
    MatExpansionModule,
    MatGridListModule,
    MatListModule,
    MatStepperModule,
    MatTabsModule,
    MatTreeModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatBadgeModule,
    MatChipsModule,
    MatIconModule,
    MatProgressSpinnerModule,
    MatProgressBarModule,
    MatRippleModule,
    MatBottomSheetModule,
    MatDialogModule,
    MatTooltipModule,
    MatPaginatorModule,
    MatSortModule,
    MatTableModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
