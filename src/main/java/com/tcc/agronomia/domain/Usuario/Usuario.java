package com.tcc.agronomia.domain.Usuario;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String email;
    private String senha;
    private boolean ativo;

    @Column(name = "perfil_id")
    private long perfilId;

    @Column(name = "grupo_id")
    private long grupoId;
}
