package cl.cine.cineapi.mapper;

import cl.cine.cineapi.dto.CreatePeliculaRequest;
import cl.cine.cineapi.dto.UpdatePeliculaRequest;
import cl.cine.cineapi.model.Pelicula;

public class PeliculaMapper {
    public static Pelicula toModel(CreatePeliculaRequest request) {
        return new Pelicula(0, 
                request.nombrePelicula(), request.generoPelicula(), 
                request.fechaEstrenoPelicula(), request.duracionPelicula());
    }

    public static Pelicula toModel(int id, UpdatePeliculaRequest request) {
        return new Pelicula(id,
                request.nombrePelicula(), request.generoPelicula(), 
                request.fechaEstrenoPelicula(), request.duracionPelicula());
    }
}
