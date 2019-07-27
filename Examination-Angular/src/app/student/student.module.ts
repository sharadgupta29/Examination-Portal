import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { DashboardComponent } from './dashboard/dashboard.component';
import { ProfileComponent } from './profile/profile.component';
import { TakeExamComponent } from './take-exam/take-exam.component';
import { ResultComponent } from './result/result.component';
import { UpdateprofileComponent } from './updateprofile/updateprofile.component';

@NgModule({
  declarations: [DashboardComponent, ProfileComponent, TakeExamComponent, ResultComponent, UpdateprofileComponent],
  imports: [
    CommonModule,
 
    FormsModule   
  ]
})
export class StudentModule { }
