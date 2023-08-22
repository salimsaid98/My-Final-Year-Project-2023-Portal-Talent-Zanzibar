import { TestBed } from '@angular/core/testing';

import { CompSpecializationService } from './comp-specialization.service';

describe('CompSpecializationService', () => {
  let service: CompSpecializationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CompSpecializationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
