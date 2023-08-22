import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RegistrationServicesService {

  private user_logo = environment.url + 'seeker_logo';
  private registration = environment.url + 'user_information';

  constructor(
    private http: HttpClient
   ) { }

    saveUser_Information(data:any):Observable<any>{
      return this.http.post(this.registration + "/put_user_information", data);
    }

    getAllUsersInformation():Observable<any>{
      return this.http.get(this.registration + "/getAllUsersInformation");
    }

    updateUserInformation(user_id:any, data:any):Observable<any>{
      return this.http.put(this.registration + "/updateUserInformation/" + user_id, data);
    }

    getSpecificUserInformation(user_id:any):Observable<any>{
      return this.http.get(this.registration + "/getSpecificUserInformation/" + user_id);
    }

    saveUserLogo(data:any,user_id:any):Observable<any>{
      return this.http.post(this.user_logo + "/upload_seeker_logo/" + user_id, data);
    }

    getSeeker_logo(user_id:any):Observable<any>{
      return this.http.get(this.user_logo + "/get_seeker_image/info/" + user_id);
    }

}
