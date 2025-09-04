package com.example.UberReviewService.adapter;

import com.example.UberReviewService.dtos.CreateReviewDto;
import com.example.UberReviewService.models.Booking;
import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.repositories.BookingRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CreateReviewDtoToReviewAdapterImpl implements CreateReviewDtoToReviewAdapter {

    private final BookingRepository bookingRepository;

    public CreateReviewDtoToReviewAdapterImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }
    @Override
    public Review ConvertDto(CreateReviewDto createReviewDto) {
        Optional<Booking>  booking = bookingRepository.findById(createReviewDto.getBookingId());
        return booking.map(value -> Review.builder()
                .rating(createReviewDto.getRating())
                .content(createReviewDto.getContent())
                .booking(value)
                .build()).orElse(null);
    }
}
