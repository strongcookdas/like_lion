package com.example.springboot_visithistory.hospital.repository;

import com.example.springboot_visithistory.hospital.domain.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital,Integer> {
}
