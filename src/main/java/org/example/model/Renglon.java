package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Renglon {


        @JsonProperty("nro_entrega")
        private Integer nro_entrega;

    @JsonProperty("codigo_pelicula")
    private Integer codigo_pelicula;



        @JsonProperty("cantidad")
        private Integer cantidad;


        // Constructor vacío (importante para Jackson)

    public Renglon() {
    }

    public Renglon(Integer nro_entrega, Integer codigo_pelicula, Integer cantidad) {
        this.nro_entrega = nro_entrega;
        this.codigo_pelicula = codigo_pelicula;
        this.cantidad = cantidad;
    }
// Getters y Setters


    public Integer getNro_entrega() {
        return nro_entrega;
    }

    public void setNro_entrega(Integer nro_entrega) {
        this.nro_entrega = nro_entrega;
    }

    public Integer getCodigo_pelicula() {
        return codigo_pelicula;
    }

    public void setCodigo_pelicula(Integer codigo_pelicula) {
        this.codigo_pelicula = codigo_pelicula;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
