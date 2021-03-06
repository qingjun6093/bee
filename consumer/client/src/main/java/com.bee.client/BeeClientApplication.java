package com.bee.client;

import org.springframework.boot.SpringApplication;
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
public class BeeClientApplication {
    public static void main(String[] args) {
        new SpringApplication(BeeClientApplication.class).run(args);
    }
}
