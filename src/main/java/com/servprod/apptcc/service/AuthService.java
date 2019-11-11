package com.servprod.apptcc.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.servprod.apptcc.models.UsuarioComum;
import com.servprod.apptcc.repository.UsuarioComumRepository;
import com.servprod.apptcc.service.exceptions.ObjectNotFoundException;



@Service
public class AuthService {
	
    @Autowired
    private UsuarioComumRepository usuarioComumRepository;
    
    @Autowired
    private BCryptPasswordEncoder pe;
	
    @Autowired
    private EmailService emailService;
    
    private Random rand = new Random();
	
    public void sendNewPassword(String email) {
        UsuarioComum usuarioComum = usuarioComumRepository.findByEmail(email);
        if(usuarioComum == null) {
            throw new ObjectNotFoundException("Email não encontrado");
        }

        String newPass = newPassword();
        usuarioComum.setSenha(pe.encode(newPass));
        usuarioComumRepository.save(usuarioComum);
        emailService.sendNewPasswordEmail(usuarioComum, newPass);
    }
	
    public String newPassword() {
        char[] vet = new char[10];
        for (int i=0; i<10; i++) {
            vet[i] = randomChar();
        }
        return new String(vet);
    }

    public char randomChar() {
        int opt = rand.nextInt(3);
        if (opt == 0) { // gera um dígito
            return (char) (rand.nextInt(10) + 48);
        } else if (opt == 1) { // gera letra maiúscula
            return (char) (rand.nextInt(26) + 65);
        } else { // gera letra minúscula
            return (char) (rand.nextInt(26) + 97);
        }
    }
	

}
