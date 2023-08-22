package com.job_portal.job_portal.services;

import com.job_portal.job_portal.repositories.CompanyRepository;
import com.job_portal.job_portal.specific.CompanyDTO;
import com.job_portal.job_portal.tables.company;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyServices {

    @Autowired
    public CompanyRepository companyRepository;

    public company SaveCompany(CompanyDTO dto){
        company c = new company();
        c.setUser_id(dto.getUser_id());
        c.setCompany_name(dto.getCompany_name()); c.setCompany_owner(dto.getCompany_owner());
        c.setCompany_mailing_address(dto.getCompany_mailing_address());
        c.setCity(dto.getCity()); c.setState(dto.getState());
        c.setZip_code(dto.getZip_code()); c.setCompany_description(dto.getCompany_description());
        c.setCompany_website(dto.getCompany_website());
        c.setEmail_address(dto.getEmail_address());
        c.setPhone_number(dto.getPhone_number());
        c.setEstablishment_date(dto.getEstablishment_date());
        c.setCountry_of_origin(dto.getCountry_of_origin());
        return companyRepository.save(c);
    }

    @Transactional
    public Optional<company> editCompany(int id,CompanyDTO dto){
        return companyRepository.findById(id).map(c->{
            c.setUser_id(dto.getUser_id());
            c.setCompany_name(dto.getCompany_name()); c.setCompany_owner(dto.getCompany_owner());
            c.setCompany_mailing_address(dto.getCompany_mailing_address());
            c.setCity(dto.getCity()); c.setState(dto.getState());
            c.setZip_code(dto.getZip_code()); c.setCompany_description(dto.getCompany_description());
            c.setCompany_website(dto.getCompany_website());
            c.setEmail_address(dto.getEmail_address());
            c.setPhone_number(dto.getPhone_number());
            c.setEstablishment_date(dto.getEstablishment_date());
            c.setCountry_of_origin(dto.getCountry_of_origin());
            return c;
        });
    }
    public List<company> getAllCompanies(){
        List<company> c = companyRepository.findAll();
        if(c.size() > 0){
            return c;
        }else{
            return new ArrayList<>();
        }
    }

    public company getCompanyInformation(Integer id){
        Optional<company> c = companyRepository.findById(id);
        if(c.isPresent()){
            return c.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Company does not exist");
        }
    }
    public company getCompanyInformationUsingUserId(Integer user_id){
        Optional<company> c = companyRepository.getCompanyInformationUsingUserId(user_id);
        if(c.isPresent()){
            return c.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Company does not exist");
        }
    }

}
