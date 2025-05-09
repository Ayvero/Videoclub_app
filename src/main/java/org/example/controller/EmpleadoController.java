package org.example.controller;

import io.javalin.Javalin;
import org.example.dao.EmpleadoDAO;
import org.example.model.Empleado;

public class EmpleadoController {
        public static void registrarRutas(Javalin app) {
            app.get("/empleados", ctx -> {
                ctx.json(EmpleadoDAO.obtenerTodas());
            });

            app.post("/empleados", ctx -> {
                Empleado nuevo = ctx.bodyAsClass(Empleado.class);
                EmpleadoDAO.agregar(nuevo);
                ctx.status(201);
            });

            app.put("/empleados/{id}", ctx -> {
                int id = Integer.parseInt(ctx.pathParam("id"));
                Empleado  actualizado = ctx.bodyAsClass(Empleado.class);
                EmpleadoDAO.actualizar(id, actualizado);
                ctx.status(200);
            });

            app.delete("/empleados/{id}", ctx -> {
                int id = Integer.parseInt(ctx.pathParam("id"));
                EmpleadoDAO.eliminar(id);
                ctx.status(200);
            });
        }

    }










