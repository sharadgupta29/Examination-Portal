import { Injectable } from '@angular/core';
import {Registration} from './registration';
import { Observable,BehaviorSubject} from 'rxjs';
import { HttpClient,HttpParams } from '@angular/common/http';
import {Result} from './model/result';
import{Subject} from './model/subject';
import{Question} from './model/question';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {
 /*...................result properties....................*/
  result:Result;
  usr:Registration;
  seconds: number;
  timer;
  user = new BehaviorSubject('');
  logoutcheck = new BehaviorSubject('');
 
  displayTimeElapsed() {
    if(this.seconds>0)
    return Math.floor(this.seconds / 3600) + ':' + Math.floor(this.seconds / 60) + ':' + Math.floor(this.seconds % 60);
    else
    return "00:00";
  }



  uri = 'http://localhost:8099';
  constructor(private mac :HttpClient) { }

  loginCall(x :String,y:String) :Observable<Registration>{
    
    let urilink="/log?x="+x+"&y="+y; 
    
    return this.mac.get<Registration>(this.uri+urilink);

}

getResult(x:String):Observable<Result>{

  let urilink="/result?n="+x;
  return this.mac.get<Result>(this.uri+urilink);
}
  

getAllSubjects(x:String):Observable<Subject>{

  let urilink="/SubMs?n="+x;
  return this.mac.get<Subject>(this.uri+urilink);
}


getAllQuestions(x:String,y:String):Observable<Question>{

  let urilink="/getquestion?u="+x+"&s="+y;
  return this.mac.get<Question>(this.uri+urilink);
}
  setHeaderContent(user:string){
    this.user.next(user);
    
  }
  setHeaderLogout(logout:string){
    this.logoutcheck.next(logout);
    
  }

  getPassword(x :String) {
    
    let urilink="/getPassword?x="+x; 
    
    return this.mac.get(this.uri+urilink);

}

getProfile(x :String) :Observable<Registration>{
    
  let urilink="/getProfile?x="+x; 
  
  return this.mac.get<Registration>(this.uri+urilink);

}

UpdateProfile(x:Registration) :Observable<Registration>{
    
  let urilink="/updProfile"; 
 
  return this.mac.post<Registration>(this.uri+urilink,x);

}
storeResult(cor :String,per:Number,res:String,uid:Number,wans:Number,date:String) {
    
  let urilink="/storeResult?cor="+cor+"&per="+per+"&res="+res+"&uid="+uid+"&wans="+wans+"&date="+date; 
  
  return this.mac.get(this.uri+urilink);

}
}
