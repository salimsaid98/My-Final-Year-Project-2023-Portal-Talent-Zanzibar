import { TestBed } from '@angular/core/testing';

import { RegistrationServicesService } from './registration-services.service';

describe('RegistrationServicesService', () => {
  let service: RegistrationServicesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RegistrationServicesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
