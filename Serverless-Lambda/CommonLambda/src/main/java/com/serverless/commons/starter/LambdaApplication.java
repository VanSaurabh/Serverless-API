package com.serverless.commons.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

public class LambdaApplication {

    private ApplicationContext applicationContext;

    public ApplicationContext getApplicationContext(String... args) {
        if (applicationContext == null) {
            applicationContext = SpringApplication.run(LambdaApplication.class, args);
        }
        return applicationContext;
    }

    public static void main(String[] args) {
        new LambdaApplication().getApplicationContext(args);
    }
}
