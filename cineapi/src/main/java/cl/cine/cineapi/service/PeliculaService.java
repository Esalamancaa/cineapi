package cl.cine.cineapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.cine.cineapi.model.Pelicula;
import cl.cine.cineapi.repository.PeliculaRepository;

@Service
public class PeliculaService {
    @Autowired
    private PeliculaRepository peliculaRepository;

    // Obtener todas las peliculas

    public List<Pelicula> getPeliculas() {
        return peliculaRepository.findAll();
    }

    // Agregar una nueva pelicula

    public Pelicula savePelicula(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    // Obtener peliculas por su id

    public Pelicula getPeliculaId(int id) {
        return peliculaRepository.findById(id).orElse(null);
    }

    // Obtener peliculas por su nombre

    public List<Pelicula> getPeliculaByGenero(String generoPelicula) {
        return peliculaRepository.findByGenero(generoPelicula);
    }

    // Actualizar datos de peliculas inscritas

    public Pelicula updatePelicula(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    // Eliminar peliculas

    public String deletePelicula(int id) {
        peliculaRepository.deleteById(id);
        return "Pelicula eliminada";
    }
}
