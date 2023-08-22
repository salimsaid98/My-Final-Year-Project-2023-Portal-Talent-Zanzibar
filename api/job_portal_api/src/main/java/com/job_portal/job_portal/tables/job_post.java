package com.job_portal.job_portal.tables;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table
public class job_post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int job_post_id;
    private int job_type_id;
    private int job_location_id;
    private String job_tittle;
    private String job_category;
    private String salary_information;
    private String experience_level;
    @Column(length = 1000)
    private String key_responsibilities;
    @Column(length = 1000)
    private String minimum_requirement;
    private int company_id;
    private String posted_by;
    @Column(length = 1000)
    private String job_description;
    private int required_people;
    private String starting_date;
    private String end_date;
    private int status;
}
