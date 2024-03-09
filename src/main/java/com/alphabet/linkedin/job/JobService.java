package com.alphabet.linkedin.job;

import com.alphabet.linkedin.job.impl.JobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobService implements JobServiceImpl {

    //    private List<Job> jobs = new ArrayList<>();
    @Autowired
    private JobRepository jobRepository;
//    private long id = 1L;

    /**
     * @return
     */
    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Job getJob(Long id) {
//        Iterator<Job> itr = jobs.listIterator();
//        while (itr.hasNext()) {
//            Job x = itr.next();
//            if (x.getId() == id) {
//                return x;
//            }
//        }
//        return null;
        return jobRepository.findById(id).orElse(null);
    }

    /**
     * @param job
     * @return
     */

    @Override
    public String createJob(Job job) {
//        job.setId(id++);
//        jobs.add(job);
        jobRepository.save(job);
        return "job created successfully";
    }

    /**
     * @param id
     * @return
     */
    @Override
    public boolean deleteJob(Long id) {

//        boolean status = false;
//        int index = 0;
//        for (Job job : jobs) {
//            status = job.getId() == id;
//            if (status) {
//                break;
//            }
//            index++;
//        }
//        if (status) {
//            jobs.remove(index);
//            return true;
//        } else {
//            return false;
//        }
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    /**
     * @param job
     * @return
     */
    @Override
    public boolean updateJob(long id, Job updatedJob) {

//        boolean status = false;
//        int index = 0;
//        for (Job job : jobs) {
//            status = job.getId() == id;
//            if (status) {
//                break;
//            }
//            index++;
//        }
//        if (status) {
//            jobs.add(index, updatedJob);
//            return true;
//        }
//        return false;
//        ==== 2nd way
//        for (Job job : jobs) {
//            if(job.getId() == id){
////                job.setId(updatedJob.getId());
//                job.setDescription(updatedJob.getDescription());
//                job.setLocation(updatedJob.getLocation());
//                job.setTitle(updatedJob.getTitle());
//                job.setMaxSalary(updatedJob.getMaxSalary());
//                job.setMinSalary(updatedJob.getMinSalary());
//                return true;
//            }
//        }
//        return false;

        Optional<Job> jobOptional = jobRepository.findById(id);

        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
//            job.setId(updatedJob.getId());
            job.setDescription(updatedJob.getDescription());
            job.setLocation(updatedJob.getLocation());
            job.setTitle(updatedJob.getTitle());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setMinSalary(updatedJob.getMinSalary());
            jobRepository.save(job);
            return true;
        } else
            return false;
//
    }


}
