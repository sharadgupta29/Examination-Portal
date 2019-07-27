import { TestBed } from '@angular/core/testing';

import { Guard1Service } from './guard1.service';

describe('Guard1Service', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: Guard1Service = TestBed.get(Guard1Service);
    expect(service).toBeTruthy();
  });
});
