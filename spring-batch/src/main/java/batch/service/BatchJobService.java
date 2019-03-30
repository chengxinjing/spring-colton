package batch.service;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
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
    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    ApplicationContext applicationContext;

    public int runJob(String jobName, String feed) {
        String path = "F:\\colton\\spring-batch\\src\\main\\resources\\";
        String suffix = ".data";
        String abPath = path + feed + suffix;
        System.setProperty("InputFileName", abPath);
        String md5 = computeFileMD5(abPath);
        Map<String, JobParameter> jobParameterMap = new LinkedHashMap<>();
        JobParameter jobParameter = new JobParameter(md5);
        jobParameterMap.put(jobName, jobParameter);
        try {
            jobLauncher.run((Job) applicationContext.getBean(jobName), new JobParameters(jobParameterMap));
        } catch (JobExecutionAlreadyRunningException e) {

        } catch (JobRestartException e) {

        } catch (JobInstanceAlreadyCompleteException e) {

        } catch (Exception e) {

        }

        return 0;
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
            e.printStackTrace();
        }
        return md5;
    }


}
