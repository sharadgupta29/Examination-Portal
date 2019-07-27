import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { DashboardComponent } from './student/dashboard/dashboard.component';
import { UpdateprofileComponent } from './student/updateprofile/updateprofile.component';
import { LoginComponent } from './login/login.component';

import { ExamPageComponent } from './exam/exam-page/exam-page.component';
import { ActivateService } from './security/activate.service';
import { Page404Component } from './page404/page404.component';
import { ExamInstructionComponent } from './exam/exam-instruction/exam-instruction.component';
import { ResultComponent } from './exam/result/result.component';
import { InstruuctioncheckService } from './security/instruuctioncheck.service';
import { LogincheckService } from './security/logincheck.service';

const routes: Routes = [
{path:'',redirectTo:'/login',pathMatch:'full'},

{path:'student',
component: DashboardComponent ,
canActivate:[ActivateService]},

{path:'instructions',
component:ExamInstructionComponent,
canActivate:[InstruuctioncheckService]},

{path:'examresult',
component:ResultComponent,
canActivate:[InstruuctioncheckService]},


{path:'login',
component:LoginComponent,
canActivate:[LogincheckService]},


{path:'exampage',
component:ExamPageComponent,
canActivate:[InstruuctioncheckService]},

{path:'profile-update',
component:UpdateprofileComponent,
canActivate:[ActivateService]},


{path:'404',
component:Page404Component},
{path: '**', redirectTo: '/404'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
