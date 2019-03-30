package batch.controller;

import batch.service.BatchJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/batch")
public class BatchController {
    @Autowired
    private BatchJobService batchJobService;

    @GetMapping("/job/{jobName}/{feed}")
    public int runJob(@PathVariable("jobName") String jobName, @PathVariable("feed") String feed) {

        return batchJobService.runJob(jobName, feed);
    }
}
