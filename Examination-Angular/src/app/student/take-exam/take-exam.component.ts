import { Component, OnInit } from '@angular/core';
import { Subject } from 'src/app/model/subject';
import { AuthServiceService } from 'src/app/auth-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-take-exam',
  templateUrl: './take-exam.component.html',
  styleUrls: ['./take-exam.component.css']
})
export class TakeExamComponent implements OnInit {
  x:Subject;
  sub:Number;
  description:"please select subject from above list to give exam.";
  subject:"";
  constructor(private authService:AuthServiceService,private router:Router) { 
    this.description="please select subject from above list to give exam.";
  this.subject="";
  }

  ngOnInit() {
    this.x=new Subject();
    this.authService.getAllSubjects(sessionStorage.getItem('token')).subscribe( (data )=> {
     console.log(data) ; 
     this.x=data;
     
   });
  }

  SelectChangeHadndler(event: any){

      this.sub=event.target.value;
      console.log("any");
      console.log("selected sub="+this.sub);
      console.log("selected sub="+this.x[0].subject);
      let i=0,c=0;
      while(this.x[i]!=null){
        if(this.x[i].subjectId==this.sub){
 
          this.subject=this.x[i].subject;
          this.description=this.x[i].description;
          console.log("selected sub="+this.description);
          c++;
        }
        i++;

      }
      if(c==0){
        this.subject='';
        this.description="please select subject from above list to give exam.";
      }
      
     
  }


  fetchQuestions(){
    console.log(this.sub);
    if(this.subject!=null&&this.subject!=''){
    sessionStorage.setItem('subjectid',this.sub+'');
    sessionStorage.setItem('subject',this.subject);
      this.router.navigate(['/instructions']);
    }

  }
}
