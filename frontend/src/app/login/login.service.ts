import { Injectable } from '@angular/core';
import { Login } from './login';
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  formData: Login;

  constructor(private _httpService: HttpClient,private router:Router) { }

  //login validation
  loginValidation(formData:any):any{
    return this._httpService.get<Login>(environment.APIUrl +'/login/'+formData.username+'/'+formData.password);
  }

  //session removing after logout
  logout():void{
    localStorage.setItem('isLoggedIn','false');
    localStorage.removeItem('token');
    localStorage.removeItem('tokenLoginId');
    this.router.navigate(['/login']);
   

  }

}
