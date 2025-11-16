package com.fsdm.pfe.ssmdelivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootApplication
@EnableCaching
public class SSMDeliveryApplication {

    public static void main(String[] args) {

        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("lang/messages");
        messageSource.setDefaultEncoding("UTF-8");

        SpringApplication.run(SSMDeliveryApplication.class, args);
    }

}



