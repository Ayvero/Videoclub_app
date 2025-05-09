package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Video {


    @JsonProperty("id_video")
    private Integer id_video;

    @JsonProperty("razon_social")
        private String razon_social;

    @JsonProperty("direccion")
    private String direccion;

        @JsonProperty("telefono")
        private String telefono;

    @JsonProperty("propietario")
    private String propietario;



        // Constructor vacío (importante para Jackson)

    public Video() {
    }

    public Video(Integer id_video, String razon_social, String direccion, String telefono, String propietario) {
        this.id_video = id_video;
        this.razon_social = razon_social;
        this.direccion = direccion;
        this.telefono = telefono;
        this.propietario = propietario;
    }
// Getters y Setters


    public Integer getId_video() {
        return id_video;
    }

    public void setId_video(Integer id_video) {
        this.id_video = id_video;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
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

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
}
