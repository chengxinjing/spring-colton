package batch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//\(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableBatchProcessing
public class BatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(BatchApplication.class);
        System.out.println("===========================Batch Service===========================");//NOSONAR
        System.out.println("=====================                         =====================");//NOSONAR
        System.out.println("=====================  Batch Service Started  =====================");//NOSONAR
        System.out.println("=====================                         =====================");//NOSONAR
        System.out.println("===========================Batch Service ==========================");//NOSONAR
    }
}
