package com.core.service.utils;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class EncriptaBase64 {

    public String encode(String string){
        return  Base64.getEncoder().encodeToString(string.getBytes());
    }

    public String decode(String string){
        byte[] decodedBytes = Base64.getDecoder().decode(string);
        return new String(decodedBytes);
    }
}
