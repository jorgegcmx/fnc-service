package com.core.service.interfaces;

import com.core.service.dto.LoginResponse;
import com.core.service.dto.LogingRequest;

public interface LoginService {
    LoginResponse login(LogingRequest request);
    LoginResponse login_profesional(LogingRequest request);
}
