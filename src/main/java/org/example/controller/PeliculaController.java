package org.example.controller;



import io.javalin.Javalin;
import org.example.dao.PeliculaDAO;
import org.example.model.Pelicula;

import java.util.List;

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

        app.get("/peliculas/filtrar-genero", ctx -> {
            String genero = ctx.queryParam("genero");
            if (genero == null || genero.isEmpty()) {
                ctx.status(400).result("Falta el parámetro 'genero'");
                return;
            }
            ctx.json(PeliculaDAO.buscarPorGenero(genero));
        });


        app.get("/peliculas/filtrar", ctx -> {
            String campo = ctx.queryParam("campo");
            String valor = ctx.queryParam("valor");

            // Validamos campos permitidos
            List<String> camposValidos = List.of("titulo", "idioma", "formato", "genero");

            if (!camposValidos.contains(campo)) {
                ctx.status(400).result("Campo no válido");
                return;
            }

            ctx.json(PeliculaDAO.filtrarPorCampo(campo, valor));
        });


    }

}
