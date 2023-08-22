package com.job_portal.job_portal.tables;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class SeekerLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int language_id;
    private int seeker_id;
    private String language;
}
