package com.bee.passport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

/**
 * @author jjq
 * @version 1.0
 * @date 2019/6/19
 * @desc
 */
@SpringBootApplication
public class BeePassportApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = new SpringApplicationBuilder()
                .sources(BeePassportApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }
}
