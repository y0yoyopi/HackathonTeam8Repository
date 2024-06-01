package com.grupo6.ggggg.Artista;

import jakarta.persistence.*;

@Entity
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    // Getters and Setters
}
