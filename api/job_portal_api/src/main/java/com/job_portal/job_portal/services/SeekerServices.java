package com.job_portal.job_portal.services;


import com.job_portal.job_portal.repositories.SeekerRepository;
import com.job_portal.job_portal.specific.SeekerDTO;
import com.job_portal.job_portal.tables.seeker;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.Option;
import java.util.*;

@Service
public class SeekerServices {

    @Autowired
    public SeekerRepository seekerRepository;

    public seeker saveSeeker(SeekerDTO dto){
        seeker s = new seeker();
        s.setUser_information_id(dto.getUser_information_id());
        return seekerRepository.save(s);
    }

    public List<seeker> List_of_Seekers(){
        List<seeker> s = seekerRepository.findAll();
        if(s.size() > 0){
            return s;
        }else{
            return new ArrayList<>();
        }
    }

    @Transactional
    public Optional<seeker> updateSeeker(Integer id,SeekerDTO dto){
        return seekerRepository.findById(id).map(s->{
            s.setUser_information_id(dto.getUser_information_id());
            return s;
        });
    }

    public seeker getSeekerById(Integer id){
        Optional<seeker> s = seekerRepository.findById(id);
        if(s.isPresent()){
            return s.get();
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Seeker was not found");
        }
    }
    public List<Map<String, Objects>> getSeekerAllInformation(Integer id){
        List<Map<String, Objects>> s = seekerRepository.getSeekerAllInformation(id);
        if(s.size() > 0){
            return s;
        }else{
            return new ArrayList<>();
        }
    }

    public seeker getSeekerByInformationID(int user_information_id){
        Optional<seeker> op = seekerRepository.getSeekerByInformationID(user_information_id);
        if(op.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Not found");
        }else{
            return op.get();
        }
    }
}
