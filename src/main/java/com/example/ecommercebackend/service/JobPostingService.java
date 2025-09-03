package com.example.ecommercebackend.service;

import com.example.ecommercebackend.model.JobPosting;
import com.example.ecommercebackend.repository.JobPostingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class JobPostingService {

    @Autowired
    private JobPostingRepository jobPostingRepository;

    // အလုပ်အသစ်တစ်ခုကို သိမ်းဆည်းခြင်း
    public JobPosting saveJobPosting(JobPosting jobPosting) {
        // အလုပ်အသစ်တင်တဲ့အခါ လက်ရှိရက်စွဲကို အလိုအလျောက်ထည့်သွင်းခြင်း
        if (jobPosting.getPostedDate() == null) {
            jobPosting.setPostedDate(LocalDate.now());
        }
        return jobPostingRepository.save(jobPosting);
    }

    // အလုပ်အကိုင်အားလုံးကို ရှာဖွေခြင်း
    public List<JobPosting> getAllJobPostings() {
        return jobPostingRepository.findAll();
    }

    // ID နဲ့ အလုပ်တစ်ခုကို ရှာဖွေခြင်း
    public Optional<JobPosting> getJobPostingById(Long id) {
        return jobPostingRepository.findById(id);
    }
}

