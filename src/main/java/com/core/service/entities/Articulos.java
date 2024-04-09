package com.core.service.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Articulos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idarticulos;
    private String codigo;
    private String nombre;
    private BigDecimal precio_mayoreo;
    private BigDecimal precio_menudeo;
    private Integer idcategoria;
    private String img;
    private String descripcion;
    private Integer idusuarios;
}
