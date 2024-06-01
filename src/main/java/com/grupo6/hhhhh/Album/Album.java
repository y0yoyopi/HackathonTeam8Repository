package com.grupo6.hhhhh.Album;

import com.grupo6.hhhhh.Artista.Artista;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private LocalDate fechaLanzamiento;

    @ManyToOne
    private Artista artista;

    // Getters and Setters
}
