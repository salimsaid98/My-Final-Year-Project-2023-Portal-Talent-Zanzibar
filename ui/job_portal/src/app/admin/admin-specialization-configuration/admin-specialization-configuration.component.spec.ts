import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminSpecializationConfigurationComponent } from './admin-specialization-configuration.component';

describe('AdminSpecializationConfigurationComponent', () => {
  let component: AdminSpecializationConfigurationComponent;
  let fixture: ComponentFixture<AdminSpecializationConfigurationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminSpecializationConfigurationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminSpecializationConfigurationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
