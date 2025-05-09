package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmpresaProductora {

        @JsonProperty("codigo_productora")
        private String codigo_productora;

        @JsonProperty("nombre_productora")
        private String nombre_productora;

    @JsonProperty("id_ciudad")
    private Integer id_ciudad;


    // Constructor vacío (importante para Jackson)


    public EmpresaProductora() {
    }

    public EmpresaProductora(String codigo_productora, String nombre_productora, Integer id_ciudad) {
        this.codigo_productora = codigo_productora;
        this.nombre_productora = nombre_productora;
        this.id_ciudad = id_ciudad;
    }

    // Getters y Setters


    public String getCodigo_productora() {
        return codigo_productora;
    }

    public void setCodigo_productora(String codigo_productora) {
        this.codigo_productora = codigo_productora;
    }

    public String getNombre_productora() {
        return nombre_productora;
    }

    public void setNombre_productora(String nombre_productora) {
        this.nombre_productora = nombre_productora;
    }

    public Integer getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(Integer id_ciudad) {
        this.id_ciudad = id_ciudad;
    }
}



