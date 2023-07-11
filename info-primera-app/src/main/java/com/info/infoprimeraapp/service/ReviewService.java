package com.info.infoprimeraapp.service;

import com.info.infoprimeraapp.domain.Review;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReviewService {

    List<Review> getAllReviews();

    Review createReview(Review review);

    Optional<Review> updateReview(UUID uuidReview, Review reviewUpdated);

    Optional<Review> findReviewByUUID(UUID id);

    boolean deleteReview(UUID idReview);
}