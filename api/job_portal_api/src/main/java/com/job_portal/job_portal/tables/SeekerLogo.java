package com.job_portal.job_portal.tables;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class SeekerLogo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int seeker_logo_id;
    private int user_id;
    private String name;
    private String image_type;
    @Column(columnDefinition = "LONGBLOB")
    @Lob
    private byte[] seeker_logo;
    
    public SeekerLogo( String name,String image_type, byte[] seeker_logo) {
        this.name = name;
        this.image_type = image_type;
        this.seeker_logo = seeker_logo;
    }

    public SeekerLogo() {
    }


    
}
