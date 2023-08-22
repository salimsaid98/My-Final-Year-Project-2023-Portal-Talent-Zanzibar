package com.job_portal.job_portal.repositories;

import com.job_portal.job_portal.tables.skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsRepository extends JpaRepository<skills,Integer> {
}
