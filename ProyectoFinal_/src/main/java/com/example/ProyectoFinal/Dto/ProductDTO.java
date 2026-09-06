package com.example.ProyectoFinal.Dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer canDisp;
    private String categoria;
    private LocalDate fecha;


}

