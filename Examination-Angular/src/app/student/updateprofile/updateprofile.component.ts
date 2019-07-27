import { Component, OnInit } from '@angular/core';
import { Registration } from 'src/app/registration';
import { AuthServiceService } from 'src/app/auth-service.service';

import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
@Component({
  selector: 'app-updateprofile',
  templateUrl: './updateprofile.component.html',
  styleUrls: ['./updateprofile.component.css']
})
export class UpdateprofileComponent implements OnInit {
  x:Registration;
  data1
  pass="";
  cpass="";
  Comment="";
  constructor(private router:Router,private authService:AuthServiceService) { }

  ngOnInit() {
    this.authService.getProfile(sessionStorage.getItem('token')).subscribe( (data )=> {
      console.log(data) ; 
      this.x=data;
      this.pass=this.x.password;
      this.cpass=this.pass;
      
    });
  }

  SelectChangeHadndler(event: any){
    this.x.gender=event.target.value;
    console.log(this.x.gender);
  }
  cancel(){
   
    this.router.navigate(['/student']);

  }

  update(){
    this.authService.setHeaderContent(sessionStorage.getItem('user'));
    if(this.cpass==this.pass && this.x.gender!=""&& this.x.state!=""&& this.x.contact!=""&& this.x.city!=""){
      this.x.password=this.cpass;
      console.log(this.x.password);

      this.authService.UpdateProfile(this.x).subscribe( (data )=> {
        console.log("2222"+data) ; 
        if(data!=null){
        this.x=data;
        this.pass=this.x.password;
        this.cpass=this.pass;
        this.Comment="";
        this.router.navigate(['/student']);
       }
        else{
          this.Comment="Something went wrong..Please try again";
        }
      });


      this.Comment="";
    }
    else{
      this.Comment="please enter valid entries";
    }

  }

}
