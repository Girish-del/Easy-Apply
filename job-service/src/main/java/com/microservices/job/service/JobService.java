package com.microservices.job.service;

import com.microservices.job.dto.JobRequest;
import com.microservices.job.model.Job;
import com.microservices.job.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class JobService {

    private final JobRepository jobRepository;

    public void placeJobRequest(JobRequest jobRequest){
        Job job = new Job();
        job.setOrderNumber(UUID.randomUUID().toString());
        job.setSkuCode(jobRequest.skuCode());
        job.setPrice(jobRequest.price());
        job.setQuantity(jobRequest.quantity());
        job.setDescription(jobRequest.description());

        jobRepository.save(job);
    }
}
