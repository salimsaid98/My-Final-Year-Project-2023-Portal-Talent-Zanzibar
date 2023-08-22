package com.job_portal.job_portal.controllers;

import com.job_portal.job_portal.repositories.CompanyImageRepository;
import com.job_portal.job_portal.services.CompanyImageService;
import com.job_portal.job_portal.tables.CompanyLogo;
import com.job_portal.job_portal.utility.ImageUtility;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("job_portal/company_logo")
@CrossOrigin
@Data
public class CompanyLogoController {
    @Autowired
    private final CompanyImageRepository companyImageRepository;
    private final CompanyImageService companyImageService;

    @PostMapping(value = "/upload_logo/{company_id}", consumes = "multipart/form-data")
    @Transactional
    public ResponseEntity.BodyBuilder uploadPicture(@RequestParam("imageFile") MultipartFile file, @PathVariable("company_id") Integer company_id) throws IOException {
            CompanyLogo picture = new CompanyLogo();
            picture.setCompany_id(company_id);
            picture.setName(file.getOriginalFilename());
            picture.setCompany_logos(file.getBytes());
            picture.setImage_type(file.getContentType());
            companyImageRepository.save(picture);
            return ResponseEntity.status(HttpStatus.OK);
    }
    @GetMapping("/get_image/info/{company_id}")
    public ResponseEntity getCompanyLogoImage(@PathVariable("company_id") Integer company_id){
        return ResponseEntity.ok(companyImageService.getCompanyLogoImage(company_id));
    }
}
