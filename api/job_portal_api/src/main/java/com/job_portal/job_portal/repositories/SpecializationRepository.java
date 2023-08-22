package com.job_portal.job_portal.repositories;

import com.job_portal.job_portal.tables.specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SpecializationRepository extends JpaRepository<specialization,Integer> {

}
