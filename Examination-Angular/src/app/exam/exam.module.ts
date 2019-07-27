import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DatePipe } from '@angular/common';
import { ExamInstructionComponent } from './exam-instruction/exam-instruction.component';
import { ExamPageComponent } from './exam-page/exam-page.component';
import { ExamRoutingModule } from './exam-routing.module';
import { ResultComponent } from './result/result.component';
import { FormsModule } from '@angular/forms';
@NgModule({
  declarations: [ExamInstructionComponent, ExamPageComponent, ResultComponent],
  imports: [
    CommonModule,
    ExamRoutingModule,
    FormsModule
  ],
  providers: [
    DatePipe
  ]
})
export class ExamModule { }
