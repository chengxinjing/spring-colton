package batch.jobs;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component("inputFile")
public class InputFile {
    public String getInputFileName() {
        System.out.println(System.getProperty("InputFileName"));
        return StringUtils.isEmpty(System.getProperty("InputFileName")) ? "" : System.getProperty("InputFileName");
    }
}
