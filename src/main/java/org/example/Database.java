package org.example;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    //coneccion a postgresql

    //private static final String URL = "jdbc:postgresql://localhost:5432/peliculas_db";
   // private static final String USER = "postgres";
   // private static final String PASSWORD = "Peluche10";

    //coneccion a supabase

    //jdbc:postgresql://db.wxqbzlomnfohdcrmomwg.supabase.co:5432/postgres?user=postgres&password=[YOUR-PASSWORD]


    private static final String URL = "jdbc:postgresql://wxqbzlomnfohdcrmomwg.supabase.co:5432/postgres?sslmode=require";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Esponjita10"; // Reemplaza esto con tu contraseña real de Supabase



    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
