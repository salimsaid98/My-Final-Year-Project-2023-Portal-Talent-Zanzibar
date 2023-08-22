package com.job_portal.job_portal.controllers;

import com.job_portal.job_portal.repositories.SeekerLogoRepository;
import com.job_portal.job_portal.services.SeekerLogoService;
import com.job_portal.job_portal.tables.SeekerLogo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import java.util.Optional;

@RestController
@RequestMapping("job_portal/seeker_logo")
@CrossOrigin
@Data
public class SeekerLogoController {

    @Autowired
    private final SeekerLogoService seekerLogoService;
    private final SeekerLogoRepository seekerLogoRepository;

    @PostMapping(value = "/upload_seeker_logo/{user_id}", consumes = "multipart/form-data")
    @Transactional
    public ResponseEntity.BodyBuilder uploadPicture(@RequestParam("imageFile") MultipartFile file, @PathVariable("user_id") Integer user_id) throws IOException {
        SeekerLogo picture = new SeekerLogo();
        picture.setUser_id(user_id);
        picture.setName(file.getOriginalFilename());
        picture.setSeeker_logo(file.getBytes());
        picture.setImage_type(file.getContentType());
        seekerLogoRepository.save(picture);
        return ResponseEntity.status(HttpStatus.OK);
    }

    @GetMapping("/get_seeker_image/info/{user_id}")
    public SeekerLogo getSeekerLogo(@PathVariable("user_id") Integer user_id){
        Optional<SeekerLogo> logo = seekerLogoRepository.getSeekerLogo(user_id);
        if(logo.isPresent()){
            SeekerLogo seekerLogo = new SeekerLogo();
            seekerLogo.setSeeker_logo_id(logo.get().getSeeker_logo_id());
            seekerLogo.setName(logo.get().getName());
            seekerLogo.setUser_id(logo.get().getUser_id());
            seekerLogo.setSeeker_logo(logo.get().getSeeker_logo());
            return logo.get();
        }else {
            return new SeekerLogo();
        }
    }
//    public ResponseEntity getSeekerLogo(@PathVariable("user_id") Integer user_id){
//        return ResponseEntity.ok(seekerLogoService.getSeekerLogo(user_id));
//    }

            // public Set<SeekerLogo> uploadFile(MultipartFile[] multipartFiles) throws IOException {
            //     Set<SeekerLogo> image_models = new HashSet<>();

            //     for (MultipartFile file : multipartFiles) {
            //         SeekerLogo image_model = new SeekerLogo(
            //                 file.getOriginalFilename(),
            //                 file.getContentType(),
            //                 file.getBytes()
            //         );
            //         image_models.add(image_model);
            //     }
            //     return image_models;
            // }

            // public List<SeekerLogo> create(MultipartFile[] file) throws IOException {

            //     Set<SeekerLogo> images = uploadFile(file);
             
            //     List<SeekerLogo> savImages =  seekerLogoRepository.saveAll(images);
                 
                  
            //       return savImages;
            //   }

}
