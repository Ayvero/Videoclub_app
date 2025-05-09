package org.example.controller;

import io.javalin.Javalin;
import org.example.dao.InternacionalDAO;
import org.example.dao.NacionalDAO;
import org.example.model.Nacional;


public class NacionalController {

        public static void registrarRutas(Javalin app) {
            app.get("/nacionales", ctx -> {
                ctx.json(NacionalDAO.obtenerTodas());
            });

            app.post("/nacionales", ctx -> {
                Nacional nuevo = ctx.bodyAsClass(Nacional.class);
                NacionalDAO.agregar(nuevo);
                ctx.status(201);
            });

            app.put("/nacionales/{id}", ctx -> {
                Integer id = Integer.valueOf(ctx.pathParam("id"));
                Nacional  actualizado = ctx.bodyAsClass(Nacional.class);
                NacionalDAO.actualizar(id, actualizado);
                ctx.status(200);
            });

            app.delete("/nacionales/{id}", ctx -> {
                Integer id = Integer.valueOf(ctx.pathParam("id"));
                NacionalDAO.eliminar(id);
                ctx.status(200);
            });
        }

    }


