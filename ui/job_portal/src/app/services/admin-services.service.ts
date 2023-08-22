import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AdminServicesService {

  private job_type = environment.url + 'job_type';

  private skills = environment.url + 'skills';

  private specialization = environment.url + 'specialization';

  constructor( private http:HttpClient ) { }


  saveJobType(data:any):Observable<any>{
    return this.http.post(this.job_type + '/postJob' , data);
  }

  updateJobType(id:any,data:any):Observable<any>{
    return this.http.put(this.job_type + '/update_job_type/' +id, data);
  }

  getAllJobType():Observable<any>{
    return this.http.get(this.job_type + '/getAllJobType');
  }

  saveSkill(data:any):Observable<any>{
    return this.http.post(this.skills + "/save",data);
  }

  updateSkill(id:any,data:any):Observable<any>{
    return this.http.put(this.skills + "/updateSkill/" + id,data);
  }

  getAllSkills():Observable<any>{
    return this.http.get(this.skills + "/getAllSkills");
  }



  saveSpecialization(data:any):Observable<any>{
      return this.http.post(this.specialization + "/saveSpecialization",data);
  }

  updateSpecialization(id:any, data:any):Observable<any>{
    return this.http.put(this.specialization + "/updateSpecialization/" + id,data);
  }

  getAllSpecializations():Observable<any>{
    return this.http.get(this.specialization + "/getAllSpecialization");
  }
}
