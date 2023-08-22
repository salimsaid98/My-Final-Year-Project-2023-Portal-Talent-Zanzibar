import { TestBed } from '@angular/core/testing';

import { SeekerServiceService } from './seeker-service.service';

describe('SeekerServiceService', () => {
  let service: SeekerServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SeekerServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
