package com.job_portal.job_portal.repositories;

import com.job_portal.job_portal.tables.job_location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobLocationRepository extends JpaRepository<job_location,Integer> {
}
