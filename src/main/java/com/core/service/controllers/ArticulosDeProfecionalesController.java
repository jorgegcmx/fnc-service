package com.core.service.controllers;

import com.core.service.entities.Articulosdeprofecionales;
import com.core.service.entities.Profecionales;
import com.core.service.interfaces.ArticulosProfecionalesService;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("detalle")
public class ArticulosDeProfecionalesController {
    private static final String MENSAJE_OBTENCION_DATOS = "Data Success";
    private static final String MENSAJE_DATOS_NO_ENCONTRADOS = "Data not found";
    @Autowired
    ArticulosProfecionalesService service;
    @Operation(summary = "Listar los registros de cursos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = MENSAJE_OBTENCION_DATOS, content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Articulosdeprofecionales.class)) } ),
            @ApiResponse(responseCode = "404" , description = MENSAJE_DATOS_NO_ENCONTRADOS, content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Articulosdeprofecionales.class)) } )
    })
    @GetMapping(value = "/lista", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Articulosdeprofecionales>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
}
