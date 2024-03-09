package com.alphabet.linkedin.company;

import com.alphabet.linkedin.job.Job;
import com.alphabet.linkedin.review.Review;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "Company")
public class Company {

//    fields: {companyId, companyName, companyDescription, companyLocation, List<job> jobs}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String companyDescription;
    private String companyLocation;

    @OneToMany(mappedBy = "company")
    private List<Job> jobs;

    @OneToMany(mappedBy = "company")
    private List<Review> reviews;

    public Company(){

    }

//    public Company(Long id, String companyName, String companyDescription, String companyLocation, List<Job> jobs, List<Review> reviews) {
//        this.id = id;
//        this.companyName = companyName;
//        this.companyDescription = companyDescription;
//        this.companyLocation = companyLocation;
//        this.jobs = jobs;
//        this.reviews = reviews;
//    }

    public Long getCompanyId() {
        return id;
    }

    public void setCompanyId(Long companyId) {
        this.id = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public String getCompanyLocation() {
        return companyLocation;
    }

    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    /**
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", companyDescription='" + companyDescription + '\'' +
                ", companyLocation='" + companyLocation + '\'' +
                ", jobs=" + jobs +
                ", reviews=" + reviews +
                '}';
    }
}
