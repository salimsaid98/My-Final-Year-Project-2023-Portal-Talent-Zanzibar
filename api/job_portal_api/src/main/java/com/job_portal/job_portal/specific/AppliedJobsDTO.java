package com.job_portal.job_portal.specific;

import lombok.Data;

@Data
public class AppliedJobsDTO {
    private int job_post_id;
    private int seeker_id;
    private String applied_date;
    private int status;
    private String confirmed_date;

}
