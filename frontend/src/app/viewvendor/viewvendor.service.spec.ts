import { TestBed } from '@angular/core/testing';

import { ViewvendorService } from './viewvendor.service';

describe('ViewvendorService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ViewvendorService = TestBed.get(ViewvendorService);
    expect(service).toBeTruthy();
  });
});
