package com.job_portal.job_portal.services;

import com.job_portal.job_portal.repositories.LanguageRepository;
import com.job_portal.job_portal.specific.LanguageDTO;
import com.job_portal.job_portal.tables.SeekerLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LanguageService {

    @Autowired
    private LanguageRepository languageRepository;


    public SeekerLanguage saveSeekerLanguage(LanguageDTO dto){
        SeekerLanguage s = new SeekerLanguage();
        s.setSeeker_id(dto.getSeeker_id());
        s.setLanguage(dto.getLanguage());
        return languageRepository.save(s);
    }

    public Optional<SeekerLanguage> updateSeekerLanguage(Integer id,LanguageDTO dto){
        return languageRepository.findById(id).map(s->{
            s.setSeeker_id(dto.getSeeker_id());
            s.setLanguage(dto.getLanguage());
            return s;
        });
    }

    public List<SeekerLanguage> getAllSeekerLanguages(Integer seeker_id){
        List<SeekerLanguage> s = languageRepository.getAllSeekerLanguages(seeker_id);
        if(s.size() > 0){
            return s;
        }else{
            return new ArrayList<>();
        }
    }
}
