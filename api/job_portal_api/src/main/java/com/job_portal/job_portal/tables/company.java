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
public class company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int company_id;
    private int user_id;
    private String company_name;
    private String company_owner;
    private String company_mailing_address;
    private String city;
    private String state;
    private String zip_code;
    @Column(length = 10000)
    private String company_description;
    private String company_website;
    private String email_address;
    private String phone_number;
    private String establishment_date;
    private String country_of_origin;
}
