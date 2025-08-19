package com.example.UberReviewService.services;

import com.example.UberReviewService.models.Booking;
import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.repositories.BookingRepository;
import com.example.UberReviewService.repositories.ReviewRepository;
import com.fasterxml.jackson.annotation.OptBoolean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Date;
import java.util.Optional;

@Service
public class ReviewServices implements CommandLineRunner {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public void run(String... args) throws Exception{
        System.out.println(">>> RUN METHOD CALLED <<<");

        System.out.println("*******");

//        Review r = Review.builder()
//                .content("new ride at  " +   LocalTime.now())
//                .rating(9.41)
//        .build();
//
//        Booking b = Booking.builder()
//                .review(r)
//                .endTIme(new Date())
//        .build();
//
//        bookingRepository.save(b);


//        Optional<Booking> b = bookingRepository.findById(3L);
//        if (b.isPresent()){
//            bookingRepository.delete(b.get());
//        }

    }
}
