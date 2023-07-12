package com.info.infoprimeraapp.service.sql;

import com.info.infoprimeraapp.domain.Review;
import com.info.infoprimeraapp.repository.ReviewRepository;
import com.info.infoprimeraapp.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Primary
@Service
@AllArgsConstructor
public class ReviewSQLService implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Override
    public List<Review> getAllReviews() {
        return (List<Review>) reviewRepository.findAll();
    }

    @Override
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Optional<Review> updateReview(UUID uuidReview, Review reviewUpdated) {
        Optional<Review> existingReview = reviewRepository.findById(uuidReview);
        if (existingReview.isPresent()) {
            reviewUpdated.setId(uuidReview);
            return Optional.of(reviewRepository.save(reviewUpdated));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Review> findReviewByUUID(UUID id) {
        return reviewRepository.findById(id);
    }

    @Override
    public boolean deleteReview(UUID idReview) {
        if (reviewRepository.existsById(idReview)) {
            reviewRepository.deleteById(idReview);
            return true;
        }
        return false;
    }
}