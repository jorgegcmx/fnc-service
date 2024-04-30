package com.core.service.interfaces;

import com.core.service.dto.RecuperarContrasenaResponse;

public interface EmailService {
    String sendEmail(String email);
    String ActivateEmail(String email);
    RecuperarContrasenaResponse recupera(String email);
}
