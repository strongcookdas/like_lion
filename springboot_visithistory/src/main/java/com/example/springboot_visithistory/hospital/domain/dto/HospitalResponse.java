package com.example.springboot_visithistory.hospital.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class HospitalResponse {
    private Integer id;
    private String hospitalName;
    private String roadNameAddress;
    private List<ReviewResponse> reviews;
    public static HospitalResponse of(Integer id, String hospitalName, String roadNameAddress, List<ReviewResponse> reviews){
        return new HospitalResponse(id,hospitalName,roadNameAddress,reviews);
    }

}
