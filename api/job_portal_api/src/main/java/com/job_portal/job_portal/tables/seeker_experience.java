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
public class seeker_experience {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int experience_id;
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
