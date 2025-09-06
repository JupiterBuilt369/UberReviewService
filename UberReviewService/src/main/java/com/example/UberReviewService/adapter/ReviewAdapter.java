package com.example.UberReviewService.adapter;

import com.example.UberReviewService.dtos.Review.CreateReviewDto;
import com.example.UberReviewService.dtos.Review.ReviewDto;
import com.example.UberReviewService.models.Review;

public interface ReviewAdapter {

    Review ReviewDtoToEntity(CreateReviewDto createReviewDto);
    ReviewDto EntityToReviewDto(Review review);

}
