package com.job_portal.job_portal.repositories;


import com.job_portal.job_portal.tables.company_specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public interface CompanySpecializationRepository extends JpaRepository<company_specialization,Integer> {

    @Query(value = "SELECT c.company_name,s.specialization_name,s.specialization_id " +
            "from company_specialization cs,specialization s,company c where " +
            "cs.specialization_id = s.specialization_id and c.company_id = cs.company_id " +
            "and c.user_id = ?1",nativeQuery = true)
    List<Map<String, Objects>> getAllCompanySpecializationForSpecificCompany(Integer user_id);
}
