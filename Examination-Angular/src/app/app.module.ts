import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule} from '@angular/forms'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';

import { FooterComponent } from './footer/footer.component';
import { ExamModule } from './exam/exam.module';
import { StudentModule } from './student/student.module';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HttpClientModule } from '@angular/common/http';
import { ActivateService } from './security/activate.service';
import { Page404Component } from './page404/page404.component';

import { SupportComponent } from './support/support.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    LoginComponent,
    RegisterComponent,
    Page404Component,
    SupportComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ExamModule,
    StudentModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [ActivateService],
  bootstrap: [AppComponent]
})
export class AppModule { }
