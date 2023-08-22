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
public class seeker_skills {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int seeker_skill_id;
    private int seeker_id;
    private String skill_name;
}
