package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class Entrega {

        @JsonProperty("nro_entrega")
        private Integer nro_entrega;

        @JsonProperty("fecha_entrega")
        private java.sql.Date fecha_entrega;




    @JsonProperty("id_video")
        private Integer id_video;

        @JsonProperty("id_distribuidor")
        private Integer id_distribuidor;



    // Constructor vacío (importante para Jackson)

    public Entrega() {
    }

    public Entrega(Integer nro_entrega, java.sql.Date fecha_entrega, Integer id_video, Integer id_distribuidor) {
        this.nro_entrega = nro_entrega;
        this.fecha_entrega = fecha_entrega;
        this.id_video = id_video;
        this.id_distribuidor = id_distribuidor;
    }

    // Getters y Setters


    public Integer getNro_entrega() {
        return nro_entrega;
    }

    public void setNro_entrega(Integer nro_entrega) {
        this.nro_entrega = nro_entrega;
    }

    public java.sql.Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(java.sql.Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public Integer getId_video() {
        return id_video;
    }

    public void setId_video(Integer id_video) {
        this.id_video = id_video;
    }

    public Integer getId_distribuidor() {
        return id_distribuidor;
    }

    public void setId_distribuidor(Integer id_distribuidor) {
        this.id_distribuidor = id_distribuidor;
    }
}
