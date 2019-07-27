import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { Guard1Service } from './guard1.service';

@Injectable({
  providedIn: 'root'
})
export class ActivateService implements CanActivate {
  

  constructor(private router:Router, private guard1:Guard1Service) { }
  

  canActivate(){
   if(sessionStorage.getItem('exam')!=null)
   this.router.navigate(['/exampage']);

    else if(this.guard1.isUserLoggedIn()) return true;
    else 
    {  this.router.navigate(['/login']);
      return false;
    } 

    
}


}