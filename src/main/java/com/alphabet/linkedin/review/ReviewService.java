package com.alphabet.linkedin.review;

import com.alphabet.linkedin.company.ComapnyService;
import com.alphabet.linkedin.company.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService implements ReviewServiceImpl{

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ComapnyService companyService;


    @Override
    public boolean createReview(Review review, long companyId) {
        Company company = companyService.getCompanyById(companyId);
        if(company!=null){
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
//        else {
//            // add company and then add review.
////            companyService.createCompany();
//        }
        return false;
    }

    @Override
    public List<Review> getAllReviews(long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public Review getReview(long reviewId, long companyId) {

        List<Review> reviews = getAllReviews(companyId);
        return reviews.stream()
                .filter(review -> (review.getId() == reviewId))
                .findFirst()
                .orElse(null);
    }
//
//    @Override
    public boolean updateReview(Review updatedReview, long reviewId, long companyId) {

        Review review = getReview(reviewId,companyId);
        if(review!=null){
//            review.setCompany(updatedReview.getCompany());
            review.setDescription(updatedReview.getDescription());
            review.setRating(updatedReview.getRating());
            review.setTitle(updatedReview.getTitle());
            reviewRepository.save(review);
            return true;
        }else{
            return false;
        }
    }
//
    @Override
    public boolean deleteReview(long reviewId, long companyId) {
        Review review = getReview(reviewId,companyId);
        if(review!=null && reviewRepository.existsById(reviewId) ){


            reviewRepository.delete(review);
            return true;
        }else{
            return false;
        }
    }
}
