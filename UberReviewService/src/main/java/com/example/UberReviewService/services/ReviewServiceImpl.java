package com.example.UberReviewService.services;
import com.example.UberReviewService.adapter.ReviewAdapter;
import com.example.UberReviewService.dtos.Review.*;
import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final ReviewAdapter reviewAdapter;

    public ReviewServiceImpl(ReviewRepository reviewRepository, ReviewAdapter reviewAdapter) {
        this.reviewRepository = reviewRepository;
        this.reviewAdapter = reviewAdapter;
    }


    @Override
    public ReviewDto findReviewById(Long id){
        if(reviewRepository.findById(id).isPresent()){
            Review reviewReceived = this.reviewRepository.findReviewById(id);
            return this.reviewAdapter.EntityToReviewDto(reviewReceived);
        }
        return null;
    }

    @Override
    public ReviewDto addReview(CreateReviewDto reviewDto) {

        Review incomingReview = this.reviewAdapter.ReviewDtoToEntity(reviewDto);
        if (incomingReview == null) {
            return null;
        }
        Review savedReview = reviewRepository.save(incomingReview);
        return this.reviewAdapter.EntityToReviewDto(savedReview);

    }


    @Override
    public List<ReviewDto> findAllReviews() {

        List<Review> reviewsIncoming = this.reviewRepository.findAll();
        return reviewsIncoming.stream()
                .map(review -> this.reviewAdapter.EntityToReviewDto(review))
                .collect(Collectors.toList());

    }


    public boolean deleteReviewById(Long id) {
        Review review = this.reviewRepository.findReviewById(id);
        if (review == null) {
            return false;
        } else {
            this.reviewRepository.delete(review);
            return true;
        }
    }

    @Override
    public ReviewDto updateReviewById(Long id, UpdateReviewDto review) {
        Review existReview = this.reviewRepository.findReviewById(id);
        if (existReview == null) {
            return null;
        }else {
            existReview.setRating(review.getRating());
            existReview.setContent(review.getContent());
            reviewRepository.save(existReview);
            return this.reviewAdapter.EntityToReviewDto(existReview);
        }
    }


}
