package com.job_portal.job_portal.specific;

import lombok.Data;

@Data
public class SeekerExperienceDTO {

    private int seeker_id;
    private String start_date;
    private String end_date;
    private String is_current_job;
    private String job_tittle;
    private String company_name;
    private String description;
    private String location;
    private String person_in_charge_name;
    private String person_in_charge_phone;
    private String person_in_charge_address;
}
