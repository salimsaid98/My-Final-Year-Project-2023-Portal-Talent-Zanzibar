package com.job_portal.job_portal.repositories;


import com.job_portal.job_portal.tables.job_type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobTypeRepository extends JpaRepository<job_type,Integer> {
}
