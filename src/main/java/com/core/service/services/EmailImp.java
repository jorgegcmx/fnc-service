package com.core.service.services;

import com.core.service.dto.RecuperarContrasenaResponse;
import com.core.service.entities.Profecionales;
import com.core.service.interfaces.EmailService;
import com.core.service.repositories.RepositoryProfecionales;
import com.core.service.utils.EncriptaBase64;
import com.core.service.utils.EnvUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.net.UnknownHostException;

@Service
public class EmailImp implements EmailService {

    @Autowired
    EnvUtil envUtil;
    @Autowired
    private JavaMailSender emailSender;
    @Autowired
    RepositoryProfecionales profecionalesRepository;
    @Autowired
    EncriptaBase64 encriptaBase64;
    @Override
    public String sendEmail(String email) throws UnknownHostException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("funcaes.mail@gmail.com");
        message.setTo(email);
        message.setSubject("Funcaes Activar Email");
        message.setText("Da click en el siguiente enlace para activar tu cuenta, "+envUtil.getServerUrlPrefi()+"/email/activa/"+encriptaBase64.encode(email)+"");
        emailSender.send(message);
        return "ok";
    }

    @Override
    public String ActivateEmail(String email) {
       Profecionales profecionales = profecionalesRepository.findByEmailcliente(encriptaBase64.decode(email));
       profecionales.setActivado("SI");
       profecionalesRepository.save(profecionales);
        return "ok";
    }

    @Override
    public RecuperarContrasenaResponse recupera(String email) {
        RecuperarContrasenaResponse response = new RecuperarContrasenaResponse();
        try {
            Profecionales profecionales = profecionalesRepository.findByEmailcliente(email);
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("funcaes.mail@gmail.com");
            message.setTo(email);
            message.setSubject("Funcaes Datos de Acceso");
            message.setText("Email: "+profecionales.getEmailcliente()+" Contraseña: "+profecionales.getPassword());
            emailSender.send(message);
            response.setEnviado(true);
        }catch (Exception e){
            response.setEnviado(false);
        }
        return response;
    }
}
