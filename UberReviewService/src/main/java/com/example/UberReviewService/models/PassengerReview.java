package com.example.UberReviewService.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "passenger_review")
public class PassengerReview extends Review{

    @Column(nullable = false)
    private String passengerReviewContent;

    @Column(nullable = false)
    private String  passenger_rating;

}
