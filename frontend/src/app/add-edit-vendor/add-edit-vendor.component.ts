import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router'
import { AddvendorService } from './addvendor.service';
import { Vendor } from '../vendor';

@Component({
  selector: 'app-add-edit-vendor',
  templateUrl: './add-edit-vendor.component.html',
  styleUrls: ['./add-edit-vendor.component.scss']
})
export class AddEditVendorComponent implements OnInit {
  vendor=new Vendor();
  vendors:Vendor[];

  constructor(private route: ActivatedRoute,private _router:Router,private addvendor:AddvendorService) { }

  ngOnInit() {
    this.route.params.subscribe( params => this.getVendorById(params['vendorId']));
  }
   
  // inserting or updating vendor details
  addVendor(): void{
    this.addvendor.addVendor(this.vendor)
      .subscribe((response)=>{ 
        console.log(response);
        this._router.navigate(['/viewvendor']);
      }, (error)=>{
        console.log(error);
      });
  }

  //go back to view vendor page
  goback(){
    this._router.navigate(['/viewvendor'])
  }

  //get vendor by id
  getVendorById(vendorId:number){
   this.addvendor.getVendorById(vendorId)
   .subscribe((searchData) =>{
      this.vendor=searchData;
      console.log(searchData);
   }, (error) =>{
      console.log(error);
   });
  }
}
