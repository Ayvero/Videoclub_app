package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

public class Empleado {

        @JsonProperty("id_empleado")
        private Integer id_empleado;

        @JsonProperty("nombre")
        private String nombre;

        @JsonProperty("apellido")
        private String apellido;

        @JsonProperty("porc_comision")
        private Float porc_comision;

        @JsonProperty("sueldo")
        private Integer sueldo;

        @JsonProperty("e_mail")
        private String e_mail;

        @JsonProperty("fecha_nacimiento")
         private Date fecha_nacimiento;

        @JsonProperty("telefono")
        private String telefono;

        @JsonProperty("id_tarea")
        private String id_tarea;

        @JsonProperty("id_departamento")
        private Integer id_departamento;

    @JsonProperty("id_distribuidor")
    private Integer id_distribuidor;

    @JsonProperty("id_jefe")
    private Integer id_jefe;


    // Constructor vacío (importante para Jackson)

    public Empleado() {
    }

    public Empleado(Integer id_empleado, String nombre, String apellido, Float porc_comision, Integer sueldo, String e_mail, Date fecha_nacimiento, String telefono, String id_tarea, Integer id_departamento, Integer id_distribuidor, Integer id_jefe) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.porc_comision = porc_comision;
        this.sueldo = sueldo;
        this.e_mail = e_mail;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.id_tarea = id_tarea;
        this.id_departamento = id_departamento;
        this.id_distribuidor = id_distribuidor;
        this.id_jefe = id_jefe;
    }
    // Getters y Setters


    public Integer getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(Integer id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Float getPorc_comision() {
        return porc_comision;
    }

    public void setPorc_comision(Float porc_comision) {
        this.porc_comision = porc_comision;
    }

    public Integer getSueldo() {
        return sueldo;
    }

    public void setSueldo(Integer sueldo) {
        this.sueldo = sueldo;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(String id_tarea) {
        this.id_tarea = id_tarea;
    }

    public Integer getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(Integer id_departamento) {
        this.id_departamento = id_departamento;
    }

    public Integer getId_distribuidor() {
        return id_distribuidor;
    }

    public void setId_distribuidor(Integer id_distribuidor) {
        this.id_distribuidor = id_distribuidor;
    }

    public Integer getId_jefe() {
        return id_jefe;
    }

    public void setId_jefe(Integer id_jefe) {
        this.id_jefe = id_jefe;
    }
}
