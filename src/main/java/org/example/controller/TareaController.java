package org.example.controller;

import io.javalin.Javalin;
import org.example.dao.TareaDAO;
import org.example.model.Tarea;

public class TareaController {
        public static void registrarRutas(Javalin app) {
            app.get("/tareas", ctx -> {
                ctx.json(TareaDAO.obtenerTodas());
            });

            app.post("/tareas", ctx -> {
                Tarea nuevo = ctx.bodyAsClass(Tarea.class);
                TareaDAO.agregar(nuevo);
                ctx.status(201);
            });

            app.put("/tareas/{id}", ctx -> {
                String id = ctx.pathParam("id");
                Tarea  actualizado = ctx.bodyAsClass(Tarea.class);
                TareaDAO.actualizar(id, actualizado);
                ctx.status(200);
            });

            app.delete("/tareas/{id}", ctx -> {
                String id = ctx.pathParam("id");
                TareaDAO.eliminar(id);
                ctx.status(200);
            });
        }

    }








