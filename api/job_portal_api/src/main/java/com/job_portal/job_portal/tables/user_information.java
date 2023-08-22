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
public class user_information {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_information_id;

    private int user_id;

    private String first_name;

    private String middle_name;

    private String last_name;

    private String email;

    private String date_of_birth;

    private String gender;

    private String contact;

    private String registration_date;

    private String address;

    private String country_of_origin;

    private String specialization;
}
