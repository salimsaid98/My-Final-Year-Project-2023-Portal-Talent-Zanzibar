import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApprovedApplicantComponent } from './approved-applicant.component';

describe('ApprovedApplicantComponent', () => {
  let component: ApprovedApplicantComponent;
  let fixture: ComponentFixture<ApprovedApplicantComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ApprovedApplicantComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ApprovedApplicantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
