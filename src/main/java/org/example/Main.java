package org.example;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import org.example.controller.*;

public class Main {
    public static void main(String[] args) {
        // Obtener el puerto de la variable de entorno 'PORT' o usar 7070 como valor predeterminado
        int port = Integer.parseInt(System.getenv().getOrDefault("PORT", "7070"));

        // Configuración de Javalin
        Javalin app = Javalin.create(config -> {
            config.staticFiles.add("/public", Location.CLASSPATH); // Sirve archivos estáticos desde el directorio '/public'
        }).start(port); // Usar el puerto dinámico

        // Redirige la raíz a 'index.html'
        app.get("/", ctx -> ctx.redirect("/index.html"));

        // Registrar rutas para las entidades
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
