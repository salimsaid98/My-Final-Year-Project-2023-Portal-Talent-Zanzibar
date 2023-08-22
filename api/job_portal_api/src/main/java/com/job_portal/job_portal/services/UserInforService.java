package com.job_portal.job_portal.services;

import com.job_portal.job_portal.repositories.UserInfoRepository;
import com.job_portal.job_portal.specific.UserInformationDTO;
import com.job_portal.job_portal.tables.user_information;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserInforService {
    @Autowired
    public UserInfoRepository userInfoRepository;

    public List<user_information> getAllUsersInfo(){
        List<user_information> d = userInfoRepository.findAll();
        if(d.size() > 0){
            return d;
        }else{
            return new ArrayList<>();
        }
    }

    @Transactional
    public Optional<user_information> updateUserInformation(Integer id, UserInformationDTO userInformationDTO){
        return userInfoRepository.findById(id).map(target->{
           target.setAddress(userInformationDTO.getAddress());
           target.setUser_id(userInformationDTO.getUser_id());
           target.setContact(userInformationDTO.getContact());
           target.setEmail(userInformationDTO.getEmail());
           target.setContact(userInformationDTO.getContact());
           target.setCountry_of_origin(userInformationDTO.getCountry_of_origin());
           target.setDate_of_birth(userInformationDTO.getDate_of_birth());
           target.setFirst_name(userInformationDTO.getFirst_name());
           target.setMiddle_name(userInformationDTO.getMiddle_name());
           target.setLast_name(userInformationDTO.getLast_name());
           target.setGender(userInformationDTO.getGender());
           target.setSpecialization(userInformationDTO.getSpecialization());
           return target;
        });
    }

    public user_information SaveUserInformation(UserInformationDTO userInformationDTO){
        user_information user = new user_information();
        user.setUser_id(userInformationDTO.getUser_id());
        user.setFirst_name(userInformationDTO.getFirst_name()); user.setMiddle_name(userInformationDTO.getMiddle_name());
        user.setLast_name(userInformationDTO.getLast_name()); user.setEmail(userInformationDTO.getEmail());
        user.setDate_of_birth(userInformationDTO.getDate_of_birth());
        user.setGender(userInformationDTO.getGender()); user.setContact(userInformationDTO.getContact());
        user.setRegistration_date(userInformationDTO.getRegistration_date());
        user.setAddress(userInformationDTO.getAddress()); user.setCountry_of_origin(userInformationDTO.getCountry_of_origin());
        user.setSpecialization(userInformationDTO.getSpecialization());

        if(userInfoRepository.exists(Example.of(user))){
            throw new ResponseStatusException(HttpStatus.FOUND,"User already exist");
        }else{
            return userInfoRepository.save(user);
        }
    }
    public user_information getUserInformationUsingUserID(Integer user_id){
        Optional<user_information> u = userInfoRepository.getUserInformationUsingUserID(user_id);
        return u.orElse(new user_information());
    }


}
