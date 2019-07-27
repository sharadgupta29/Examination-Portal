import { Component, OnInit } from '@angular/core';
import { Result } from 'src/app/model/result';
import { AuthServiceService } from 'src/app/auth-service.service';


@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css']
})
export class ResultComponent implements OnInit {
  x:Result;
  constructor(private authService:AuthServiceService) { }

  ngOnInit() {
    // Get User Result
    this.x=new Result();
    this.authService.getResult(sessionStorage.getItem('token')).subscribe( (data )=> {
     console.log(data) ; 
     this.x=data;
     
   });
  }

}
