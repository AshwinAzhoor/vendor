import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../login/login.service';

@Component({
  selector: 'app-staffdashboard',
  templateUrl: './staffdashboard.component.html',
  styleUrls: ['./staffdashboard.component.scss']
})
export class StaffdashboardComponent implements OnInit {

  constructor(private router:Router,private loginServ:LoginService) { }

  ngOnInit() {
  }

  //logout
  logout():void{
    this.loginServ.logout();
  }

}
