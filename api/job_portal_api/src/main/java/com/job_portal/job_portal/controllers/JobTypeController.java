package com.job_portal.job_portal.controllers;

import com.job_portal.job_portal.services.JobTypeService;
import com.job_portal.job_portal.specific.JobTypeDTO;
import com.job_portal.job_portal.tables.job_type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("job_portal/job_type")
public class JobTypeController {

    @Autowired
    private JobTypeService jobTypeService;

    @PostMapping("/postJob")
    private job_type saveJobType(@RequestBody JobTypeDTO dto){
        return jobTypeService.saveJobType(dto);
    }

    @PutMapping("/update_job_type/{id}")
    private Optional<job_type> update_job_type(@PathVariable("id") Integer id, @RequestBody JobTypeDTO dto){
        return jobTypeService.update_job_type(id,dto);
    }

    @GetMapping("/getAllJobType")
    private List<job_type> getAllJobType(){
        return jobTypeService.getAllJobType();
    }

    @GetMapping("/getJobTypeById/{id}")
    private job_type getJobTypeById(@PathVariable("id") Integer id){
        return jobTypeService.getJobTypeById(id);
    }
}
