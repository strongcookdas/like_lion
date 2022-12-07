package com.example.springboot_visithistory.hospital.domain.dto.review;

import com.example.springboot_visithistory.hospital.domain.entity.Hospital;
import com.example.springboot_visithistory.hospital.domain.entity.Review;
import lombok.Getter;

@Getter
public class ReviewRequest {
    private String title;
    private String content;
    private String name;

    public Review toEntity(Hospital hospital){
        return new Review(this.title,this.content,this.name,hospital);
    }
}
