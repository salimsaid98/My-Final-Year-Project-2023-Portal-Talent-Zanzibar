package com.job_portal.job_portal.repositories;


import com.job_portal.job_portal.tables.seeker_experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeekerExperienceRepository extends JpaRepository<seeker_experience,Integer> {

    @Query(value = "SELECT * from seeker_experience where seeker_id = ?1",nativeQuery = true)
    List<seeker_experience> getAllSeekerExperienceForSpecificUser(Integer seeker_id);
}
