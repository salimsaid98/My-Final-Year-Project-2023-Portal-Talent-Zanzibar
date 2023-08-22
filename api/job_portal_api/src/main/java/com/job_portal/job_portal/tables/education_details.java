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
public class education_details {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int education_id;
    private int user_id;
    private int seeker_id;
    private String certificate_level_name;
    private String institute_name;
    private String starting_date;
    private String country;
    private String end_date;
    private String gpa;
    private String academic_year;
    private String faculty;
}
