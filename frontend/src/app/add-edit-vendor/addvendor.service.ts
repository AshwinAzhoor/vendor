import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Vendor } from '../vendor';

@Injectable({
  providedIn: 'root'
})
export class AddvendorService {

  constructor(private httpService: HttpClient) { }

  //adding or editing vendor
  addVendor(vendor:Vendor)
  {
    let body = JSON.stringify(vendor);
    let headers = new HttpHeaders({'Content-Type': 'application/json'});
    let options = { headers: headers }
    if(vendor.vendorId){
      return this.httpService.put(environment.APIUrl +'/saveVendor',body,options);
    }else{
      return this.httpService.post(environment.APIUrl +'/saveVendor',body,options);
    }
  }

  //get vendor by id
  getVendorById(vendorId:number):Observable<Vendor>{
    return this.httpService.get<Vendor>(environment.APIUrl +'/getVendorById/'+ vendorId);
  }



}
