package com.job_portal.job_portal.specific;


import lombok.Data;

@Data
public class UserInformationDTO {
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
