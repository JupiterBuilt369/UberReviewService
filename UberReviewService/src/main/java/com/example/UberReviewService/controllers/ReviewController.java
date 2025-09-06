package com.example.UberReviewService.controllers;

import com.example.UberReviewService.adapter.ReviewAdapter;
import com.example.UberReviewService.dtos.CreateReviewDto;
import com.example.UberReviewService.dtos.ReviewDto;
import com.example.UberReviewService.services.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    public ReviewService reviewService;
    public ReviewAdapter reviewAdapter;

    public ReviewController(ReviewService reviewService, ReviewAdapter reviewAdapter) {
        this.reviewService = reviewService;
        this.reviewAdapter = reviewAdapter;
    }

    @PostMapping
    public ResponseEntity<?> createReview(@Validated @RequestBody CreateReviewDto reviewRequest  ) {

        ReviewDto savedReviewDto = reviewService.addReview(reviewRequest);

        if (savedReviewDto == null) {
            return ResponseEntity.badRequest().body("Invalid arguments passed");
        }

        return ResponseEntity.ok().body(savedReviewDto);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getReviewById(@PathVariable Long id) {
        ReviewDto review = this.reviewService.findReviewById(id);
        return ResponseEntity.ok().body(review);
    }
}
