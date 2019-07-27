import { Component, OnInit } from '@angular/core';
import { Result } from 'src/app/model/result';
import { DatePipe } from '@angular/common';
import { AuthServiceService } from 'src/app/auth-service.service';

@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css']
})
export class ResultComponent implements OnInit {
  x= new Result();
  totalques='';
  correct='';
  constructor(private datePipe:DatePipe,private authService:AuthServiceService) { }

  ngOnInit() {
    this.authService.setHeaderContent(sessionStorage.getItem('user'));
    this.x.course=sessionStorage.getItem('subject');
    this.x.percentage=parseInt(sessionStorage.getItem('percent'));
    this.x.result=sessionStorage.getItem('res');
    this.x.userId=parseInt(sessionStorage.getItem('userid'));
    this.x.wrongAns=parseInt(sessionStorage.getItem('wrongans'));
    this.x.date = this.datePipe.transform(new Date(),"MMM d, y, h:mm a");
    this.totalques =sessionStorage.getItem('totalques');
    this.correct =sessionStorage.getItem('correctans');
    if(this.x.course!=null&&this.x.course!=''){
      this.authService.storeResult(this.x.course,this.x.percentage,this.x.result,this.x.userId,this.x.wrongAns,this.x.date).subscribe( (data )=> {
        console.log(data) ; });
      }

      sessionStorage.removeItem('subject');
      sessionStorage.removeItem('subjectid');
      sessionStorage.removeItem('percent');
      sessionStorage.removeItem('res');
      sessionStorage.removeItem('userid');
      sessionStorage.removeItem('wrongans');
      sessionStorage.removeItem('totalques');
      sessionStorage.removeItem('correctans');
      sessionStorage.removeItem('exam');
  
  }


 
}
