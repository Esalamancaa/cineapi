package cl.cine.cineapi.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public record UpdatePeliculaRequest(
    @NotBlank(message = "El título no puede estar vacío") String nombrePelicula,
    @NotBlank(message = "El genero no puede estar vacío") String generoPelicula,
    @PositiveOrZero(message = "La fecha de estreno no puede ser negativa ni cero") int fechaEstrenoPelicula,
    @PositiveOrZero(message = "La duración no puede ser negativa ni cero") int duracionPelicula)  
    {
}
