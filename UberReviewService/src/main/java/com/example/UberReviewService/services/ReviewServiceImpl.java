package com.example.UberReviewService.services;

import com.example.UberReviewService.adapter.ReviewAdapter;
import com.example.UberReviewService.dtos.CreateReviewDto;
import com.example.UberReviewService.dtos.ReviewDto;
import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService{

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
