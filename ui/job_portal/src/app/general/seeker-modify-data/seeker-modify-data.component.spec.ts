import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SeekerModifyDataComponent } from './seeker-modify-data.component';

describe('SeekerModifyDataComponent', () => {
  let component: SeekerModifyDataComponent;
  let fixture: ComponentFixture<SeekerModifyDataComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SeekerModifyDataComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SeekerModifyDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
