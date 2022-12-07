package com.example.springboot_visithistory.hospital.controller;

import com.example.springboot_visithistory.hospital.domain.dto.hospital.HospitalResponse;
import com.example.springboot_visithistory.hospital.domain.dto.review.ReviewRequest;
import com.example.springboot_visithistory.hospital.domain.dto.review.ReviewResponse;
import com.example.springboot_visithistory.hospital.domain.entity.Hospital;
import com.example.springboot_visithistory.hospital.service.HospitalService;
import com.example.springboot_visithistory.hospital.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hospital")
@RequiredArgsConstructor
public class HospitalRestController {

    private final HospitalService hospitalService;
    private final ReviewService reviewService;

    @GetMapping("")
    public ResponseEntity<Page<Hospital>> hospitalListPage(Pageable pageable){
        return ResponseEntity.ok().body(hospitalService.getHospitalList(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HospitalResponse> hospitalPage(@PathVariable Integer id){
        return ResponseEntity.ok().body(hospitalService.getHospitalPage(id));
    }

    @GetMapping("/{id}/review")
    public ResponseEntity<List<ReviewResponse>> hospitalReviewsPage(@PathVariable Integer id){
        return ResponseEntity.ok().body(reviewService.getReviewsPage(id));
    }

    @PostMapping("/{id}/review")
    public ResponseEntity<ReviewResponse> reviewPage(@PathVariable Integer id, @RequestBody ReviewRequest reviewRequest){
        return ResponseEntity.ok().body(reviewService.saveReview(id,reviewRequest));
    }
}
