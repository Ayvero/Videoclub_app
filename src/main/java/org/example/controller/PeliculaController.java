package org.example.controller;



import io.javalin.Javalin;
import org.example.dao.PeliculaDAO;
import org.example.model.Pelicula;

public class PeliculaController {
    public static void registrarRutas(Javalin app) {
        app.get("/peliculas", ctx -> {
            ctx.json(PeliculaDAO.obtenerTodas());
        });

        app.post("/peliculas", ctx -> {
            Pelicula nuevaPelicula = ctx.bodyAsClass(Pelicula.class);
            PeliculaDAO.agregarPelicula(nuevaPelicula);
            ctx.status(201);
        });

        app.put("/peliculas/{id}", ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            Pelicula peliculaActualizada = ctx.bodyAsClass(Pelicula.class);
            PeliculaDAO.actualizarPelicula(id, peliculaActualizada);
            ctx.status(200);
        });

        app.delete("/peliculas/{id}", ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            PeliculaDAO.eliminarPelicula(id);
            ctx.status(200);
        });
    }
}
