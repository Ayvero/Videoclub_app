package org.example.controller;

import io.javalin.Javalin;
import org.example.dao.CiudadDAO;
import org.example.dao.DistribuidorDAO;
import org.example.dao.PaisDAO;
import org.example.model.Ciudad;
import org.example.model.Distribuidor;





public class DistribuidorController {
    public static void registrarRutas(Javalin app) {

        app.get("/distribuidores", ctx -> {
            ctx.json(DistribuidorDAO.obtenerTodas());
        });

        app.post("/distribuidores", ctx -> {
            Distribuidor nuevoDistribuidor = ctx.bodyAsClass(Distribuidor.class);
            DistribuidorDAO.agregarDistribuidor(nuevoDistribuidor);
            ctx.status(201);
        });


        app.put("/distribuidores/{id}", ctx -> {
            try {
                int id = Integer.parseInt(ctx.pathParam("id"));
                Distribuidor distribuidorActualizado = ctx.bodyAsClass(Distribuidor.class);
                DistribuidorDAO.actualizarDistribuidor(id, distribuidorActualizado);
                ctx.status(200);
            } catch (RuntimeException e) {
                ctx.status(400).result(e.getMessage());
            }
        });

        app.delete("/distribuidores/{id}", ctx -> {
            try {
                int id = Integer.parseInt(ctx.pathParam("id"));
                DistribuidorDAO.eliminarDistribuidor(id);
                ctx.status(200);
            } catch (RuntimeException e) {
                ctx.status(400).result(e.getMessage());
            }
        });
    }
}








