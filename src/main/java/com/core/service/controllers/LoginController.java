package com.core.service.controllers;

import com.core.service.dto.LoginResponse;
import com.core.service.dto.LogingRequest;
import com.core.service.entities.Profecionales;
import com.core.service.interfaces.LoginService;
import com.core.service.interfaces.ProfecionalesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("login")
public class LoginController {

    private static final String MENSAJE_OBTENCION_DATOS = "Data Success";
    private static final String MENSAJE_DATOS_NO_ENCONTRADOS = "Data not found";
    @Autowired
    LoginService service;
    @Operation(summary = "Login admin")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = MENSAJE_OBTENCION_DATOS, content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Profecionales.class)) } ),
            @ApiResponse(responseCode = "404" , description = MENSAJE_DATOS_NO_ENCONTRADOS, content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Profecionales.class)) } )
    })
    @PostMapping(value = "/login_usuario", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LoginResponse> login(@RequestBody LogingRequest request){
        return new ResponseEntity<>(service.login(request), HttpStatus.OK);
    }

    @Operation(summary = "Login profesionales")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = MENSAJE_OBTENCION_DATOS, content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Profecionales.class)) } ),
            @ApiResponse(responseCode = "404" , description = MENSAJE_DATOS_NO_ENCONTRADOS, content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Profecionales.class)) } )
    })
    @PostMapping(value = "/login_profesional", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LoginResponse> login_profesional(@RequestBody LogingRequest request){
        return new ResponseEntity<>(service.login_profesional(request), HttpStatus.OK);
    }
}
