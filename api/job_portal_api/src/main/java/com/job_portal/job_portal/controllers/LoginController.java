package com.job_portal.job_portal.controllers;

import com.job_portal.job_portal.services.LoginServices;
import com.job_portal.job_portal.specific.loginDTO;
import com.job_portal.job_portal.tables.login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("job_portal/login")
public class LoginController {

    @Autowired
    private LoginServices loginServices;

    @GetMapping("/{username}/{password}")
    public login login_authentication(@PathVariable("username") String username, @PathVariable("password") String password){
        return loginServices.login_authentication(username,password);
    }

    @PostMapping("/registration")
    public ResponseEntity<login> SaveUser(@RequestBody loginDTO dto){
        login lgn = loginServices.saveUsers(dto);
        return new ResponseEntity<login>(lgn,new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/getAllUsers")
    public List<login> getAllUsers(){
        return loginServices.getAllUsers();
    }

    @PutMapping("/resetPassword/{user_id}")
    public Optional<login> resetPassword(@PathVariable("user_id") int user_id, @RequestBody loginDTO dto){
        return loginServices.resetPassword(user_id,dto);
    }

    }
