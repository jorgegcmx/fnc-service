package com.core.service.controllers;


import com.core.service.entities.Agencias;
import com.core.service.interfaces.AgenciasService;
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
@RequestMapping("agencias")
public class AgenciasController {
    private static final String MENSAJE_OBTENCION_DATOS = "Data Success";
    private static final String MENSAJE_DATOS_NO_ENCONTRADOS = "Data not found";
    @Autowired
    AgenciasService service;
    @Operation(summary = "Listar Agencias")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = MENSAJE_OBTENCION_DATOS, content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Agencias.class)) } ),
            @ApiResponse(responseCode = "404" , description = MENSAJE_DATOS_NO_ENCONTRADOS, content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Agencias.class)) } )
    })
    @GetMapping(value = "/lista/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Agencias>> getAll(@PathVariable String nombre){
        return new ResponseEntity<>(service.getAllAgencias(nombre), HttpStatus.OK);
    }

    @Operation(summary = "Guarda Agencias")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = MENSAJE_OBTENCION_DATOS, content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Agencias.class)) } ),
            @ApiResponse(responseCode = "404" , description = MENSAJE_DATOS_NO_ENCONTRADOS, content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Agencias.class)) } )
    })
    @PostMapping(value = "/guarda", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Agencias> save(@RequestBody Agencias request){
        return new ResponseEntity<>(service.saveAgencias(request), HttpStatus.OK);
    }
}
