package com.job_portal.job_portal.controllers;

import com.job_portal.job_portal.services.JobLocationService;
import com.job_portal.job_portal.specific.JobLocationDTO;
import com.job_portal.job_portal.tables.job_location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("job_portal/job_location")
public class JobLocationController {

    @Autowired
    private JobLocationService jobLocationService;

    @PostMapping("/save_job_location")
    private job_location save_job_location(@RequestBody JobLocationDTO dto){
        return jobLocationService.saveJob_location(dto);
    }

    @PutMapping("/update_job_location/{id}")
    private Optional<job_location> update_job_location(@PathVariable("id") Integer id,@RequestBody JobLocationDTO dto){
        return jobLocationService.update_job_location(id,dto);
    }

    @GetMapping("/getAllJobLocation")
    private List<job_location> getAllJobLocation(){
        return jobLocationService.getAllJobLocation();
    }

    @GetMapping("/getJobLocationById/{id}")
    private job_location getJoblocationById(@PathVariable("id") Integer id){
        return jobLocationService.getJobLocationById(id);
    }

}
