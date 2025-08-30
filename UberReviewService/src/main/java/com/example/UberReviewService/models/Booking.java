package com.example.UberReviewService.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@ToString(exclude = {"driver", "passenger", "review"})
@NoArgsConstructor
@AllArgsConstructor
public class Booking extends BaseModel{

    @ManyToOne
    private Driver driver;

    @ManyToOne
    private Passenger passenger;

    @Enumerated(value = EnumType.STRING)
    private BookingStatus bookingStatus;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endTIme;

    private Long totalDistance;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},fetch = FetchType.LAZY)
    private Review review;

}
