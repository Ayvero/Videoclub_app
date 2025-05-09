package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PelisMasEntregadas {


        @JsonProperty("codigo_pelicula")
        private Integer codigo_pelicula;

        @JsonProperty("titulo")
        private String titulo;

    @JsonProperty("cantidad_de_entregas")
    private Integer cantidad_de_entregas;


    // Constructor vacío (importante para Jackson)

    public PelisMasEntregadas() {
    }

    public PelisMasEntregadas(Integer codigo_pelicula, String titulo, Integer cantidad_de_entregas) {
        this.codigo_pelicula = codigo_pelicula;
        this.titulo = titulo;
        this.cantidad_de_entregas = cantidad_de_entregas;
    }
// Getters y Setters


    public Integer getCodigo_pelicula() {
        return codigo_pelicula;
    }

    public void setCodigo_pelicula(Integer codigo_pelicula) {
        this.codigo_pelicula = codigo_pelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getCantidad_de_entregas() {
        return cantidad_de_entregas;
    }

    public void setCantidad_de_entregas(Integer cantidad_de_entregas) {
        this.cantidad_de_entregas = cantidad_de_entregas;
    }
}
