package org.example.controller;

import io.javalin.Javalin;
import org.example.dao.EmpresaProdDAO;
import org.example.dao.InternacionalDAO;
import org.example.model.EmpresaProductora;
import org.example.model.Internacional;

public class InternacionalController {

        public static void registrarRutas(Javalin app) {
            app.get("/internacionales", ctx -> {
                ctx.json(InternacionalDAO.obtenerTodas());
            });

            app.post("/internacionales", ctx -> {
                Internacional nuevoInternacional = ctx.bodyAsClass(Internacional.class);
                InternacionalDAO.agregarInternacional(nuevoInternacional);
                ctx.status(201);
            });

            app.put("/internacionales/{id}", ctx -> {
                Integer id = Integer.valueOf(ctx.pathParam("id"));
                Internacional  internacionalActualizado = ctx.bodyAsClass(Internacional.class);
                InternacionalDAO.actualizarInternacional(id, internacionalActualizado);
                ctx.status(200);
            });

            app.delete("/internacionales/{id}", ctx -> {
                Integer id = Integer.valueOf(ctx.pathParam("id"));
                InternacionalDAO.eliminarInternacional(id);
                ctx.status(200);
            });
        }

}
