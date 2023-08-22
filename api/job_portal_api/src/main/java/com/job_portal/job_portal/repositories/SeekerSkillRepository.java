package com.job_portal.job_portal.repositories;


import com.job_portal.job_portal.tables.seeker_skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeekerSkillRepository extends JpaRepository<seeker_skills,Integer> {

    @Query(value = "SELECT * from seeker_skills WHERE seeker_id = ?1",nativeQuery = true)
    List<seeker_skills> getAllSeekerSkillsOfSeeker(Integer seeker_id);

}
