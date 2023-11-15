package com.github.projetoninja.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "ninjas")
@Getter
@Setter
@AllArgsConstructor
public class Ninja {
    @Id
    @GeneratedValue
    private long idDoNinja;
    @NonNull
    private String nome;
    @NonNull
    private String vila;
    private boolean ativo;
    @NonNull
    private String nivelDeExperiencia;
}