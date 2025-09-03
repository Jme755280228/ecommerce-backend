package com.example.ecommercebackend.repository;

import com.example.ecommercebackend.model.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {
    // Spring Data JPA provides basic CRUD methods automatically
}

