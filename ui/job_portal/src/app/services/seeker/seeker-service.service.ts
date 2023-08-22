import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SeekerServiceService {

  private seeker = environment.url + 'seeker';
  private education_details = environment.url + 'education_details';
  private seeker_skill = environment.url + 'seeker_skill';
  private seeker_experience = environment.url + 'seeker_experience';
  private seeker_language = environment.url + 'seeker_language';
  private apply_job = environment.url + 'apply_job';
  private seeker_logo = environment.url + 'seeker_logo';

  constructor( private http:HttpClient ) { }


  saveSeeker(data:any):Observable<any>{
    return this.http.post(this.seeker + "/saveSeeker", data);
  }

  saveEducationDetails(data:any):Observable<any>{
    return this.http.post(this.education_details + "/saveEducationDetails", data);
  }

  list_of_education_details_for_this_user(user_id:any):Observable<any>{
    return this.http.get(this.education_details + "/list_of_education_details_for_this_user/" + user_id);
  }

  saveSeekerSkillls(data:any):Observable<any>{
    return this.http.post(this.seeker_skill + "/saveSeekerSkills",data);
  }

  saveSeekerExperience(data:any):Observable<any>{
    return this.http.post(this.seeker_experience + "/saveSeekerExperience",data);
  }

  saveSeekerlanguage(data:any):Observable<any>{
    return this.http.post(this.seeker_language + "/saveSeekerLanguage",data);
  }

  saveAppliedJob(data:any):Observable<any>{
    return this.http.post(this.apply_job + "/post_applied_job",data);
  }

  getSeekerAllInformation(user_information_id:any):Observable<any>{
    return this.http.get(this.seeker + "/getSeekerAllInformation/" + user_information_id);
  }

  getAllSeekerLanguages(seeker_id:any):Observable<any>{
    return this.http.get(this.seeker_language + "/getAllSeekerLanguages/" + seeker_id);
  }

  checkExistingApplication(seeker_id:any,job_post_id:any):Observable<any>{
    return this.http.get(this.apply_job + "/checkExisting/" + seeker_id + "/" + job_post_id);
  }

  getAllApplicantAppliedMyCompany(company_id:any):Observable<any> {
    return this.http.get(this.apply_job + "/getAllApplicantAppliedMyCompany/" + company_id);
  }

  getAppliedJobData(seeker_id:any,job_post_id:any):Observable<any> {
    return this.http.get(this.apply_job + "/getAppliedJobData/" + seeker_id + "/" + job_post_id);
  }

  updateAppliedJob(id:any, job_data:any):Observable<any>{
    return this.http.put(this.apply_job + "/updateAppliedJob/" + id , job_data);
  }

  getAllSuccessApplicantAppliedMyCompany(company_id:any,job_post_id:any):Observable<any>{
    return this.http.get(this.apply_job + "/getAllSuccessApplicantAppliedMyCompany/" + company_id + "/" + job_post_id);
  }

  getSeekerByUserInformationID(user_information_id:any):Observable<any> {
    return this.http.get(this.seeker + "/getSeekerByUserInformationID/" + user_information_id);
  }

  countAllApplicationSubmitted(company_id:any):Observable<any>{
    return this.http.get(this.apply_job + "/countAllApplicationSubmitted/" + company_id);
  }

  countAllSuccessApplicationSubmitted(company_id:any):Observable<any>{
    return this.http.get(this.apply_job + "/countAllSuccessApplicationSubmitted/" + company_id);
  }

  getAllSeekers():Observable<any>{
    return this.http.get(this.seeker + "/getAllSeekers");
  }


  countAllNotApprovedJobApplied(seeker_id:any):Observable<any>{
    return this.http.get(this.apply_job + "/countAllNotApprovedJobApplied/" + seeker_id);
  }

  countAllSuccessJobApplied(seeker_id:any):Observable<any>{
    return this.http.get(this.apply_job + "/countAllSuccessJobApplied/" + seeker_id);
  }

  countAllJobApplied(seeker_id:any):Observable<any>{
    return this.http.get(this.apply_job + "/countAllJobApplied/" + seeker_id);
  }

  getAllApplicationIApplied(seeker_id:any):Observable<any>{
    return this.http.get(this.apply_job + "/getAllApplicationIApplied/" + seeker_id);
  }

  getSeekerLogo(useer_id:any):Observable<any>{
    return this.http.get(this.seeker_logo + "/get_seeker_image/info/" + useer_id);
  }
}
