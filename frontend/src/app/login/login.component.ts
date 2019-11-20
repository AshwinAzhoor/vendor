import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { LoginService } from './login.service';
import { Login } from './login';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  login=new Login();
  message:string;
  sessionTokenUserName:string;
  sessionTokenLoginId:string;
  constructor(private loginService:LoginService,private router:Router) { }

  ngOnInit() {
    this.resetForm();
    this.sessionTokenUserName=localStorage.getItem('token');
    this.sessionTokenLoginId=localStorage.getItem('tokenLoginId')

  }

  OnSubmit(form:NgForm){
    this.validLogin(form);
  }
   resetForm(form?:NgForm)
   {
     if(form!=null)
       form.resetForm();
       this.loginService.formData={
        loginId:undefined,
        username:undefined,
        password:undefined
}   
   }
   //login validation
   validLogin(form:NgForm){
     console.log(form.value);
    if((this.sessionTokenUserName==null) && (this.sessionTokenLoginId==null)){
       this.loginService.loginValidation(form.value).subscribe((data)=>{
        console.log(data.userName); 
        this.login=data;
         console.log(this.login);
        localStorage.setItem('isLoggedIn',"true");
         localStorage.setItem('token',data.userName);
        localStorage.setItem('tokenLoginId',data.loginId);
         if(data.loginId=="1")
           {
           this.router.navigate(['/staffdashboard']); 
       }else if(data.loginId=="2")
       {
       this.router.navigate(['/staffdashboard']); 
       }else{
        this.message="Invalid Username or Password";
         this.router.navigate(['/login']);
           }
         })
        }
     }
}
