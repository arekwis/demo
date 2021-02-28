package com.example.demo.app;

import com.example.demo.def.NumberOperator;
import com.example.demo.def.Operator;
import com.example.demo.service.DataLinkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.example.demo")
@EnableJpaRepositories("com.example.demo")
@EntityScan("com.example.demo")
public class DemoApplication {
    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class.getSimpleName());

    private static DataLinkService<Integer> dataLinkService;

    @Autowired
    public DemoApplication(DataLinkService<Integer> dataLinkService) {
        DemoApplication.dataLinkService = dataLinkService;
    }

    public static void main(String[] args) {
        log.info("App start");
        SpringApplication.run(DemoApplication.class, args);

        Integer a;
        Integer b;
        Operator operator = NumberOperator.ADD;
        Integer result;

        try {
            a = dataLinkService.getFirstInputValue(Integer.class);
            b = dataLinkService.getSecondInputValue(Integer.class);

            log.info("Numbers provided: {} | {}", a, b);

            result = dataLinkService.link(a, b, operator);

            log.info("Operation: {} {} {}. Result: {}", a, operator, b, result);
        } catch (IllegalArgumentException e) {
            log.warn("Could not perform operation. {}", e.getMessage());
        }
    }

}
