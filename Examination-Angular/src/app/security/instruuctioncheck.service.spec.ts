import { TestBed } from '@angular/core/testing';

import { InstruuctioncheckService } from './instruuctioncheck.service';

describe('InstruuctioncheckService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: InstruuctioncheckService = TestBed.get(InstruuctioncheckService);
    expect(service).toBeTruthy();
  });
});
