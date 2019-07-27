import { Component, OnInit } from '@angular/core';
import { AuthServiceService } from 'src/app/auth-service.service';
import { Router } from '@angular/router';
import { Registration } from 'src/app/registration';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  x:Registration;
  constructor(private router:Router, private authService:AuthServiceService) {
    
   }

  ngOnInit() {
    this.authService.getProfile(sessionStorage.getItem('token')).subscribe( (data )=> {
      console.log(data) ; 
      this.x=data;
      this.authService.usr=data;
      console.log(this.x.city) ;   
    });
  }
  update(){
    this.router.navigate(['/profile-update']);
  }

 
}
