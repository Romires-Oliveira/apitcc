package com.servprod.apptcc.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.servprod.apptcc.service.EmailService;
import com.servprod.apptcc.service.MockEmailService;
import com.servprod.apptcc.service.SmtpEmailService;

@Configuration
@Profile("test")
public class TestConfig {

//    @Bean
//    public EmailService emailService() {
//        return new MockEmailService();
//    }

    @Bean
    public EmailService emailService() {
        return new SmtpEmailService();
    }
}