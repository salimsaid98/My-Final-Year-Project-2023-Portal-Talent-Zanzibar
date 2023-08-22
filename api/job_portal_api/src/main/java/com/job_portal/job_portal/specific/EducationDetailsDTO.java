package com.job_portal.job_portal.specific;

import lombok.Data;

@Data
public class EducationDetailsDTO {
    private int user_id;
    private int seeker_id;
    private String certificate_level_name;
    private String institute_name;
    private String starting_date;
    private String end_date;
    private String country;
    private String gpa;
    private String academic_year;
    private String faculty;
}
