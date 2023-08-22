package com.job_portal.job_portal.repositories;

import com.job_portal.job_portal.tables.seeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Repository
public interface SeekerRepository extends JpaRepository<seeker,Integer> {
    @Query(value = "SELECT *,SUBSTR(ed.starting_date,1,4) as from_date,SUBSTR(ed.end_date,1,4) as todate from seeker s,seeker_experience se,seeker_skills ss,education_details ed \n" +
            "where s.seeker_id = se.seeker_id and s.seeker_id = ss.seeker_id \n " +
            "and s.seeker_id  = ed.seeker_id and s.user_information_id  = ?1",nativeQuery = true)
    List<Map<String, Objects>> getSeekerAllInformation(Integer id);

    @Query(value = "SELECT * from seeker where user_information_id = ?1",nativeQuery = true)
    Optional<seeker> getSeekerByInformationID(int information_id);
}
