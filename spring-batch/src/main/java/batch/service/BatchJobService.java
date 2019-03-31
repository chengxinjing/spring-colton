package batch.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class BatchJobService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BatchJobService.class);
    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    ApplicationContext applicationContext;

    public int runJob(String jobName, String feedFile) {
        int rtCode = 0;
        System.setProperty("InputFileName", feedFile);
        String md5 = computeFileMD5(feedFile);
        Map<String, JobParameter> jobParameterMap = new LinkedHashMap<>();
        JobParameter jobParameter = new JobParameter(md5);
        jobParameterMap.put(jobName, jobParameter);
        try {
            JobExecution jobExecution = jobLauncher.run((Job) applicationContext.getBean(jobName), new JobParameters(jobParameterMap));
            rtCode = getRtCode(jobExecution);
        } catch (JobExecutionAlreadyRunningException e) {
            rtCode = 1;
            LOGGER.info("job already running");
            LOGGER.info(e.getMessage(), e);
            return rtCode;
        } catch (JobRestartException e) {
            LOGGER.info("job can't restart");
            LOGGER.info(e.getMessage(), e);
        } catch (JobInstanceAlreadyCompleteException e) {
            rtCode = 0;
            LOGGER.info("job already complete");
            LOGGER.info(e.getMessage(), e);
            return rtCode;
        } catch (Exception e) {
            rtCode = 3;
            LOGGER.info(e.getMessage(), e);
        }
        return rtCode;
    }

    private int getRtCode(JobExecution jobExecution) {
        ExitStatus status = jobExecution.getExitStatus();
        int rtCode = 0;
        if (ExitStatus.COMPLETED.equals(status)) {
            rtCode = 0;
        } else if (ExitStatus.EXECUTING.equals(status)) {
            rtCode = 1;
        } else if (ExitStatus.NOOP.equals(status)) {
            rtCode = 2;
        } else if (ExitStatus.FAILED.equals(status)) {
            rtCode = 3;
        } else {
            rtCode = 4;
        }
        return rtCode;
    }

    private String computeFileMD5(String filePath) {
        String md5 = "";
        File file = new File(filePath);
        byte[] bytes = new byte[1024];
        try (FileInputStream inputStream = new FileInputStream(file)) {
            MessageDigest md = MessageDigest.getInstance("MD5");
            int length = -1;
            while ((length = inputStream.read(bytes)) != -1) {
                md.update(bytes, 0, length);
            }
            BigInteger integer = new BigInteger(1, md.digest());
            md5 = integer.toString(16);
        } catch (Exception e) {
            LOGGER.info(e.getMessage(), e);
        }
        return md5;
    }


}
