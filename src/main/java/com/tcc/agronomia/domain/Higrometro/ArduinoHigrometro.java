package com.tcc.agronomia.domain.Higrometro;

import lombok.*;

import javax.persistence.*;


@Entity(name = "higrometro")
@Data
public class ArduinoHigrometro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "id_arduino")
    private long idArduino;

    private String nome;
}