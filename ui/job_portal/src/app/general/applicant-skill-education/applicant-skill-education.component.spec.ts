import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApplicantSkillEducationComponent } from './applicant-skill-education.component';

describe('ApplicantSkillEducationComponent', () => {
  let component: ApplicantSkillEducationComponent;
  let fixture: ComponentFixture<ApplicantSkillEducationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ApplicantSkillEducationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ApplicantSkillEducationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
