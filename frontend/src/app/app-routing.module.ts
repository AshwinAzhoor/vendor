import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { StaffdashboardComponent } from './staffdashboard/staffdashboard.component';
import { ViewvendorComponent } from './viewvendor/viewvendor.component';
import { AddEditVendorComponent } from './add-edit-vendor/add-edit-vendor.component';
import { AuthGuard } from './guards/auth.guard';


const routes: Routes = [ {path:'',redirectTo:'/login',pathMatch:'full'},
{path:'login',component:LoginComponent},
{path:'staffdashboard',component:StaffdashboardComponent,canActivate:[AuthGuard]},
{path:'viewvendor',component:ViewvendorComponent},
{path:'addeditvendor',component:AddEditVendorComponent},
{path:'addeditvendor/:vendorId',component:AddEditVendorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
