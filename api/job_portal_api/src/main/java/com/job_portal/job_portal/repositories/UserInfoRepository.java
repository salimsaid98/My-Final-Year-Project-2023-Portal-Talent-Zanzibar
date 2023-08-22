package com.job_portal.job_portal.repositories;

import com.job_portal.job_portal.tables.user_information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserInfoRepository extends JpaRepository<user_information,Integer> {

    @Query(value = "SELECT * FROM user_information ui where user_id = ?1",nativeQuery = true)
    Optional<user_information> getUserInformationUsingUserID(int user_id);
}
