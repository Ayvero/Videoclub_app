package org.example.controller;

import io.javalin.Javalin;
import org.example.dao.EntregaDAO;
import org.example.model.Entrega;


public class EntregaController {
        public static void registrarRutas(Javalin app) {
            app.get("/entregas", ctx -> {
                ctx.json(EntregaDAO.obtenerTodas());
            });

            app.post("/entregas", ctx -> {
                Entrega nuevo = ctx.bodyAsClass(Entrega.class);
                EntregaDAO.agregar(nuevo);
                ctx.status(201);
            });

            app.put("/entregas/{id}", ctx -> {
                Integer id = Integer.valueOf(ctx.pathParam("id"));
                Entrega  actualizado = ctx.bodyAsClass(Entrega.class);
                EntregaDAO.actualizar(id, actualizado);
                ctx.status(200);
            });

            app.delete("/entregas/{id}", ctx -> {
                Integer id = Integer.valueOf(ctx.pathParam("id"));
                EntregaDAO.eliminar(id);
                ctx.status(200);
            });
        }

    }






