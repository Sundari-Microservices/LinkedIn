package com.alphabet.linkedin.job;

import com.alphabet.linkedin.company.Company;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "Job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;


    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Job(){

    }

//    public Job(long jobId, String title, String description, String minSalary, String maxSalary, String location, Company company) {
//        this.id = jobId;
//        this.title = title;
//        this.description = description;
//        this.minSalary = minSalary;
//        this.maxSalary = maxSalary;
//        this.location = location;
//        this.company = company;
//    }

    public long getJobId() {
        return id;
    }

    public void setJobId(long jobId) {
        this.id = jobId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobId=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", minSalary='" + minSalary + '\'' +
                ", maxSalary='" + maxSalary + '\'' +
                ", location='" + location + '\'' +
                ", company=" + company +
                '}';
    }
}
