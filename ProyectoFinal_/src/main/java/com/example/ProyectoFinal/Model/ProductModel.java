package com.example.ProyectoFinal.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@RequiredArgsConstructor
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor

public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer canDisp;
    private String categoria;
    private LocalDate fecha;

}
