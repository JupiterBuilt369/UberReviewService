package com.example.UberReviewService.models;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Builder

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "booking_review")
@Inheritance(strategy = InheritanceType.JOINED)
public class Review extends BaseModel{

   @Column(nullable = false)
    String content;

    Double rating;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Booking booking;

}
