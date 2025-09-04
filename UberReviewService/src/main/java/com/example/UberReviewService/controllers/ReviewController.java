package com.example.UberReviewService.controllers;

import com.example.UberReviewService.adapter.CreateReviewDtoToReviewAdapter;
import com.example.UberReviewService.dtos.CreateReviewDto;
import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    public ReviewService reviewService;
    public CreateReviewDtoToReviewAdapter createReviewDtoToReviewAdapter;

    public ReviewController(ReviewService reviewService, CreateReviewDtoToReviewAdapter createReviewDtoToReviewAdapter) {
        this.reviewService = reviewService;
        this.createReviewDtoToReviewAdapter = createReviewDtoToReviewAdapter;
    }

    @PostMapping
    public ResponseEntity<?> createReview(@Validated @RequestBody CreateReviewDto reviewRequest  ) {

        Review incomingReview = this.createReviewDtoToReviewAdapter.ConvertDto(reviewRequest);
        if (incomingReview == null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Invalid arguments passed");
        }

        Review review = this.reviewService.addReview(incomingReview);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(review);
    }
}
