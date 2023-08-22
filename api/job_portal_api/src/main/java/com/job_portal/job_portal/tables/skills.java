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
public class skills {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int skill_id;
    private String skill_name;
    private int status;
}
