package com.job_portal.job_portal.repositories;

import com.job_portal.job_portal.tables.SeekerLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public interface LanguageRepository extends JpaRepository<SeekerLanguage,Integer> {

    @Query(value = "SELECT * from seeker_language sl where sl.seeker_id = ?1",nativeQuery = true)
    List<SeekerLanguage> getAllSeekerLanguages(Integer seeker_id);
}
