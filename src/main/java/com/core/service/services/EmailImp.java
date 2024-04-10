package com.core.service.services;

import com.core.service.entities.Profecionales;
import com.core.service.interfaces.EmailService;
import com.core.service.repositories.RepositoryProfecionales;
import com.core.service.utils.EncriptaBase64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailImp implements EmailService {

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    RepositoryProfecionales profecionalesRepository;
    @Autowired
    EncriptaBase64 encriptaBase64;
    @Override
    public String sendEmail(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("funcaes.mail@gmail.com");
        message.setTo(email);
        message.setSubject("Funcaes Activar Email");
        message.setText("http://localhost:8080/email/activa/"+encriptaBase64.encode(email)+"");
        emailSender.send(message);
        return "ok";
    }

    @Override
    public String ActivateEmail(String email) {
       Profecionales profecionales = profecionalesRepository.findByEmailcliente(email);
       profecionales.setActivado("SI");
       profecionalesRepository.save(profecionales);
        return "ok";
    }
}
