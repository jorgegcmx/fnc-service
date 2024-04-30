package com.core.service.services;

import com.core.service.dto.LoginResponse;
import com.core.service.dto.LogingRequest;
import com.core.service.entities.Profecionales;
import com.core.service.entities.Usuarios;
import com.core.service.interfaces.LoginService;
import com.core.service.repositories.RepositoryProfecionales;
import com.core.service.repositories.RepositoryUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginImp implements LoginService {

    @Autowired
    RepositoryUsuarios repositoryUsuarios;

    @Autowired
    RepositoryProfecionales repositoryProfecionales;
    @Override
    public LoginResponse login(LogingRequest request) {
        LoginResponse response = new LoginResponse();
        try {
            Usuarios usuarios = repositoryUsuarios.findByEmailAndContrasena(request.getEmail(), request.getContrasena());
            response.setUserId(usuarios.getIdusuarios());
            response.setIsLogged(true);
            response.setUser(usuarios.getEmail());
        }catch (Exception e){
            response.setUserId(null);
            response.setIsLogged(false);
            response.setUser(null);
        }

       return response;
    }

    @Override
    public LoginResponse login_profesional(LogingRequest request) {

        LoginResponse response = new LoginResponse();
        try {
            Profecionales profecionales = repositoryProfecionales.findByEmailclienteAndPassword(request.getEmail(), request.getContrasena());
            response.setUserId(profecionales.getIdprofecional());
            response.setIsLogged(true);
            response.setUser(profecionales.getEmailcliente());
        }catch (Exception e){
            response.setUserId(null);
            response.setIsLogged(false);
            response.setUser(null);
        }

        return response;
    }
}
