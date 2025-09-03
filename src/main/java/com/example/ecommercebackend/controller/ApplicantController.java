package com.example.ecommercebackend.controller;

import com.example.ecommercebackend.model.Applicant;
import com.example.ecommercebackend.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/applicants")
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    // အလုပ်လျှောက်လွှာ တင်ရန် (POST request)
    @PostMapping
    public Applicant submitApplicant(@RequestBody Applicant applicant) {
        return applicantService.saveApplicant(applicant);
    }

    // လျှောက်ထားသူအားလုံးကို ရယူရန် (Admin အတွက်)
    @GetMapping
    public List<Applicant> getAllApplicants() {
        return applicantService.getAllApplicants();
    }

    // ID နဲ့ လျှောက်ထားသူကို ရယူရန်
    @GetMapping("/{id}")
    public ResponseEntity<Applicant> getApplicantById(@PathVariable Long id) {
        Optional<Applicant> applicant = applicantService.getApplicantById(id);
        return applicant.map(ResponseEntity::ok)
                        .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

