package org.example.controller;

import io.javalin.Javalin;
import org.example.dao.CiudadDAO;
import org.example.model.Ciudad;


public class CiudadController {
    public static void registrarRutas(Javalin app) {
        app.get("/ciudades", ctx -> {
            ctx.json(CiudadDAO.obtenerTodasLasCiudades());
        });

        app.post("/ciudades", ctx -> {
            Ciudad nuevaCiudad = ctx.bodyAsClass(Ciudad.class);
            CiudadDAO.agregarCiudad(nuevaCiudad);
            ctx.status(201);
        });

        app.put("/ciudades/{id}", ctx -> {
            try {
                int id = Integer.parseInt(ctx.pathParam("id"));
                Ciudad ciudadActualizada = ctx.bodyAsClass(Ciudad.class);
                CiudadDAO.actualizarCiudad(id, ciudadActualizada);
                ctx.status(200);
            } catch (RuntimeException e) {
                ctx.status(400).result(e.getMessage());
            }
        });

        app.delete("/ciudades/{id}", ctx -> {
            try {
                int id = Integer.parseInt(ctx.pathParam("id"));
                CiudadDAO.eliminarCiudad(id);
                ctx.status(200);
            } catch (RuntimeException e) {
                ctx.status(400).result(e.getMessage());
            }
        });
    }
}


