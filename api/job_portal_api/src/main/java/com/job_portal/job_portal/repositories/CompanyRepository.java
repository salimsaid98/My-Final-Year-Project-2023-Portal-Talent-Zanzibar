package com.job_portal.job_portal.repositories;

import com.job_portal.job_portal.tables.company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<company,Integer> {
    @Query(value = "SELECT * from company where user_id = ?1",nativeQuery = true)
    Optional<company> getCompanyInformationUsingUserId(Integer user_id);
}
