package com.grupo6.ggggg.Cancion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;


@Service
public class CancionService {

    @Autowired
    private CancionRepository cancionRepositorio;

    public List<Cancion> getAllCanciones() {
        return cancionRepositorio.findAll();
    }

    public Cancion createCancion(Cancion cancion) {
        return cancionRepositorio.save(cancion);
    }

    public Optional<Cancion> getCancionById(Long id) {
        return cancionRepositorio.findById(id);
    }

    public Optional<Cancion> updateCancion(Long id, Cancion cancionDetails) {
        return cancionRepositorio.findById(id).map(cancion -> {
            cancion.setTitulo(cancionDetails.getTitulo());
            cancion.setDuracion(cancionDetails.getDuracion());
            cancion.setAlbum(cancionDetails.getAlbum());
            cancion.setArtista(cancionDetails.getArtista());
            return cancionRepositorio.save(cancion);
        });
    }

    public void deleteCancion(Long id) {
        cancionRepositorio.deleteById(id);
    }
}
