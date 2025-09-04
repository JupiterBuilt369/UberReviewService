package com.example.UberReviewService.repositories;

import com.example.UberReviewService.models.Review;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    Integer countAllByRatingLessThanEqual(Integer givenRating);

    List<Review> findAllByRatingGreaterThanEqual(Integer givenRating);

    List<Review> findAllByCreatedAtBefore(Date date);

    Review findReviewById(Long id);

    boolean existsByBookingId(Long id);
}