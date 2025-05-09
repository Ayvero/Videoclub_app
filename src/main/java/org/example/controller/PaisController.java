package org.example.controller;
import io.javalin.Javalin;
import org.example.dao.PaisDAO;
import org.example.model.Pais;

import static org.example.dao.PaisDAO.agregarPais;

public class PaisController {
    public static void registrarRutas(Javalin app) {
        app.get("/paises", ctx -> {
            ctx.json(PaisDAO.obtenerTodas());
        });

        app.post("/paises", ctx -> {
            Pais nuevoPais = ctx.bodyAsClass(Pais.class);
            agregarPais(nuevoPais);
            ctx.status(201);
        });

        app.put("/paises/{id}", ctx -> {
            String id = ctx.pathParam("id");
            Pais paisActualizado = ctx.bodyAsClass(Pais.class);
            PaisDAO.actualizarPais(id, paisActualizado);
            ctx.status(200);
        });

        app.delete("/paises/{id}", ctx -> {
            String id = ctx.pathParam("id");
            PaisDAO.eliminarPais(id);
            ctx.status(200);
        });
    }

}
