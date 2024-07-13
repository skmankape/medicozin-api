package com.medicozin.medicozin_api.service;

import com.medicozin.medicozin_api.entity.CompanyEntity;
import com.medicozin.medicozin_api.entity.StudentEntity;
import com.medicozin.medicozin_api.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CompanyService implements UserDetailsService {

    @Autowired
    private CompanyRepository companyRepository;


    public CompanyEntity findByEmail(String email) {
        return companyRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
    }
    public void saveCompany(CompanyEntity company) {
        companyRepository.save(company);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return (UserDetails) companyRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
    }


}
