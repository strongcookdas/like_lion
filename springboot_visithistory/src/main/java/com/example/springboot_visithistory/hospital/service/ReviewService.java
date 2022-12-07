package com.example.springboot_visithistory.hospital.service;

import com.example.springboot_visithistory.hospital.domain.dto.review.ReviewRequest;
import com.example.springboot_visithistory.hospital.domain.dto.review.ReviewResponse;
import com.example.springboot_visithistory.hospital.domain.entity.Hospital;
import com.example.springboot_visithistory.hospital.domain.entity.Review;
import com.example.springboot_visithistory.hospital.repository.HospitalRepository;
import com.example.springboot_visithistory.hospital.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final HospitalRepository hospitalRepository;

    public ReviewResponse saveReview(Integer id, ReviewRequest reivewRequest){
        Optional<Hospital> optionalHospital = hospitalRepository.findById(id);
        if(optionalHospital.isEmpty())
            return null;
        Review review = reivewRequest.toEntity(optionalHospital.get());
        review = reviewRepository.save(review);
        return ReviewResponse.of(review.getId(),review.getHospital().getId(),review.getTitle(),review.getContent(),review.getName());
    }

    public ReviewResponse getReviewPage(Integer id){
        Optional<Review> optionalReview = reviewRepository.findById(id);
        if(optionalReview.isEmpty())
            return null;
        Review review = optionalReview.get();
        return ReviewResponse.of(review.getId(),review.getHospital().getId(),review.getTitle(),review.getContent(),review.getName());
    }

    public List<ReviewResponse> getReviewsPage(Integer id){
        Optional<Hospital> optionalHospital = hospitalRepository.findById(id);
        if(optionalHospital.isEmpty())
            return null;
        List<Review> list = optionalHospital.get().getReviews();
        List<ReviewResponse> responses = new ArrayList<>();
        for (Review review: list) {
            ReviewResponse reviewResponse = ReviewResponse.of(review.getId(),review.getHospital().getId(),review.getTitle(),review.getContent(), review.getName());
            responses.add(reviewResponse);
        }
        return responses;
    }
}
