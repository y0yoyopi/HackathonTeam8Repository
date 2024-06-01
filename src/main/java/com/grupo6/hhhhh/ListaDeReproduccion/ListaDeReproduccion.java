package com.grupo6.hhhhh.ListaDeReproduccion;

import com.grupo6.hhhhh.Cancion.Cancion;
import com.grupo6.hhhhh.Usuario.Usuario;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private LocalDate fechaCreacion;

    @ManyToOne
    private Usuario usuario;

    @ManyToMany
    @JoinTable(
            name = "playlist_cancion",
            joinColumns = @JoinColumn(name = "playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "cancion_id")
    )
    private Set<Cancion> canciones;

    // Getters and Setters
}
