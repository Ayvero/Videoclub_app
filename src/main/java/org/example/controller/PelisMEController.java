package org.example.controller;

import io.javalin.Javalin;
import org.example.dao.PelisEntregadasDAO;
import org.example.model.PelisMasEntregadas;

public class PelisMEController {

        public static void registrarRutas(Javalin app) {
            app.get("/entregadas", ctx -> {
                ctx.json(PelisEntregadasDAO.obtenerTodas());
            });

            app.post("/entregadas", ctx -> {
                PelisMasEntregadas nuevo = ctx.bodyAsClass(PelisMasEntregadas.class);
                PelisEntregadasDAO.agregar(nuevo);
                ctx.status(201);
            });

            app.put("/entregadas/{id}", ctx -> {
                Integer id = Integer.valueOf(ctx.pathParam("id"));
                PelisMasEntregadas  actualizado = ctx.bodyAsClass(PelisMasEntregadas.class);
                PelisEntregadasDAO.actualizar(id, actualizado);
                ctx.status(200);
            });

            app.delete("/entregadas/{id}", ctx -> {
                Integer id = Integer.valueOf(ctx.pathParam("id"));
                PelisEntregadasDAO.eliminar(id);
                ctx.status(200);
            });
        }

    }


