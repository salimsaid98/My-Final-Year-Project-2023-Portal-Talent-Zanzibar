import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CompSpecializationService {

  private specialization = environment.url + 'specialization';
  private company_specialization = environment.url + 'company_specialization';

  constructor(
    private http: HttpClient
   ) { }


   getAllSpecializations():Observable<any>{
    return this.http.get(this.specialization + "/getAllSpecialization");
   }

   saveCompanySpecialization(data:any):Observable<any>{
    return this.http.post(this.company_specialization + "/saveCompanySpecialization",data);
   }

   getAllCompanySpecializationForSpecificCompany(user_id:any):Observable<any>{
      return this.http.get(this.company_specialization + "/getAllCompanySpecializationForSpecificCompany/" + user_id)
   }
}
