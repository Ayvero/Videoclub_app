package org.example;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import org.example.controller.*;

public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.staticFiles.add("/public", Location.CLASSPATH);
        }).start(7070);

        app.get("/", ctx -> ctx.redirect("/index.html"));

        PeliculaController.registrarRutas(app);
        CiudadController.registrarRutas(app);
        DepartamentoController.registrarRutas(app);
        PaisController.registrarRutas(app);
        DistribuidorController.registrarRutas(app);
        EmpresaController.registrarRutas(app);
        InternacionalController.registrarRutas(app);
        NacionalController.registrarRutas(app);
        PelisMEController.registrarRutas(app);
        RenglonController.registrarRutas(app);
        EntregaController.registrarRutas(app);
        VideoController.registrarRutas(app);
        TareaController.registrarRutas(app);
        EmpleadoController.registrarRutas(app);

    }
}











