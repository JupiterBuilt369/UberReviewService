package com.example.UberReviewService.services;

import com.example.UberReviewService.models.Review;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ReviewService {

    public Optional<Review> findReviewById(Long id);

    public Review addReview(Review review);

    public List<Review> findAllReview();

    public boolean deleteReviewById(Long id);


}
