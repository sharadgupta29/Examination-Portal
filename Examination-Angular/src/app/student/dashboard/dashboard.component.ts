import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthServiceService } from 'src/app/auth-service.service';
import { Result } from 'src/app/model/result';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  x:Result;
  constructor(private router:Router,private authService:AuthServiceService) {
   
   }
  
  ngOnInit() {

    console.log('dashboard'+sessionStorage.getItem('user'));
    this.authService.setHeaderContent(sessionStorage.getItem('user'));
    this.authService.setHeaderLogout('Logout');


      
   
    
  }

  
}
