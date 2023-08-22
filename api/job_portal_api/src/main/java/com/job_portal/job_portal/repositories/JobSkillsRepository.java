package com.job_portal.job_portal.repositories;


import com.job_portal.job_portal.tables.job_skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobSkillsRepository extends JpaRepository<job_skills,Integer> {
}
