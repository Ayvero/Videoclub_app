package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ciudad {

    @JsonProperty("id_ciudad")
    public int id_ciudad;



    @JsonProperty("nombre_ciudad")
    public String nombre_ciudad;

    @JsonProperty("id_pais")
    public String id_pais;



    public Ciudad(int id_ciudad, String nombre_ciudad, String id_pais) {
        this.id_ciudad = id_ciudad;
        this.nombre_ciudad = nombre_ciudad;
        this.id_pais = id_pais;

    }

    public Ciudad() {}


    public String getId_pais() {
        return id_pais;
    }

    public int getId_ciudad() {
        return id_ciudad;
    }
    public String getNombre_ciudad() {
        return nombre_ciudad;
    }

    public void setId_ciudad(int id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public void setNombre_ciudad(String nombre_ciudad) {
        this.nombre_ciudad = nombre_ciudad;
    }
    public void setId_pais(String id_pais) {
        this.id_pais = id_pais;
    }


}
