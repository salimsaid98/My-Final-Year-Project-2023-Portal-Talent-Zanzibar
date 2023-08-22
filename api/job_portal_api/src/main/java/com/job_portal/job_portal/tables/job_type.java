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
public class job_type {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int job_type_id;
    private String job_type;
}
