package com.servprod.apptcc.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import com.servprod.apptcc.models.UsuarioComum;

public abstract class AbstractEmailService implements EmailService{
	
    @Value("${default.sender}")
    private String sender;
    
    @Override
    public void sendNewPasswordEmail(UsuarioComum usuarioComum, String newPass) {
        SimpleMailMessage sm = prepareNewPasswordEmail(usuarioComum, newPass);
        sendEmail(sm);
    }
    
    protected SimpleMailMessage prepareNewPasswordEmail(UsuarioComum usuarioComum, String newPass) {
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(usuarioComum.getEmail());
        sm.setFrom(sender);
        sm.setSubject("Solicitação de nova senha");
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText("Nova senha: " + newPass);
        return sm;
    }
	

}
