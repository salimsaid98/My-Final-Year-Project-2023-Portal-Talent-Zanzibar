package com.job_portal.job_portal.controllers;


import com.job_portal.job_portal.services.EducationDetailsServices;
import com.job_portal.job_portal.specific.EducationDetailsDTO;
import com.job_portal.job_portal.tables.education_details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("job_portal/education_details")
public class EducationDetailsController {

    @Autowired
    private EducationDetailsServices educationDetailsServices;

    @PostMapping("/saveEducationDetails")
    private education_details saveEducationDetails(@RequestBody EducationDetailsDTO dto){
        return educationDetailsServices.SaveEducationDetails(dto);
    }

    @PutMapping("/updateEducationDetails/{id}")
    private Optional<education_details> updateEducationDetails(@PathVariable("id") Integer id,@RequestBody EducationDetailsDTO dto){
        return educationDetailsServices.updateEducationDetails(id, dto);
    }

    @GetMapping("/getEducationDetailsById/{id}")
    private education_details getEducationDetailsById(@PathVariable("id") Integer id){
        return educationDetailsServices.getEducationDetailsById(id);
    }

    @GetMapping("/getAllEducationDetails")
    private List<education_details> getAllEducationDetails(){
        return educationDetailsServices.list_of_education_details();
    }

    @GetMapping("/list_of_education_details_for_this_user/{user_id}")
    private List<education_details> list_of_education_details_for_this_user(@PathVariable("user_id") Integer user_id){
        return educationDetailsServices.list_of_education_details_for_this_user(user_id);
    }
}
