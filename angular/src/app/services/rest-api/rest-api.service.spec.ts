/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { RestAPIService } from './rest-api.service';

describe('RestAPIService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RestAPIService]
    });
  });

  it('should ...', inject([RestAPIService], (service: RestAPIService) => {
    expect(service).toBeTruthy();
  }));
});
