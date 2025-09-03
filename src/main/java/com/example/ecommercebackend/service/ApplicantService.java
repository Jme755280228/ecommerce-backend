package com.example.ecommercebackend.service;

import com.example.ecommercebackend.model.Applicant;
import com.example.ecommercebackend.repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicantService {

    @Autowired
    private ApplicantRepository applicantRepository;

    // အလုပ်လျှောက်လွှာအသစ်ကို သိမ်းဆည်းခြင်း
    public Applicant saveApplicant(Applicant applicant) {
        return applicantRepository.save(applicant);
    }

    // လျှောက်ထားသူအားလုံးကို ကြည့်ရှုခြင်း (Admin အတွက်)
    public List<Applicant> getAllApplicants() {
        return applicantRepository.findAll();
    }

    // ID နဲ့ လျှောက်ထားသူကို ရှာဖွေခြင်း
    public Optional<Applicant> getApplicantById(Long id) {
        return applicantRepository.findById(id);
    }
}

