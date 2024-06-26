package com.core.service.controllers;

import com.core.service.dto.GuardaProfecionalResponse;
import com.core.service.entities.Profecionales;
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
@RequestMapping("profesionales")
public class ProfecionalesController {
    private static final String MENSAJE_OBTENCION_DATOS = "Data Success";
    private static final String MENSAJE_DATOS_NO_ENCONTRADOS = "Data not found";
    @Autowired
    ProfecionalesService service;
    @Operation(summary = "Listar Profesionales")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = MENSAJE_OBTENCION_DATOS, content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Profecionales.class)) } ),
            @ApiResponse(responseCode = "404" , description = MENSAJE_DATOS_NO_ENCONTRADOS, content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Profecionales.class)) } )
    })
    @GetMapping(value = "/lista", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Profecionales>> getAll(){
        return new ResponseEntity<>(service.getAllClientes(), HttpStatus.OK);
    }
    @Operation(summary = "Listar por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = MENSAJE_OBTENCION_DATOS, content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Profecionales.class)) } ),
            @ApiResponse(responseCode = "404" , description = MENSAJE_DATOS_NO_ENCONTRADOS, content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Profecionales.class)) } )
    })
    @GetMapping(value = "/lista/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Profecionales> getById(@PathVariable Integer id){
        return new ResponseEntity<>(service.getClientesById(id), HttpStatus.OK);
    }

    @Operation(summary = "Registra y Actualiza Profesionales")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = MENSAJE_OBTENCION_DATOS, content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Profecionales.class)) } ),
            @ApiResponse(responseCode = "404" , description = MENSAJE_DATOS_NO_ENCONTRADOS, content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Profecionales.class)) } )
    })
    @PostMapping(value = "/registro", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GuardaProfecionalResponse> save(@RequestBody Profecionales profecionales){
         return new ResponseEntity<>(service.saveClientes(profecionales),HttpStatus.OK);
    }


}
