package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pais {

    @JsonProperty("id_pais")
    private String id_pais;

    @JsonProperty("nombre_pais")
    private String nombre_pais;

    // Constructor vacío (importante para Jackson)
    public Pais(String idPais, String nombrePais) {
        this.id_pais = idPais;
        this.nombre_pais = nombrePais;
    }

  public Pais() {}

    // Getters y Setters
    public String getIdPais() {
        return id_pais;
    }

    public void setIdPais(String idPais) {
        this.id_pais = idPais;
    }

    public String getNombrePais() {
        return nombre_pais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombre_pais = nombrePais;
    }
}
