package com.microservices.job.controller;

import com.microservices.job.dto.JobRequest;
import com.microservices.job.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/job")
@RequiredArgsConstructor
public class jobController {

    private final JobService jobService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placedJobOrders(@RequestBody JobRequest jobRequest){
        jobService.placeJobRequest(jobRequest);
        return "Job order placed successfully";
    }
}
