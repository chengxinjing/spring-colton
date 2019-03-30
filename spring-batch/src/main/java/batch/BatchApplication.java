package batch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
//@Import(value = {InputFile.class,JobConfiguration.class})
@EnableBatchProcessing
public class BatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(BatchApplication.class);
      /*  System.setProperty("InputFileName","F:\\colton\\spring-batch\\src\\main\\resources\\test.data");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BatchApplication.class);
        Job job = context.getBean("PRICE_JOB",Job.class);
        //job.PriceJob();
        System.setProperty("InputFileName","F:\\colton\\spring-batch\\src\\main\\resources\\test1.data");
        System.out.println("----------------------------");
      context.getBean("PRICE_JOB",Job.class);*/

        // job.PriceJob();
    }
}
