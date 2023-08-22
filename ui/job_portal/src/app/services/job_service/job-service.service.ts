import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class JobServiceService {

  private job_type = environment.url + 'job_type';
  private job_post = environment.url + 'job_post';
  private job_location = environment.url + 'job_location';
  private job_skills = environment.url + 'job_skills';
  private skills = environment.url + 'skills';

  constructor( private http:HttpClient ) { }
  getAllJobTypeList():Observable<any>{
    return this.http.get(this.job_type + "/getAllJobType");
  }
  getSkills():Observable<any>{
    return this.http.get(this.skills + "/getAllSkills");
  }
  getAllJobPostSpecificCompany(company:any):Observable<any>{
    return this.http.get(this.job_post + "/getAllJobPostSpecificCompany/" + company);
  }
  getAllJobPostSpecificCompany2(company:any):Observable<any>{
    return this.http.get(this.job_post + "/getAllJobPostSpecificCompany2/" + company);
  }
  getAllJobPostSpecificCompanyByJobPostId(job_post_id:any):Observable<any>{
    return this.http.get(this.job_post + "/getAllJobPostSpecificCompanyByJobPostId/" + job_post_id);
  }
  getAllJobPostWithInformation():Observable<any>{
    return this.http.get(this.job_post + "/getAllJobPostWithInformation");
  }
  saveJobLocation(data:any):Observable<any>{
    return this.http.post(this.job_location + "/save_job_location",data);
  }
  saveJobPosts(data:any):Observable<any>{
    return this.http.post(this.job_post + "/save_job_post",data);
  }
  saveJobSkill(data:any):Observable<any>{
    return this.http.post(this.job_skills + "/save_job_skill",data);
  }
  countAllMyJobs(company_id:any):Observable<any>{
    return this.http.get(this.job_post + "/countAllMyJobs/" + company_id);
  }
  getAllJobPostGroupByType():Observable<any>{
    return this.http.get(this.job_post + "/getAllJobPostGroupByType");
  }
  searchAllJobPost(tittle:any):Observable<any>{
    return this.http.get(this.job_post + "/searchAllJobPost/" + tittle)
  }
  searchAllJobPostSpecificCompany(company_id:any,tittle:any):Observable<any>{
    return this.http.get(this.job_post + "/searchAllJobPostSpecificCompany/" + company_id + "/" + tittle)
  }
  getJobsByExperienceAndCompany(company_id:any,experience:any):Observable<any>{
    return this.http.get(this.job_post + "/getJobsByExperienceAndCompany/" + company_id + "/" + experience)
  }
  getJobsByExperienceAndCompanyAndCategory(company_id:any,experience:any,category_id:any):Observable<any>{
    return this.http.get(this.job_post + "/getJobsByExperienceAndCompanyAndCategory/" + company_id + "/" + experience + "/" + category_id)
  }
  getJobsByExperienceAndCompanyAndCategoryAndType(company_id:any,experience:any,category_id:any,type_id:any):Observable<any>{
    return this.http.get(this.job_post + "/getJobsByExperienceAndCompanyAndCategoryAndType/" + company_id + "/" + experience + "/" + category_id + "/" + type_id);
  }
  getJobsByTypeNameAndCompany(company_id:any,type_name:any):Observable<any>{
    return this.http.get(this.job_post + "/getJobsByTypeNameAndCompany/" + company_id + "/" + type_name);
  }
  getJobsByTypeName(type_name:any):Observable<any>{
    return this.http.get(this.job_post + "/getJobsByTypeName/" + type_name)
  }

  getAllJobPost():Observable<any>{
    return this.http.get(this.job_post + "/list_of_job_post");
  }
}
