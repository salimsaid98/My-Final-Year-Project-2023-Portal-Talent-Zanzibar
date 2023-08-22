import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifyCompanyDataComponent } from './modify-company-data.component';

describe('ModifyCompanyDataComponent', () => {
  let component: ModifyCompanyDataComponent;
  let fixture: ComponentFixture<ModifyCompanyDataComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModifyCompanyDataComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModifyCompanyDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
