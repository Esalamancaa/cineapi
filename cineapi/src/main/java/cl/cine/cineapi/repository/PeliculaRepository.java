package cl.cine.cineapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cl.cine.cineapi.model.Pelicula;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Integer>{

    default int totalPeliculas(){
        return (int) this.count();
    }

    @Query(value = "SELECT * FROM peliculas WHERE generoPelicula = :genero", nativeQuery = true)
    List <Pelicula> findByGenero(@Param("genero") String genero);

}
