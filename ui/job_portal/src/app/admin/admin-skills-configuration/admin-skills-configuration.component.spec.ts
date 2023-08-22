import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminSkillsConfigurationComponent } from './admin-skills-configuration.component';

describe('AdminSkillsConfigurationComponent', () => {
  let component: AdminSkillsConfigurationComponent;
  let fixture: ComponentFixture<AdminSkillsConfigurationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminSkillsConfigurationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminSkillsConfigurationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
