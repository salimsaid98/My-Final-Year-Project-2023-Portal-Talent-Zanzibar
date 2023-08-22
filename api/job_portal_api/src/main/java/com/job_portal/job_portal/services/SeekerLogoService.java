package com.job_portal.job_portal.services;

import com.job_portal.job_portal.repositories.SeekerLogoRepository;
import com.job_portal.job_portal.tables.SeekerLogo;
import com.job_portal.job_portal.utility.ImageUtility;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
public class SeekerLogoService {

    @Autowired
    private final SeekerLogoRepository seekerLogoRepository;

    public SeekerLogo getSeekerLogo(Integer user_id){
        Optional<SeekerLogo> logo = seekerLogoRepository.getSeekerLogo(user_id);
        if(logo.isPresent()){
            SeekerLogo seekerLogo = new SeekerLogo();
            seekerLogo.setSeeker_logo_id(logo.get().getSeeker_logo_id());
            seekerLogo.setName(logo.get().getName());
            seekerLogo.setUser_id(logo.get().getUser_id());
            seekerLogo.setSeeker_logo(ImageUtility.decompressBytes(logo.get().getSeeker_logo()));
            return logo.get();
        }else {
            return new SeekerLogo();
        }
    }
}
