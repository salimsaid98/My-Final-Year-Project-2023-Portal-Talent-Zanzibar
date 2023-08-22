import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminTypeConfigurationComponent } from './admin-type-configuration.component';

describe('AdminTypeConfigurationComponent', () => {
  let component: AdminTypeConfigurationComponent;
  let fixture: ComponentFixture<AdminTypeConfigurationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminTypeConfigurationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminTypeConfigurationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
