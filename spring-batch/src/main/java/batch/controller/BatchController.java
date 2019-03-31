package batch.controller;

import batch.entity.BatchJobRequestBody;
import batch.service.BatchJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/batch")
public class BatchController {
    @Autowired
    private BatchJobService batchJobService;

    @PostMapping(value = "/job", produces = MediaType.APPLICATION_JSON_VALUE)
    public int runJob(@RequestBody BatchJobRequestBody requstBody) {

        return batchJobService.runJob(requstBody.getJobId(), requstBody.getFeedFile());
    }
}
