import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompanyInformationAdminComponent } from './company-information-admin.component';

describe('CompanyInformationAdminComponent', () => {
  let component: CompanyInformationAdminComponent;
  let fixture: ComponentFixture<CompanyInformationAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CompanyInformationAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CompanyInformationAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
