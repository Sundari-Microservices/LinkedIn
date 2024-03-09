package com.alphabet.linkedin.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    //    post => /companies/{companyId}/reviews  /*posts the review for particular company by id*/

    @PostMapping("/reviews")
    public ResponseEntity<String> createReview(@RequestBody Review review, @PathVariable long companyId) {

        boolean status = reviewService.createReview(review, companyId);
        if (status) {
            return new ResponseEntity<>("review created successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("failed to create review", HttpStatus.NOT_FOUND);
        }

    }


    //    Get => /companies/{companyId}/reviews /*gets the review for particular company by id*/

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviewsByCompanyId(@PathVariable long companyId) {
        List<Review> reviews = reviewService.getAllReviews(companyId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

//    //    Get => /companies/{companyId}/reviews/{reviewId} /*gets a particular review for particular company by id*/
    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReviewByReviewIdAndCompanyId(@PathVariable long reviewId, @PathVariable long companyId) {
        Review review = reviewService.getReview(reviewId, companyId);
        if (review != null) {
            return new ResponseEntity<>(review, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Review(), HttpStatus.NOT_FOUND);
        }

    }
//
//    //    Put => /companies/{companyId}/reviews/{reviewId} /*puts a particular review for particular company by id*/
    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReviewByReviewIdAndCompanyId(@RequestBody Review review, @PathVariable long reviewId, @PathVariable long companyId) {
        boolean status = reviewService.updateReview(review, reviewId, companyId);
        if (status) {
            return new ResponseEntity<>("review updated successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("failed to update review.", HttpStatus.NOT_FOUND);
        }

    }
//
//    //    delete => /companies/{companyId}/reviews/{reviewId} /*delete a particular review for particular company by id*/
    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReviewByReviewIdAndCompanyId(@PathVariable long reviewId, @PathVariable long companyId) {
        boolean status = reviewService.deleteReview(reviewId, companyId);
        if (status) {
            return new ResponseEntity<>("review deleted successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("failed to delete review.", HttpStatus.NOT_FOUND);
        }

    }

}
