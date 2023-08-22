package com.job_portal.job_portal.tables;


import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
@Table(name="login")
public class login {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;
    private String username;
    private String password;
    private String role;
    private  String status;

}
