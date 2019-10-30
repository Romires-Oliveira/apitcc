package com.servprod.apptcc.service;

import org.springframework.beans.factory.annotation.Value;

public abstract class AbstractEmailService implements EmailService{
	
    @Value("${default.sender}")
    private String sender;
	

}
