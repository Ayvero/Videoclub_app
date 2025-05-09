package org.example.controller;

import io.javalin.Javalin;

import org.example.dao.VideoDAO;
import org.example.model.Video;

public class VideoController {

        public static void registrarRutas(Javalin app) {
            app.get("/videos", ctx -> {
                ctx.json(VideoDAO.obtenerTodas());
            });

            app.post("/videos", ctx -> {
                Video nuevo = ctx.bodyAsClass(Video.class);
                VideoDAO.agregar(nuevo);
                ctx.status(201);
            });

            app.put("/videos/{id}", ctx -> {
                Integer id = Integer.valueOf(ctx.pathParam("id"));
                Video  actualizado = ctx.bodyAsClass(Video.class);
                VideoDAO.actualizar(id, actualizado);
                ctx.status(200);
            });

            app.delete("/videos/{id}", ctx -> {
                Integer id = Integer.valueOf(ctx.pathParam("id"));
                VideoDAO.eliminar(id);
                ctx.status(200);
            });
        }

    }






