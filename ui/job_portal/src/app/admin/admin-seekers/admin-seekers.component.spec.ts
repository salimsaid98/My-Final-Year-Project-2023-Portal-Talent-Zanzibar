import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminSeekersComponent } from './admin-seekers.component';

describe('AdminSeekersComponent', () => {
  let component: AdminSeekersComponent;
  let fixture: ComponentFixture<AdminSeekersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminSeekersComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminSeekersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
