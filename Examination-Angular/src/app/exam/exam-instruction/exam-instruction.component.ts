import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthServiceService } from 'src/app/auth-service.service';

@Component({
  selector: 'app-exam-instruction',
  templateUrl: './exam-instruction.component.html',
  styleUrls: ['./exam-instruction.component.css']
})
export class ExamInstructionComponent implements OnInit {

  constructor(private router:Router,private authService:AuthServiceService) { }

  ngOnInit() {
    this.authService.setHeaderContent(sessionStorage.getItem('user'));
  }
 

  giveExam(){
   
      this.router.navigate(['/exampage']);
    }

    cancel(){
      
      sessionStorage.removeItem('subjectid');
      this.router.navigate(['/student']);
  
    }

  }



