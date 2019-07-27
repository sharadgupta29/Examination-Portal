import { Component, OnInit } from '@angular/core';
import{Registration} from '../registration';
import { AuthServiceService } from '../auth-service.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  fpComment:string;
  fpMail:String;
  mail:String;
  pass:String;
  x:Registration;
  token:string;
  constructor(private router:Router, private authService:AuthServiceService) {

    this.x=new Registration();
      this.x.contact="";
      this.x.userID=0;
      this.x.emailId=""; 
      this.x.city="";
      this.x.gender="";
      this.x.name="";
      this.x.password="";
      this.x.state="";
      this.fpComment=null;
   }

  ngOnInit() {
    this.fpComment=null;
  }
  public login(){
    this.fpComment=null;
     this.authService.loginCall(this.mail,this.pass).subscribe( (data )=> {
      console.log(data) ; 
      this.x=data;
      this.authService.usr=data;
      console.log(this.x.city) ; 
      if(this.x.userID!=0){
        
        this.token="user-"+this.x.userID;
        sessionStorage.setItem("token" , this.token);
        sessionStorage.setItem("user" , this.x.emailId);
        sessionStorage.setItem('userid',this.x.userID+'');
        
        console.log(sessionStorage.getItem("token")) ; 
        this.router.navigate(['/student']);
      }
      else{
        this.mail = null;
        this.pass = null;
        this.fpComment="Please enter valid details ";
      }
     
    });
      console.log(this.x.city) ; 
     
  }

  public getPassword(){
    
    this.authService.getPassword(this.fpMail).subscribe( (data :any)=> {
     console.log(data);
      this.fpComment=data.fpresult;
      console.log(this.fpComment);
    })
}

}

