package org.example.controller;

import io.javalin.http.Context;
import org.example.dao.UsuarioDAO;
import org.example.model.Usuario;
import java.util.HashMap;
import java.util.Map;

public class UsuarioController {

    public static void login(Context ctx) {
        Usuario usuario = ctx.bodyAsClass(Usuario.class);

        boolean valido = UsuarioDAO.validarCredenciales(
                usuario.getNombre_usuario(),
                usuario.getContrasena()
        );

        Map<String, Object> respuesta = new HashMap<>();

        if (valido) {
            respuesta.put("success", true);
            respuesta.put("message", "Login exitoso");
            ctx.status(200).json(respuesta);
        } else {
            respuesta.put("success", false);
            respuesta.put("message", "Credenciales inválidas");
            ctx.status(401).json(respuesta);
        }
    }
}
