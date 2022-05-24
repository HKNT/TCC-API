package com.tcc.agronomia.domain.Arduino;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Arduino {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    private String  nome;

    @Column(name = "plantacao_id")
    private long   plantacaoID;
}