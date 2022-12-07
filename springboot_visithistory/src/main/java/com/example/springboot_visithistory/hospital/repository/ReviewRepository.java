package com.example.springboot_visithistory.hospital.repository;

import com.example.springboot_visithistory.hospital.domain.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Integer> {
}
