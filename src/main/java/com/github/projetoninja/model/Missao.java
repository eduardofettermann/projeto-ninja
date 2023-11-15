package com.github.projetoninja.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name = "missoes")
@Getter
@Setter
@AllArgsConstructor
public class Missao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDaMissao;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "idDoNinja")
    private Ninja ninjaAtribuido;
    @NonNull
    private String classificacao;
    @NonNull
    private String tipoDaMissao;
    private boolean concluida;
}