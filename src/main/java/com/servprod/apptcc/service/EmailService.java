package com.servprod.apptcc.service;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

	    void sendEmail(SimpleMailMessage msg);
	
}
