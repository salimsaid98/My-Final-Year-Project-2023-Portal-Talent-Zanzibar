package com.job_portal.job_portal.repositories;

import com.job_portal.job_portal.tables.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report,Integer> {

    @Query(value = "SELECT COUNT(*) as company_number FROM company",nativeQuery = true)
    int CountAllCompanies();

    @Query(value = "SELECT COUNT(*) as applicant from user_information",nativeQuery = true)
    int countAllApplicant();
    @Query(value = "SELECT COUNT(*) as jobs from job_post where status = 1",nativeQuery = true)
    int countAllJobPost();

}
