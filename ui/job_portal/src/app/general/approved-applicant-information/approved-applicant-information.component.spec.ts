import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApprovedApplicantInformationComponent } from './approved-applicant-information.component';

describe('ApprovedApplicantInformationComponent', () => {
  let component: ApprovedApplicantInformationComponent;
  let fixture: ComponentFixture<ApprovedApplicantInformationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ApprovedApplicantInformationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ApprovedApplicantInformationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
