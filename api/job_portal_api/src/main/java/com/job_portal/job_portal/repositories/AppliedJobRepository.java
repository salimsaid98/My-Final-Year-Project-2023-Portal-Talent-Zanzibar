package com.job_portal.job_portal.repositories;

import com.job_portal.job_portal.tables.applied_jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Repository
public interface AppliedJobRepository extends JpaRepository<applied_jobs,Integer> {

    @Query(value = "SELECT * from applied_jobs where seeker_id = ?1 and job_post_id = ?2",nativeQuery = true)
    Optional<applied_jobs> checkExisting(Integer seeker_id,Integer job_post_id);

    @Query(value = "SELECT * from applied_jobs where seeker_id = ?1 and job_post_id = ?2",nativeQuery = true)
    Optional<applied_jobs> getAppliedJobData(Integer seeker_id,Integer job_post_id);

    @Query(value = "select aj.applied_date,aj.apply_id,aj.seeker_id,jp.job_post_id,aj.status,ui.user_id,ui.last_name, \n " +
            "ui.first_name,ui.middle_name,ui.last_name,ui.gender,ui.country_of_origin,ui.specialization,jp.company_id \n " +
            "from applied_jobs aj,job_post jp,seeker s,user_information ui where jp.job_post_id = aj.job_post_id \n " +
            "and s.seeker_id = aj.seeker_id and ui.user_information_id = s.user_information_id \n " +
            "and jp.company_id = ?1",nativeQuery = true)
    List<Map<String, Objects>> getAllApplicantAppliedMyCompany(int company_id);

    @Query(value = "SELECT aj.applied_date,aj.apply_id,aj.seeker_id,jp.job_post_id,aj.status,ui.user_id,ui.last_name, \n " +
            "ui.first_name,ui.middle_name,ui.last_name,ui.gender,ui.country_of_origin,ui.specialization,jp.company_id \n " +
            "from applied_jobs aj,job_post jp,seeker s,user_information ui where jp.job_post_id = aj.job_post_id \n " +
            "and s.seeker_id = aj.seeker_id and ui.user_information_id = s.user_information_id \n " +
            "and jp.company_id = ?1 and aj.status = 1 and aj.job_post_id = ?2",nativeQuery = true)
    List<Map<String, Objects>> getAllSuccessApplicantAppliedMyCompany(int company_id,int job_post_id);

    @Query(value = "SELECT COUNT(*) as total_job_applied FROM applied_jobs WHERE seeker_id = ?",nativeQuery = true)
    List<Map<String, Objects>> countAllJobApplied(int seeker_id);

    @Query(value = "SELECT COUNT(*) as total_success_job_applied FROM applied_jobs WHERE seeker_id = ? and status = 1",nativeQuery = true)
    List<Map<String, Objects>> countAllSuccessJobApplied(int seeker_id);
    @Query(value = "SELECT COUNT(*) as total_job_applied FROM applied_jobs WHERE seeker_id = ? and status = 0",nativeQuery = true)
    List<Map<String, Objects>> countAllNotApprovedJobApplied(int seeker_id);


    @Query(value = "SELECT COUNT(*) as all_app \n " +
            "from applied_jobs aj,job_post jp,seeker s,user_information ui where jp.job_post_id = aj.job_post_id \n " +
            "and s.seeker_id = aj.seeker_id and ui.user_information_id = s.user_information_id \n " +
            "and jp.company_id = ?1",nativeQuery = true)
    List<Map<String, Objects>> countAllApplicationSubmitted(int company_id);
    @Query(value = "SELECT COUNT(*) as all_success_app \n " +
            "from applied_jobs aj,job_post jp,seeker s,user_information ui where jp.job_post_id = aj.job_post_id \n " +
            "and s.seeker_id = aj.seeker_id and ui.user_information_id = s.user_information_id \n " +
            "and jp.company_id = ?1 and aj.status = 1",nativeQuery = true)
    List<Map<String, Objects>> countAllSuccessApplicationSubmitted(int company_id);

    @Query(value = "select aj.applied_date,aj.apply_id,aj.seeker_id,jp.job_post_id,aj.status,ui.user_id,ui.last_name, \n " +
            "ui.first_name,ui.middle_name,ui.last_name,ui.gender,ui.country_of_origin,ui.specialization,jp.job_tittle,jp.company_id \n " +
            "from applied_jobs aj,job_post jp,seeker s,user_information ui where jp.job_post_id = aj.job_post_id \n " +
            "and s.seeker_id = aj.seeker_id and ui.user_information_id = s.user_information_id \n " +
            "and aj.seeker_id = ?1",nativeQuery = true)
    List<Map<String, Objects>> getAllApplicationIApplied(int seeker_id);

}
