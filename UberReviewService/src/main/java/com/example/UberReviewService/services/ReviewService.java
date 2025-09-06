package com.example.UberReviewService.services;

import com.example.UberReviewService.dtos.CreateReviewDto;
import com.example.UberReviewService.dtos.ReviewDto;
import com.example.UberReviewService.models.Review;

import java.util.List;
import java.util.Optional;


public interface ReviewService {

    public Optional<Review> findReviewById(Long id);

    public ReviewDto addReview(CreateReviewDto review);

    public List<Review> findAllReview();

    public boolean deleteReviewById(Long id);


}
