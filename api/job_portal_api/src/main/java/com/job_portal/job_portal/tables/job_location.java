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
public class job_location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int job_location_id;
    private String street;
    private String city;
    private String state;
    private String country;
}
