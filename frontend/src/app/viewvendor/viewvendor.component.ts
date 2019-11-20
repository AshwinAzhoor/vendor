import { Component, OnInit } from '@angular/core';
import { Vendor } from '../vendor';
import { ViewvendorService } from './viewvendor.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-viewvendor',
  templateUrl: './viewvendor.component.html',
  styleUrls: ['./viewvendor.component.scss']
})
export class ViewvendorComponent implements OnInit {
  vendor=new Vendor();
  vendors:Vendor[];
  search:string;
  constructor(private viewServ:ViewvendorService,private router:Router) { }

  ngOnInit() {
    this.getVendorDetails();
  }

  //get vendor details
  getVendorDetails(): void{
    this.viewServ.getVendorDetails().subscribe((vendorData) =>{
      this.vendors=vendorData,
      console.log(vendorData);
    }, 
    (error) =>{
      console.log(error);
    });
  }

  //get vendor by id
  getVendorById(vendorId:number): void{
    
    this.router.navigate(['/addeditvendor/'+vendorId]);
  }
  //save vendor
  saveVendor():void{
    this.router.navigate(['/addeditvendor'])
  }

  //search vendor by location,service,contactName
  searchVendor(search:string): void{
    if(search!=null)
    {
      this.viewServ.searchVendor(search).subscribe((vendorData)=>{
        this.search=undefined;
        this.vendors=vendorData,
        console.log(vendorData);

      },(error)=>{
        console.log(error);
      });
    }
    else{ 
      this.getVendorDetails();
    }
  }

  //disable vendor
  disableVendor(vendor:Vendor):void{
    console.log("dshgf")
    this.viewServ.disableVendor(vendor).subscribe((response)=>{
  this.getVendorDetails();
    },   (error) =>{
      console.log(error);
    });
  }

  //go back to dashboard
  goback():void{
    this.router.navigate(['/staffdashboard'])
  }


}
