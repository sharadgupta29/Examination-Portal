import { Component, OnInit } from '@angular/core';
import { AuthServiceService } from 'src/app/auth-service.service';
import { Question } from 'src/app/model/question';
import { Result } from 'src/app/model/result';
import { LocationStrategy } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-exam-page',
  templateUrl: './exam-page.component.html',
  styleUrls: ['./exam-page.component.css']
})
export class ExamPageComponent implements OnInit {
  x:Question;
  y:any[];
  answer=[];
  progress:number;
  max:number;
  constructor(private authService:AuthServiceService,private locationStrategy: LocationStrategy,private router:Router) {
    //prevent back button
    history.pushState(null, null, location.href);
    this.locationStrategy.onPopState(() => {
      history.pushState(null, null, location.href);  })
   }
  
  ngOnInit() {
    this.authService.setHeaderContent(sessionStorage.getItem('user')); 
    this.authService.setHeaderLogout(null);
    this.progress=0;
    sessionStorage.setItem('exam','true');
  
    this.authService.getAllQuestions(sessionStorage.getItem('token'),sessionStorage.getItem('subjectid')).subscribe( (data:any )=> {
      console.log(data);
      this.y=data;
      this.max=0;
      while(this.y[this.max]!=null){
        
        this.answer.push('invalid');
        this.max++;
        console.log(this.answer);
      }
      this.authService.seconds=90*this.max;
      this.startTimer();
     // this.answer.length=i+1; 
      console.log(this.y);
    });

   
  }
  ngOnDestroy(){
    this.authService.setHeaderLogout('Logout');

  }
  retDisplayTimeElapsed(){
    let x;
    x=this.authService.displayTimeElapsed();
    if(x=="00:00"){
      localStorage.removeItem('seconds');
      this.submitexam();
      
    }
    else
    return x;
  }
  
  startTimer() {
    this.authService.timer = setInterval(() => {
      this.authService.seconds--;
      localStorage.setItem('seconds', this.authService.seconds.toString());
    }, 1000);
  }

  SelectChangeHadndler(event: any){
    this.answer[this.progress]=event.target.value;
    console.log(this.answer);
  }
  
  next(){
    this.progress++;

  }
  prev(){
    this.progress--;
  }
  checkprogress(event:any){
    this.progress=+event.target.value;

  }

  submitexam(){
    let i=0;
    let count=0;
    let result=new Result();
    while(this.y[i]!=null){
      if(this.y[i].correctoption==this.answer[i]){
        ++count;
      }
      i++;
      //percentage
      let perc=Math.round((count*100)/this.max);
      
      let res;
      if(perc>40)
      res='pass';
      else
      res='fail';
      sessionStorage.setItem('totalques',this.max+'');
      sessionStorage.setItem('correctans',count+'');
      sessionStorage.setItem('wrongans',(this.max-count)+'');
      sessionStorage.setItem('percent',perc+'');
      sessionStorage.setItem('res',res);
      this.router.navigate(['/examresult']);
  
    }
    
  }
}
