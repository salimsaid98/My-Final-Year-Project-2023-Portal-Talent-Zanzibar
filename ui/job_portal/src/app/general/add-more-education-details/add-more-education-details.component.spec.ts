import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddMoreEducationDetailsComponent } from './add-more-education-details.component';

describe('AddMoreEducationDetailsComponent', () => {
  let component: AddMoreEducationDetailsComponent;
  let fixture: ComponentFixture<AddMoreEducationDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddMoreEducationDetailsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddMoreEducationDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
