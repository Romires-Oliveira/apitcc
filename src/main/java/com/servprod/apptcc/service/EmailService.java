package com.servprod.apptcc.service;

import org.springframework.mail.SimpleMailMessage;

import com.servprod.apptcc.models.UsuarioComum;

public interface EmailService {

    void sendEmail(SimpleMailMessage msg);

    void sendNewPasswordEmail(UsuarioComum usuarioComum, String newPass);

}
