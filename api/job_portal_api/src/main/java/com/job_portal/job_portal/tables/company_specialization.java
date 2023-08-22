package com.job_portal.job_portal.tables;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table
@Entity
public class company_specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int company_specialization_id;
    private int company_id;
    private int specialization_id;
}
