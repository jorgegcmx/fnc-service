package com.core.service.controllers;

import com.core.service.dto.RecuperarContrasenaResponse;
import com.core.service.entities.Agencias;
import com.core.service.entities.Articulos;
import com.core.service.interfaces.EmailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.UnknownHostException;
import java.util.List;


@RestController
@RequestMapping("email")
public class EmailController {
    private static final String MENSAJE_OBTENCION_DATOS = "Data Success";
    private static final String MENSAJE_DATOS_NO_ENCONTRADOS = "Data not found";
    @Autowired
    EmailService service;

    @Operation(summary = "Envia email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = MENSAJE_OBTENCION_DATOS, content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class)) } ),
            @ApiResponse(responseCode = "404" , description = MENSAJE_DATOS_NO_ENCONTRADOS, content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class)) } )
    })
    @GetMapping(value = "/send/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> send(@PathVariable String email) throws UnknownHostException {
        return new ResponseEntity<>(service.sendEmail(email), HttpStatus.OK);
    }

    @Operation(summary = "Reenvia Datos de Acceso")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = MENSAJE_OBTENCION_DATOS, content = {@Content(mediaType = "application/json", schema = @Schema(implementation = RecuperarContrasenaResponse.class)) } ),
            @ApiResponse(responseCode = "404" , description = MENSAJE_DATOS_NO_ENCONTRADOS, content = {@Content(mediaType = "application/json", schema = @Schema(implementation = RecuperarContrasenaResponse.class)) } )
    })
    @GetMapping(value = "/resend/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RecuperarContrasenaResponse> resend(@PathVariable String email){
        return new ResponseEntity<>(service.recupera(email), HttpStatus.OK);
    }

    @Operation(summary = "Activa email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = MENSAJE_OBTENCION_DATOS, content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class)) } ),
            @ApiResponse(responseCode = "404" , description = MENSAJE_DATOS_NO_ENCONTRADOS, content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class)) } )
    })
    @GetMapping(value = "/activa/{email}")
    public String activate(@PathVariable String email){
        service.ActivateEmail(email);
        return """
                <html>
                    <header>
                    <title>funcaes</title>
                    </header>
                        <body>
                        <center>
                            <h1>¡Su correo fue activado correctamente!</h1>
                            <h2>Ahorra puede iniciar sesión en Funcaes</h2>
                        </center>
                        </body>
                </html>
                """;
    }
}
