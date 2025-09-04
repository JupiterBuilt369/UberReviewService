package com.example.UberReviewService.adapter;

import com.example.UberReviewService.dtos.CreateReviewDto;
import com.example.UberReviewService.models.Review;

public interface CreateReviewDtoToReviewAdapter {

    public Review ConvertDto(CreateReviewDto createReviewDto);
}
