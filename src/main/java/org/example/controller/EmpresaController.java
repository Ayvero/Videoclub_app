package org.example.controller;

import io.javalin.Javalin;
import org.example.dao.EmpresaProdDAO;
import org.example.dao.PaisDAO;
import org.example.model.EmpresaProductora;




public class EmpresaController {

        public static void registrarRutas(Javalin app) {
            app.get("/productoras", ctx -> {
                ctx.json(EmpresaProdDAO.obtenerTodas());
            });

            app.post("/productoras", ctx -> {
                EmpresaProductora nuevoEmpresa = ctx.bodyAsClass(EmpresaProductora.class);
                EmpresaProdDAO.agregarEmpresa(nuevoEmpresa);
                ctx.status(201);
            });

            app.put("/productoras/{id}", ctx -> {
                String id = ctx.pathParam("id");
                EmpresaProductora empresaActualizada = ctx.bodyAsClass(EmpresaProductora.class);
                EmpresaProdDAO.actualizarEmpresa(id, empresaActualizada);
                ctx.status(200);
            });

            app.delete("/productoras/{id}", ctx -> {
                String id = ctx.pathParam("id");
                EmpresaProdDAO.eliminarEmpresa(id);
                ctx.status(200);
            });
        }

    }


