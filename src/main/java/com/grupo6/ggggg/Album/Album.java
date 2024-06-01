package com.grupo6.ggggg.Album;

import com.grupo6.ggggg.Artista.Artista;
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
