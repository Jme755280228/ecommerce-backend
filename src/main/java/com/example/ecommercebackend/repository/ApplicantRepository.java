package com.example.ecommercebackend.repository;

import com.example.ecommercebackend.model.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
    // Spring Data JPA provides basic CRUD methods automatically
}

