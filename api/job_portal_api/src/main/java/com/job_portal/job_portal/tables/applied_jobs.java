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

public class applied_jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int apply_id;
    private int job_post_id;
    private int seeker_id;
    private String applied_date;
    private int status;
    @Column(nullable = true)
    private String confirmed_date;
}
