import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class Guard1Service {

  constructor() { }

  isUserLoggedIn(){
    if(sessionStorage.getItem('token')!=null){
    return true;
    }
    else
    {
    return false;
    }
  }

  isInstructionAllow(){
    if(sessionStorage.getItem('subject')!=null&&sessionStorage.getItem('subject')!=''){
     
    return true;
    }
    else
    {
     
    return false;
    }
  }

  isExamAllow(){
    if(sessionStorage.getItem('subject')!=null || sessionStorage.getItem('exam')!=null){
      
    return true;
    }
    else
    {
      
    return false;
    }
  }
  isLoginAllowed(){
    if(sessionStorage.getItem('token')==null){
    return true;
    }
    else
    {
    return false;
    }
  }
}
