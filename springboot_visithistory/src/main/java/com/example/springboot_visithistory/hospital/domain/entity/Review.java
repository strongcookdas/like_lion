package com.example.springboot_visithistory.hospital.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    private String name;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    public Review(String title, String content, String name, Hospital hospital) {
        this.title = title;
        this.content = content;
        this.name = name;
        this.hospital = hospital;
    }
}
