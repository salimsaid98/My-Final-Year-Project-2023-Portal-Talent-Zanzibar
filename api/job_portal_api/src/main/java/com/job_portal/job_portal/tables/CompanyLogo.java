package com.job_portal.job_portal.tables;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table
public class CompanyLogo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int logo_id;
    private int company_id;
    private String image_type;
    private String name;
    @Column(columnDefinition = "LONGBLOB")
    @Lob
    private byte[] company_logos;

}
