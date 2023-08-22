package com.job_portal.job_portal.tables;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int report_id;
}
