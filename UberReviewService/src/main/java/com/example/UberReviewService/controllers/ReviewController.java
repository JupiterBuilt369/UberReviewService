package com.example.UberReviewService.controllers;

import com.example.UberReviewService.adapter.ReviewAdapter;
import com.example.UberReviewService.dtos.Review.CreateReviewDto;
import com.example.UberReviewService.dtos.Review.ReviewDto;
import com.example.UberReviewService.dtos.Review.UpdateReviewDto;
import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.services.ReviewService;
import org.springframework.http.HttpStatus;
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
        if (review == null) {
            return ResponseEntity.badRequest().body("BAD_REQUEST. No Review found with id " + id);
        }
        return ResponseEntity.ok().body(review);
    }

    @GetMapping
    public ResponseEntity<?> getAllReviews() {
        return ResponseEntity.ok().body(this.reviewService.findAllReviews());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReviewById(@PathVariable Long id) {
        boolean deleted = this.reviewService.deleteReviewById(id);
        if (deleted) {
            return ResponseEntity.ok("Review deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No review found with id " + id + ". Can't delete.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateReviewById(@PathVariable Long id, @Validated @RequestBody UpdateReviewDto reviewRequest) {
        ReviewDto updated = this.reviewService.updateReviewById(id, reviewRequest);
        if (updated == null) {
            return ResponseEntity.badRequest().body("BAD_REQUEST. No Review found with id " + id);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No review found with id " + id);
        }
    }

}
