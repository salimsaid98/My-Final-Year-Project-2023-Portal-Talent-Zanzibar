import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SeekerInformationsComponent } from './seeker-informations.component';

describe('SeekerInformationsComponent', () => {
  let component: SeekerInformationsComponent;
  let fixture: ComponentFixture<SeekerInformationsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SeekerInformationsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SeekerInformationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
