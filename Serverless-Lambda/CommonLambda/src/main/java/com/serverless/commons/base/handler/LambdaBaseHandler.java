package com.serverless.commons.base.handler;

import com.serverless.commons.starter.LambdaApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

public class LambdaBaseHandler {

    protected ApplicationContext applicationContext;
    private Logger logger = LoggerFactory.getLogger(LambdaBaseHandler.class);

    public void initializeApplication(String... args) {
        try {
            if (applicationContext == null) {
                LambdaApplication lambdaApplication = new LambdaApplication();
                applicationContext = lambdaApplication.getApplicationContext(args);
            }
        } catch (Exception exception) {
            logger.error("Application cannot be started : " + exception.toString());
        }
    }
}
