import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ReportServiceService {

  private report = environment.url + 'report';

  constructor( private http:HttpClient ) { }

  countCompanies():Observable<any>{
    return this.http.get(this.report + "/countCompanies");
  }

  countAllApplicant():Observable<any>{
    return this.http.get(this.report + "/countAllApplicant");
  }

  countAllJobPost():Observable<any>{
    return this.http.get(this.report + "/countAllJobPost");
  }
}
