package com.job_portal.job_portal.repositories;

import com.job_portal.job_portal.tables.login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<login,Integer> {
    @Query(value = "SELECT * from login where username = ?1",nativeQuery = true)
    Optional<login> check_existing_user(String username);
    @Query(value = "SELECT * from login WHERE username = ?1 and password = ?2 and status = ?3",nativeQuery=true)
    Optional<login> login_authentication(String username,String password,String status);

    @Query(value = "SELECT * from login order by username asc",nativeQuery = true)
    List<login> getAllUsers();
}
