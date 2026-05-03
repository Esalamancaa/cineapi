package cl.cine.cineapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.cine.cineapi.dto.CreatePeliculaRequest;
import cl.cine.cineapi.dto.UpdatePeliculaRequest;
import cl.cine.cineapi.exception.ResourceNotFoundException;
import cl.cine.cineapi.mapper.PeliculaMapper;
import cl.cine.cineapi.model.Pelicula;
import cl.cine.cineapi.service.PeliculaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/cine")
public class PeliculaController {
    
    private final PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    // Obtener todas las peliculas registradas

    @GetMapping
    public ResponseEntity<List<Pelicula>> listarPeliculas(){
        List<Pelicula> peliculas = peliculaService.getPeliculas();
        return ResponseEntity.ok(peliculas);
    }

    // Obtener pelicula por su id

    @GetMapping("/{id}")
    public ResponseEntity<Pelicula> buscarPelicula(@PathVariable int id){
        Pelicula pelicula = peliculaService.getPeliculaId(id);

        if(pelicula==null){
            throw new ResourceNotFoundException("ID no corresponde a una pelicula");
        }
        return ResponseEntity.ok(pelicula);
    }

    // Obtener pelicula por su genero

    @GetMapping("/genero/{genero}")
    public List<Pelicula> listarPeliculaGenero(@PathVariable String generoPelicula){
        return peliculaService.getPeliculaByGenero(generoPelicula);
    }

    // Agregar peliculas

    @PostMapping
    public ResponseEntity<Pelicula> agregarPelicula(@Valid @RequestBody CreatePeliculaRequest request){
        Pelicula pelicula = peliculaService.savePelicula(PeliculaMapper.toModel(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(pelicula);
    }

    // Actualizar pelicula por ID

    @PutMapping("{id}")
    public ResponseEntity<Pelicula> actualizarPelicula(@PathVariable int id, @Valid @RequestBody UpdatePeliculaRequest request){
        Pelicula peliculaActualizar = peliculaService.updatePelicula(PeliculaMapper.toModel(id,request));
        return ResponseEntity.ok(peliculaActualizar);
    }

    // Eliminar pelicula por ID

    @DeleteMapping("{id}")
    public ResponseEntity<Void> eliminarPelicula(@PathVariable int id){
        peliculaService.deletePelicula(id);
        return ResponseEntity.noContent().build();
    }
}
