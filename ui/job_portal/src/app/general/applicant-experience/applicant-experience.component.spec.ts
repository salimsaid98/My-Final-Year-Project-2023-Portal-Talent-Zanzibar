import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApplicantExperienceComponent } from './applicant-experience.component';

describe('ApplicantExperienceComponent', () => {
  let component: ApplicantExperienceComponent;
  let fixture: ComponentFixture<ApplicantExperienceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ApplicantExperienceComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ApplicantExperienceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
