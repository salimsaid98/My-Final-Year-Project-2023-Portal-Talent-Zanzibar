package com.job_portal.job_portal.repositories;

import com.job_portal.job_portal.tables.job_post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Repository
public interface JobPostRepository extends JpaRepository<job_post,Integer> {
    @Query(value = "SELECT * from job_post where status = 1",nativeQuery = true)
    List<job_post> getAllJobPostStatusTrue();
    @Query(value = "SELECT * from job_post where status = 1 and company_id = ?1",nativeQuery = true)
    List<job_post> getAllJobPostSpecificCompany(Integer company_id);

    @Query(value = "SELECT COUNT(*) as total_job_post FROM job_post WHERE company_id = ?1",nativeQuery = true)
    List<Map<String, Objects>> countAllJobsPostForSpecificCompany(Integer company_id);

    @Query(value = "SELECT * from job_post jp,company c,job_type jt,job_location jl \n" +
            "where jp.company_id = c.company_id and jt.job_type_id = jp.job_type_id \n" +
            "and jl.job_location_id = jp.job_location_id and jp.company_id = ?1",nativeQuery = true)
    List<Map<String, Objects>> getAllJobPostSpecificCompany2(Integer company_id);
    @Query(value = "SELECT * from job_post jp,company c,job_type jt,job_location jl \n" +
            "where jp.company_id = c.company_id and jt.job_type_id = jp.job_type_id \n" +
            "and jl.job_location_id = jp.job_location_id and jp.job_post_id = ?1",nativeQuery = true)
    List<Map<String, Objects>> getAllJobPostSpecificCompanyByJobPostId(Integer job_post_id);

    @Query(value = "SELECT * from job_post jp,company c,job_type jt,job_location jl \n" +
            "where jp.company_id = c.company_id and jt.job_type_id = jp.job_type_id \n" +
            "and jl.job_location_id = jp.job_location_id and jp.status = 1 LIMIT 8",nativeQuery = true)
    List<Map<String, Objects>> getAllJobPostWithInformation();

    @Query(value = "SELECT count(jp.job_post_id) as number_of_post,jt.job_type from job_post jp,job_type jt \n" +
            "where jp.job_type_id = jt.job_type_id group by jt.job_type order by jt.job_type asc",nativeQuery = true)
    List<Map<String, Objects>> getAllJobPostGroupByType();

    @Query(value = "SELECT * from job_post jp,company c,job_type jt,job_location jl \n" +
            "where jp.company_id = c.company_id and jt.job_type_id = jp.job_type_id \n" +
            "and jl.job_location_id = jp.job_location_id and jp.company_id = ?1 and " +
            "jp.job_tittle LIKE %?2%",nativeQuery = true)
    List<Map<String, Objects>> SearchAllJobPostSpecificCompany(Integer company_id,String job_tittle);

    @Query(value = "SELECT * from job_post jp,company c,job_type jt,job_location jl \n" +
            "where jp.company_id = c.company_id and jt.job_type_id = jp.job_type_id \n" +
            "and jl.job_location_id = jp.job_location_id and " +
            "jp.job_tittle LIKE %?1%",nativeQuery = true)
    List<Map<String, Objects>> SearchAllJobPost(String job_tittle);
    @Query(value = "SELECT * from job_post jp,company c,job_type jt,job_location jl \n" +
            "where jp.company_id = c.company_id and jt.job_type_id = jp.job_type_id \n" +
            "and jl.job_location_id = jp.job_location_id and " +
            "jp.company_id = ?1 and jp.experience_level = ?2",nativeQuery = true)
    List<Map<String, Objects>> getJobsByExperienceAndCompany(int company_id,String experience_level);

    @Query(value = "SELECT * from job_post jp,company c,job_type jt,job_location jl \n" +
            "where jp.company_id = c.company_id and jt.job_type_id = jp.job_type_id \n" +
            "and jl.job_location_id = jp.job_location_id and " +
            "jp.company_id = ?1 and jp.experience_level = ?2 and jp.job_category = ?3",nativeQuery = true)
    List<Map<String, Objects>> getJobsByExperienceAndCompanyAndCategory(int company_id,String experience_level,String category);
    @Query(value = "SELECT * from job_post jp,company c,job_type jt,job_location jl \n" +
            "where jp.company_id = c.company_id and jt.job_type_id = jp.job_type_id \n" +
            "and jl.job_location_id = jp.job_location_id and " +
            "jp.company_id = ?1 and jp.experience_level = ?2 and jp.job_category = ?3 " +
            "and jp.job_type_id = ?4",nativeQuery = true)
    List<Map<String, Objects>> getJobsByExperienceAndCompanyAndCategoryAndType(int company_id,String experience_level,String category,int type_id);

    @Query(value = "SELECT * from job_post jp,company c,job_type jt,job_location jl \n" +
            "where jp.company_id = c.company_id and jt.job_type_id = jp.job_type_id \n" +
            "and jl.job_location_id = jp.job_location_id and " +
            "jp.company_id = ?1 and jt.job_type = ?2",nativeQuery = true)
    List<Map<String, Objects>> getJobsByTypeNameAndCompany(int company_id,String type_name);
    @Query(value = "SELECT * from job_post jp,company c,job_type jt,job_location jl \n" +
            "where jp.company_id = c.company_id and jt.job_type_id = jp.job_type_id \n" +
            "and jl.job_location_id = jp.job_location_id and " +
            "jt.job_type = ?1",nativeQuery = true)
    List<Map<String, Objects>> getJobsByTypeName(String type_name);


}
