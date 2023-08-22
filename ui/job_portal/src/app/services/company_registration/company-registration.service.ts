import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CompanyRegistrationService {

  private company_logo = environment.url + 'company_logo';
  private company = environment.url + 'company';

  constructor( private http:HttpClient ) { }

  saveCompany(data:any):Observable<any>{
    return this.http.post(this.company + "/saveCompany",data);
  }

  getAllCompany():Observable<any>{
    return this.http.get(this.company + "/getAllCompanies");
  }

  getCompanyById(id:string):Observable<any>{
    return this.http.get(this.company + "/getCompanyById/" + id);
  }

  saveCompanyLogo(form_data:any,company_id:any):Observable<any>{
    return this.http.post(this.company_logo + "/upload_logo/"+ company_id,form_data)
  }

  getCompanyLogo(company_id:any):Observable<any>{
    return this.http.get(this.company_logo + "/get_image/info/"+ company_id);
  }

  getCompanyInformationUsingUserId(user_id:any):Observable<any>{
    return this.http.get(this.company +"/getCompanyInformationUsingUserId/" + user_id);
  }

  updateCompanyInformation(company_id:any, company_data:any):Observable<any>{
    return this.http.put(this.company +"/updateCompany/" + company_id, company_data);
  }

}
