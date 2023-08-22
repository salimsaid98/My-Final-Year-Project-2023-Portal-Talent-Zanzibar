package com.job_portal.job_portal.tables;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table
@Entity
public class specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int specialization_id;
    private String specialization_name;
}
