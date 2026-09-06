package com.example.ProyectoFinal.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
//@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String role;
}
