package com.core.service.interfaces;

import com.core.service.dto.RecuperarContrasenaResponse;

import java.net.UnknownHostException;

public interface EmailService {
    String sendEmail(String email) throws UnknownHostException;
    String ActivateEmail(String email);
    RecuperarContrasenaResponse recupera(String email);
}
