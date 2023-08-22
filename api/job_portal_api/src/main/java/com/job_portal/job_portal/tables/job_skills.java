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
public class job_skills {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int job_post_skills_id;
    private int job_post_id;
    private int skill_id;
}
