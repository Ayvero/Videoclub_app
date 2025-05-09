package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Nacional {
        @JsonProperty("id_distribuidor")
        private Integer id_distribuidor;

    @JsonProperty("nro_inscripcion")
    private Integer nro_inscripcion;


    @JsonProperty("encargado")
        private String encargado;

    @JsonProperty("id_distrib_mayorista")
    private Integer id_distrib_mayorista;


    // Constructor vacío

    public Nacional() {
    }

    public Nacional(Integer id_distribuidor, Integer nro_inscripcion, String encargado, Integer id_distrib_mayorista) {
        this.id_distribuidor = id_distribuidor;
        this.nro_inscripcion = nro_inscripcion;
        this.encargado = encargado;
        this.id_distrib_mayorista = id_distrib_mayorista;
    }
// Getters y Setters


    public Integer getId_distribuidor() {
        return id_distribuidor;
    }

    public void setId_distribuidor(Integer id_distribuidor) {
        this.id_distribuidor = id_distribuidor;
    }

    public Integer getNro_inscripcion() {
        return nro_inscripcion;
    }

    public void setNro_inscripcion(Integer nro_inscripcion) {
        this.nro_inscripcion = nro_inscripcion;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public Integer getId_distrib_mayorista() {
        return id_distrib_mayorista;
    }

    public void setId_distrib_mayorista(Integer id_distrib_mayorista) {
        this.id_distrib_mayorista = id_distrib_mayorista;
    }
}
