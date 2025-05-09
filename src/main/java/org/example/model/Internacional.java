package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Internacional {

        @JsonProperty("id_distribuidor")
        private Integer id_distribuidor;

        @JsonProperty("codigo_pais")
        private String codigo_pais;

        // Constructor vacío (importante para Jackson)


    public Internacional() {
    }

    public Internacional(Integer id_distribuidor, String codigo_pais) {
        this.id_distribuidor = id_distribuidor;
        this.codigo_pais = codigo_pais;
    }

    // Getters y Setters


    public Integer getId_distribuidor() {
        return id_distribuidor;
    }

    public void setId_distribuidor(Integer id_distribuidor) {
        this.id_distribuidor = id_distribuidor;
    }

    public String getCodigo_pais() {
        return codigo_pais;
    }

    public void setCodigo_pais(String codigo_pais) {
        this.codigo_pais = codigo_pais;
    }
}
