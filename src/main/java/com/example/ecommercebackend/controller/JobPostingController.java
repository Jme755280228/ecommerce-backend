package com.example.ecommercebackend.controller;

import com.example.ecommercebackend.model.JobPosting;
import com.example.ecommercebackend.service.JobPostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jobs")
public class JobPostingController {

    @Autowired
    private JobPostingService jobPostingService;

    // အလုပ်အသစ်တစ်ခု တင်ရန် (POST request)
    @PostMapping
    public JobPosting createJobPosting(@RequestBody JobPosting jobPosting) {
        return jobPostingService.saveJobPosting(jobPosting);
    }

    // အလုပ်အကိုင်အားလုံးကို ရယူရန် (GET request)
    @GetMapping
    public List<JobPosting> getAllJobPostings() {
        return jobPostingService.getAllJobPostings();
    }

    // ID နဲ့ အလုပ်တစ်ခုကို ရယူရန် (GET request)
    @GetMapping("/{id}")
    public ResponseEntity<JobPosting> getJobPostingById(@PathVariable Long id) {
        Optional<JobPosting> jobPosting = jobPostingService.getJobPostingById(id);
        return jobPosting.map(ResponseEntity::ok)
                         .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

