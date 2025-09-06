package com.example.UberReviewService.services;

import com.example.UberReviewService.dtos.Review.CreateReviewDto;
import com.example.UberReviewService.dtos.Review.ReviewDto;
import com.example.UberReviewService.dtos.Review.UpdateReviewDto;

import java.util.List;


public interface ReviewService {

    ReviewDto findReviewById(Long id);

    ReviewDto addReview(CreateReviewDto review);

    List<ReviewDto> findAllReviews();

    boolean deleteReviewById(Long id);

    ReviewDto updateReviewById(Long id, UpdateReviewDto review);
}
