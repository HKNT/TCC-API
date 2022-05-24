package com.tcc.agronomia.domain.Usuario;

import com.tcc.agronomia.domain.Role.Role;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String senha;
    private boolean ativo;

    @Column(name = "perfil_id")
    private Long perfilId;

    @Column(name = "grupo_id")
    private Long grupoId;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles;
}
