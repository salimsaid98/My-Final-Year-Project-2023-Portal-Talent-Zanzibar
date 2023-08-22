package com.job_portal.job_portal.repositories;

import com.job_portal.job_portal.tables.education_details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationDetailsRepository extends JpaRepository<education_details,Integer> {
    @Query(value = "SELECT * from education_details where user_id = ?1",nativeQuery = true)
    List<education_details> list_of_education_details_for_this_user(Integer user_id);
}
