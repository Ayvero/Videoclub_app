package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Usuario {

    @JsonProperty("nombre_usuario")
    private String nombre_usuario;

    @JsonProperty("contrasena")
    private String contrasena;

    @JsonProperty("rol")
    private String rol;

    public Usuario() {
    }

    public Usuario(String nombre_usuario, String contrasena, String rol) {
        this.nombre_usuario = nombre_usuario;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
