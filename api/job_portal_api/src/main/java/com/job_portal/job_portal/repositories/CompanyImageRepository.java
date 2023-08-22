package com.job_portal.job_portal.repositories;

import com.job_portal.job_portal.tables.CompanyLogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CompanyImageRepository extends JpaRepository<CompanyLogo,Integer> {
    @Query(value = "SELECT * from company_logo where company_id = ?1",nativeQuery = true)
    Optional<CompanyLogo> getCompanyLogoImage(Integer company_id);
}
