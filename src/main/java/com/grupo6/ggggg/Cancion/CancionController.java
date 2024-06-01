package com.grupo6.ggggg.Cancion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/canciones")
public class CancionController{

    @Autowired
    private CancionRepository cancionRepository;

    @GetMapping
    public List<Cancion> getAllCanciones() {
        return cancionRepository.findAll();
    }

    @PostMapping
    public Cancion createCancion(@RequestBody Cancion cancion) {
        return cancionRepository.save(cancion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cancion> updateCancion(@PathVariable Long id, @RequestBody Cancion cancionDetails) {
        Optional<Cancion> cancionOpt = cancionRepository.findById(id);
        if (cancionOpt.isPresent()) {
            Cancion cancion = cancionOpt.get();
            cancion.setTitulo(cancionDetails.getTitulo());
            cancion.setDuracion(cancionDetails.getDuracion());
            cancion.setAlbum(cancionDetails.getAlbum());
            cancion.setArtista(cancionDetails.getArtista());
            final Cancion updatedCancion = cancionRepository.save(cancion);
            return ResponseEntity.ok(updatedCancion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCancion(@PathVariable Long id) {
        cancionRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
