package com.core.service.controllers;

import com.core.service.dto.InformacionProfecionalResponse;
import com.core.service.entities.Articulos;
import com.core.service.interfaces.InformacionProfesionalService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("historico")
public class InformacionProfesionalController {

    private static final String MENSAJE_OBTENCION_DATOS = "Data Success";
    private static final String MENSAJE_DATOS_NO_ENCONTRADOS = "Data not found";
    @Autowired
    InformacionProfesionalService service;
    @Operation(summary = "Historial profesional")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = MENSAJE_OBTENCION_DATOS, content = {@Content(mediaType = "application/json", schema = @Schema(implementation = InformacionProfecionalResponse.class)) } ),
            @ApiResponse(responseCode = "404" , description = MENSAJE_DATOS_NO_ENCONTRADOS, content = {@Content(mediaType = "application/json", schema = @Schema(implementation = InformacionProfecionalResponse.class)) } )
    })
    @GetMapping(value = "/historico", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InformacionProfecionalResponse>> getAll(){
        return new ResponseEntity<>(service.getallProfesionales(), HttpStatus.OK);
    }
}
