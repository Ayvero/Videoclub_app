package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tarea {
        @JsonProperty("id_tarea")
        private String id_tarea;

        @JsonProperty("nombre_tarea")
        private String nombre_tarea;

        @JsonProperty("sueldo_maximo")
        private Integer sueldo_maximo;

        @JsonProperty("sueldo_minimo")
        private Integer sueldo_minimo;




        // Constructor vacío (importante para Jackson)

    public Tarea() {
    }

    public Tarea(String id_tarea, String nombre_tarea, Integer sueldo_maximo, Integer sueldo_minimo) {
        this.id_tarea = id_tarea;
        this.nombre_tarea = nombre_tarea;
        this.sueldo_maximo = sueldo_maximo;
        this.sueldo_minimo = sueldo_minimo;
    }
    // Getters y Setters


    public String getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(String id_tarea) {
        this.id_tarea = id_tarea;
    }

    public String getNombre_tarea() {
        return nombre_tarea;
    }

    public void setNombre_tarea(String nombre_tarea) {
        this.nombre_tarea = nombre_tarea;
    }

    public Integer getSueldo_maximo() {
        return sueldo_maximo;
    }

    public void setSueldo_maximo(Integer sueldo_maximo) {
        this.sueldo_maximo = sueldo_maximo;
    }

    public Integer getSueldo_minimo() {
        return sueldo_minimo;
    }

    public void setSueldo_minimo(Integer sueldo_minimo) {
        this.sueldo_minimo = sueldo_minimo;
    }
}
