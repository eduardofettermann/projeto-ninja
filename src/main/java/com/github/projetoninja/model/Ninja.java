package com.github.projetoninja.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ninjas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ninja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDoNinja;
    @NonNull
    private String nome;
    @NonNull
    private String vila;
    private boolean ativo;
    @NonNull
    private String nivelDeExperiencia;
}