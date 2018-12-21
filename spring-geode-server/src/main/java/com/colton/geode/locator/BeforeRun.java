package com.colton.geode.locator;


import org.apache.geode.distributed.LocatorLauncher;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.gemfire.config.annotation.EnableHttpService;
import org.springframework.data.gemfire.config.annotation.EnableManager;
import org.springframework.stereotype.Component;

@Component
@EnableManager(start = true)
@EnableHttpService
public class BeforeRun implements ApplicationRunner {

    public void run(ApplicationArguments args) throws Exception {
        String [] commandLine  = new String[]{"start", "name=locator31431","--port=31431"} ;
        LocatorLauncher.main(commandLine);

    }
}
