package com.alphabet.linkedin.review;

import java.util.List;

public interface ReviewServiceImpl {


        boolean createReview(Review review, long companyId);
        List<Review> getAllReviews(long companyId);
        Review getReview(long reviewId, long companyId);
        boolean updateReview(Review updatedReview, long reviewId, long companyId);
        boolean deleteReview(long reviewId, long companyId);


}
