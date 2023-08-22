package com.job_portal.job_portal.controllers;

import com.job_portal.job_portal.services.LanguageService;
import com.job_portal.job_portal.specific.LanguageDTO;
import com.job_portal.job_portal.tables.SeekerLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("job_portal/seeker_language")
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @PostMapping("/saveSeekerLanguage")
    private SeekerLanguage saveSeekerLanguage(@RequestBody LanguageDTO dto){
        return languageService.saveSeekerLanguage(dto);
    }

    @PutMapping("/updateSeekerLanguage/{id}")
    private Optional<SeekerLanguage> updateSeekerLanguage(@PathVariable("id") Integer id,@RequestBody LanguageDTO dto){
        return languageService.updateSeekerLanguage(id,dto);
    }

        @GetMapping("/getAllSeekerLanguages/{seeker_id}")
    private List<SeekerLanguage> getAllSeekerLanguages(@PathVariable("seeker_id") Integer seeker_id){
        return languageService.getAllSeekerLanguages(seeker_id);
    }
}
