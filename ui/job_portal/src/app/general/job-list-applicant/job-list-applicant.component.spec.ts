import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JobListApplicantComponent } from './job-list-applicant.component';

describe('JobListApplicantComponent', () => {
  let component: JobListApplicantComponent;
  let fixture: ComponentFixture<JobListApplicantComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ JobListApplicantComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(JobListApplicantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
