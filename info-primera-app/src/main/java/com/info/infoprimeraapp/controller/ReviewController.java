package com.info.infoprimeraapp.controller;

import com.info.infoprimeraapp.domain.Review;
import com.info.infoprimeraapp.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/review")
@Slf4j
public class ReviewController {

    private final ReviewService rs;

    public ReviewController(ReviewService rs) {
        this.rs = rs;
    }

    @GetMapping()
    public List<Review> getAllReviews() {
        log.info("Requesting reviews");
        return rs.getAllReviews();
    }

    @PostMapping()
    public Review createReview(@RequestBody Review review) {
        log.info("Creating a new review");
        return rs.createReview(review);
    }

    @DeleteMapping("{uuid}")
    public String deleteAuthor(@PathVariable UUID id) {
        boolean del = rs.deleteReview(id);

        if (del) {
            log.info("Review deleted");
            return "Review deleted";
        } else {
            log.info("Review not found");
            return "Review not found";
        }
    }

    @PutMapping("{idReview}")
    public String updateReview(@PathVariable(value = "idReview")UUID idReview,@RequestBody Review reviewUpdated){
        Optional<Review> review = rs.updateReview(idReview,reviewUpdated);

        if(review.isEmpty()){
            log.info("Review not found");
            return "Review not found";
        }else {
            log.info("Review updated");
            return "/api/v1/review/"+review.get().getId();
        }
    }

    @GetMapping("search")
    public Optional<Review> searchReviewById(@RequestParam("id") UUID id) {
        log.info("Searching review by UUID");
        return rs.findReviewByUUID(id);
    }
}
