package com.example.springboot_visithistory.hospital.service;

import com.example.springboot_visithistory.hospital.domain.dto.hospital.HospitalResponse;
import com.example.springboot_visithistory.hospital.domain.dto.review.ReviewResponse;
import com.example.springboot_visithistory.hospital.domain.entity.Hospital;
import com.example.springboot_visithistory.hospital.domain.entity.Review;
import com.example.springboot_visithistory.hospital.repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HospitalService {

    private final HospitalRepository hospitalRepository;

    public Page<Hospital> getHospitalList(Pageable pageable){
        Page<Hospital> lists = hospitalRepository.findAll(pageable);
        return lists;
    }

    public HospitalResponse getHospitalPage(Integer id){
        Optional<Hospital> optionalHospital = hospitalRepository.findById(id);
        HospitalResponse hospitalResponse = null;
        if(!optionalHospital.isEmpty()){
            Hospital hospital = optionalHospital.get();
            List<Review> list = hospital.getReviews();
            List<ReviewResponse> reviews = new ArrayList<>();
            for (Review review : list) {
                ReviewResponse reviewResponse = ReviewResponse.of(review.getId(),review.getHospital().getId(),review.getTitle(),review.getContent(),review.getName());
                reviews.add(reviewResponse);
            }
            hospitalResponse = HospitalResponse.of(hospital.getId(),hospital.getHospitalName(),hospital.getRoadNameAddress(),reviews);
        }
        return hospitalResponse;
    }
}
