package com.job_portal.job_portal.specific;

import lombok.Data;

@Data
public class JobPostDTO {

    private int job_type_id;
    private int job_location_id;
    private int company_id;
    private String job_tittle;
    private String job_category;
    private String salary_information;
    private String experience_level;
    private String key_responsibilities;
    private String minimum_requirement;
    private String posted_by;
    private int required_people;
    private String job_description;
    private String starting_date;
    private String end_date;
    private int status;
}
