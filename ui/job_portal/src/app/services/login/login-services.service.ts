import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LoginServicesService {

  private login = environment.url + 'login';

  constructor(
    private http: HttpClient
   ) { }

    login_authentication(username:any,password:any):Observable<any>{
      return this.http.get(this.login + '/' + username + '/' + password);
    }

    user_registrations(data:any):Observable<any>{
      return this.http.post(this.login +'/registration',data);
    }

    getAllUsers():Observable<any>{
      return this.http.get(this.login + "/getAllUsers");
    }

    resetPassword(user_id:any,data:any):Observable<any>{
      return this.http.put(this.login + "/resetPassword/" + user_id,data);
    }
}
