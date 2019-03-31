package batch.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
public class BatchJobRequestBody {
    @JsonProperty("jobId")
    private String jobId;
    @JsonProperty("feedFile")
    private String feedFile;

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getFeedFile() {
        return feedFile;
    }

    public void setFeedFile(String feedFile) {
        this.feedFile = feedFile;
    }
}
