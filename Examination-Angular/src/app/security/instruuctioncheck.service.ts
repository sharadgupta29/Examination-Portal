import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { Guard1Service } from './guard1.service';

@Injectable({
  providedIn: 'root'
})
export class InstruuctioncheckService implements CanActivate {
  

  constructor(private router:Router, private guard1:Guard1Service) { }
  

  canActivate(){
    if(this.guard1.isInstructionAllow()) return true;
    else 
    {  
      this.router.navigate(['/student']);
      return false;
    }
  }

    
}


