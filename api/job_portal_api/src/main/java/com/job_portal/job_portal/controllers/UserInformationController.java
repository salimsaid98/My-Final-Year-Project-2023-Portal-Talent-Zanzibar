package com.job_portal.job_portal.controllers;

import com.job_portal.job_portal.services.UserInforService;
import com.job_portal.job_portal.specific.UserInformationDTO;
import com.job_portal.job_portal.tables.user_information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("job_portal/user_information")
public class UserInformationController {

    @Autowired
    private UserInforService userInforService;

    @GetMapping("/getAllUsersInformation")
    private List<user_information> getAllUsersInformation(){
        return userInforService.getAllUsersInfo();
    }

    @GetMapping("/getSpecificUserInformation/{user_ID}")
    private user_information getUserInformation(@PathVariable("user_ID") Integer user_ID){
        return userInforService.getUserInformationUsingUserID(user_ID);
    }

    @PutMapping("/updateUserInformation/{user_information_id}")
    public Optional<user_information> update_user_information(@PathVariable("user_information_id") Integer user_information_id,@RequestBody UserInformationDTO dto){
        return userInforService.updateUserInformation(user_information_id,dto);
    }

    @PostMapping("/put_user_information")
    private user_information SaveUserInformation(@RequestBody UserInformationDTO dto){
        return userInforService.SaveUserInformation(dto);
    }
}
