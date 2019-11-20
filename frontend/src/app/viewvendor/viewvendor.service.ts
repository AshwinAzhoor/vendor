import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Vendor } from '../vendor';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ViewvendorService {

  constructor(private httpService: HttpClient) { }

  //get vendor details
  getVendorDetails(): Observable<Vendor[]>{
    return this.httpService.get<Vendor[]>(environment.APIUrl +'/viewVendors');
  }

  //search vendor
  searchVendor(search:string):Observable<Vendor[]>{
    return this.httpService.get<Vendor[]>(environment.APIUrl +'/search/'+search);
  }
  //disable vendor
  disableVendor(vendor:Vendor){
    let body = JSON.stringify(vendor);
    let headers = new HttpHeaders({'Content-Type': 'application/json'});
    let options = { headers: headers }
      return this.httpService.put(environment.APIUrl +'/disableVendor', body, options);
   }
}
