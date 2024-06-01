package com.grupo6.ggggg.ListaDeReproduccion;

import com.grupo6.ggggg.Cancion.Cancion;
import com.grupo6.ggggg.Usuario.Usuario;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
public class ListaDeReproduccion {

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
