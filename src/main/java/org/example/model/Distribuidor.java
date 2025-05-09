package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Distribuidor {



        @JsonProperty("id_distribuidor")
        private Integer id_distribuidor;

        @JsonProperty("nombre")
        private String nombre;

        @JsonProperty("direccion")
        private String direccion;

        @JsonProperty("telefono")
         private String telefono;

        @JsonProperty("tipo")
        private String tipo;

        // Constructor vacío (importante para Jackson)


    public Distribuidor() {
    }

    public Distribuidor(Integer id_distribuidor, String nombre, String direccion, String telefono, String tipo) {
        this.id_distribuidor = id_distribuidor;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipo = tipo;
    }

    // Getters y Setters

    public Integer getId_distribuidor() {
        return id_distribuidor;
    }

    public void setId_distribuidor(Integer id_distribuidor) {
        this.id_distribuidor = id_distribuidor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
