package org.example.controller;
import io.javalin.Javalin;
import org.example.dao.DepartamentoDAO;
import org.example.model.Departamento;

import java.sql.SQLException;
import java.util.List;

public class DepartamentoController {


        public static void registrarRutas(Javalin app) {
            // Obtener todos los departamentos
            app.get("/departamentos", ctx -> {
                ctx.json(DepartamentoDAO.listarDepartamentos());
            });

            // Crear un nuevo departamento
            app.post("/departamentos", ctx -> {
                Departamento nuevoDepartamento = ctx.bodyAsClass(Departamento.class);
                DepartamentoDAO.agregarDepartamento(nuevoDepartamento);
                ctx.status(201);
            });

            // Actualizar un departamento existente
            app.put("/departamentos/{id_departamento}/{id_distribuidor}", ctx -> {
                try {

                    int idDepartamento = Integer.parseInt(ctx.pathParam("id_departamento"));
                    int idDistribuidor = Integer.parseInt(ctx.pathParam("id_distribuidor"));
                    Departamento departamentoActualizado = ctx.bodyAsClass(Departamento.class);
                    DepartamentoDAO.actualizarDepartamento(idDepartamento,idDistribuidor, departamentoActualizado);
                    ctx.status(200);
                } catch (RuntimeException e) {
                    ctx.status(400).result(e.getMessage());
                }
            });





            // Eliminar un departamento
            app.delete("/departamentos/{id_departamento}/{id_distribuidor}", ctx -> {
                try {
                    int idDepartamento = Integer.parseInt(ctx.pathParam("id_departamento"));
                    int idDistribuidor = Integer.parseInt(ctx.pathParam("id_distribuidor"));

                    DepartamentoDAO.eliminarDepartamento(idDepartamento,idDistribuidor);
                    ctx.status(200);
                } catch (RuntimeException e) {
                    ctx.status(400).result(e.getMessage());
                }
            });

            // Obtener un departamento por idDistribuidor y idDepartamento
            app.get("/departamentos/{id_departamento}/{id_distribuidor}", ctx -> {
                try {

                    int idDepartamento = Integer.parseInt(ctx.pathParam("id_departamento"));
                    int idDistribuidor = Integer.parseInt(ctx.pathParam("id_distribuidor"));

                    Departamento departamento = DepartamentoDAO.obtenerDepartamento(idDepartamento,idDistribuidor);
                    if (departamento != null) {
                        ctx.json(departamento);
                    } else {
                        ctx.status(404).result("Departamento no encontrado");
                    }
                } catch (RuntimeException e) {
                    ctx.status(400).result(e.getMessage());
                }
            });
        }
}

