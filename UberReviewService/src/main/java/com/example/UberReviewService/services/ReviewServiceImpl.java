package com.example.UberReviewService.services;

import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService{

    private ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }


    @Override
    public Optional<Review> findReviewById(Long id){
        return reviewRepository.findById(id);

    }

    @Override
    public Review addReview(Review review) {
        if (reviewRepository.existsByBookingId(review.getBooking().getId())) {
            throw new IllegalStateException("Booking already has a review");
        }
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> findAllReview() {
        return reviewRepository.findAll();
    }

    @Override
    public boolean deleteReviewById(Long id) {
        try {
            reviewRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
