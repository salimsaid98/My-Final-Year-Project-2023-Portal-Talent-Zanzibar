package com.job_portal.job_portal.repositories;

import com.job_portal.job_portal.tables.SeekerLogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeekerLogoRepository extends JpaRepository<SeekerLogo,Integer> {
    @Query(value = "SELECT * from seeker_logo where user_id = ?1",nativeQuery = true)
    Optional<SeekerLogo> getSeekerLogo(Integer user_id);
}
