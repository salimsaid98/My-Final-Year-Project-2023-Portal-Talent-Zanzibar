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
public class seeker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int seeker_id;
    private int user_information_id;
}
