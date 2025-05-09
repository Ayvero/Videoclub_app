package org.example.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Departamento {

    @JsonProperty("id_departamento")
    private Integer id_departamento;

    @JsonProperty("id_distribuidor")
    private Integer id_distribuidor;

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("calle")
    private String calle;

    @JsonProperty("numero")
    private Integer numero;

    @JsonProperty("id_ciudad")
    private Integer id_ciudad;

    @JsonProperty("jefe_departamento")
    private Integer jefe_departamento;

    // Constructor con parámetros
    public Departamento(Integer id_departamento, Integer id_distribuidor, String nombre, String calle,
                        Integer numero, Integer id_ciudad, Integer jefe_departamento) {
        this.id_departamento = id_departamento;
        this.id_distribuidor = id_distribuidor;
        this.nombre = nombre;
        this.calle = calle;
        this.numero = numero;
        this.id_ciudad = id_ciudad;
        this.jefe_departamento = jefe_departamento;
    }

    // Constructor vacío
    public Departamento() {
    }

    // Getters y Setters
    public Integer getIdDepartamento() {
        return id_departamento;
    }

    public void setIdDepartamento(Integer id_departamento) {
        this.id_departamento = id_departamento;
    }

    public Integer getIdDistribuidor() {
        return id_distribuidor;
    }

    public void setIdDistribuidor(Integer id_distribuidor) {
        this.id_distribuidor = id_distribuidor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getIdCiudad() {
        return id_ciudad;
    }

    public void setIdCiudad(Integer id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public Integer getJefeDepartamento() {
        return jefe_departamento;
    }

    public void setJefeDepartamento(Integer jefe_departamento) {
        this.jefe_departamento = jefe_departamento;
    }
}
