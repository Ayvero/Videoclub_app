package org.example.controller;

import io.javalin.Javalin;
import org.example.dao.RenglonDAO;
import org.example.model.Renglon;

public class RenglonController {

        public static void registrarRutas(Javalin app) {
            app.get("/renglones", ctx -> {
                ctx.json(RenglonDAO.obtenerTodas());
            });

            app.post("/renglones", ctx -> {
                Renglon nuevo = ctx.bodyAsClass(Renglon.class);
                RenglonDAO.agregar(nuevo);
                ctx.status(201);
            });

            app.put("/renglones/{id}", ctx -> {
                Integer id = Integer.valueOf(ctx.pathParam("id"));
                Renglon  actualizado = ctx.bodyAsClass(Renglon.class);
                RenglonDAO.actualizar(id, actualizado);
                ctx.status(200);
            });

            app.delete("/renglones/{id}", ctx -> {
                Integer id = Integer.valueOf(ctx.pathParam("id"));
                RenglonDAO.eliminar(id);
                ctx.status(200);
            });
        }

    }




