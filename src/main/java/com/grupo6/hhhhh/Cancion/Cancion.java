package com.grupo6.hhhhh.Cancion;

import com.grupo6.hhhhh.Album.Album;
import com.grupo6.hhhhh.Artista.Artista;
import jakarta.persistence.*;

@Entity
public class Cancion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String duracion;

    @ManyToOne
    private Album album;

    @ManyToOne
    private Artista artista;

    // Getters and Setters
}
