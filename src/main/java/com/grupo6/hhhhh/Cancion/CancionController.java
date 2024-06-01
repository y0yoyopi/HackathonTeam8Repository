package com.grupo6.hhhhh.Cancion;

@RestController
@RequestMapping("/canciones")
public class CancionControlador {

    @Autowired
    private CancionRepositorio cancionRepositorio;

    @GetMapping
    public List<Cancion> getAllCanciones() {
        return cancionRepositorio.findAll();
    }

    @PostMapping
    public Cancion createCancion(@RequestBody Cancion cancion) {
        return cancionRepositorio.save(cancion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cancion> updateCancion(@PathVariable Long id, @RequestBody Cancion cancionDetails) {
        Optional<Cancion> cancionOpt = cancionRepositorio.findById(id);
        if (cancionOpt.isPresent()) {
            Cancion cancion = cancionOpt.get();
            cancion.setTitulo(cancionDetails.getTitulo());
            cancion.setDuracion(cancionDetails.getDuracion());
            cancion.setAlbum(cancionDetails.getAlbum());
            cancion.setArtista(cancionDetails.getArtista());
            final Cancion updatedCancion = cancionRepositorio.save(cancion);
            return ResponseEntity.ok(updatedCancion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCancion(@PathVariable Long id) {
        cancionRepositorio.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
