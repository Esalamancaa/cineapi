package cl.cine.cineapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "peliculas")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombrePelicula", nullable = false, length = 120)
    private String nombrePelicula;

    @Column(name = "generoPelicula", nullable = false, length = 60)
    private String generoPelicula;

    @Column(name = "fechaEstrenoPelicula", nullable = false)
    private int fechaEstrenoPelicula;

    @Column(name = "duracionPelicula", nullable = false)
    private int duracionPelicula;

    
    public Pelicula(){}

    public Pelicula(int id, String nombrePelicula, String generoPelicula, int fechaEstrenoPelicula,
            int duracionPelicula) {
        this.id = id;
        this.nombrePelicula = nombrePelicula;
        this.generoPelicula = generoPelicula;
        this.fechaEstrenoPelicula = fechaEstrenoPelicula;
        this.duracionPelicula = duracionPelicula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public String getGeneroPelicula() {
        return generoPelicula;
    }

    public void setGeneroPelicula(String generoPelicula) {
        this.generoPelicula = generoPelicula;
    }

    public int getFechaEstrenoPelicula() {
        return fechaEstrenoPelicula;
    }

    public void setFechaEstrenoPelicula(int fechaEstrenoPelicula) {
        this.fechaEstrenoPelicula = fechaEstrenoPelicula;
    }

    public int getDuracionPelicula() {
        return duracionPelicula;
    }

    public void setDuracionPelicula(int duracionPelicula) {
        this.duracionPelicula = duracionPelicula;
    }

    

}