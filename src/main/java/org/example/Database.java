package org.example;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    //coneccion a postgresql

    private static final String URL = "jdbc:postgresql://localhost:5432/peliculas_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Peluche10";

    //coneccion a supabase
    //https://wxqbzlomnfohdcrmomwg.supabase.co
    //apikey:
    //eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Ind4cWJ6bG9tbmZvaGRjcm1vbXdnIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDc2OTIxNTEsImV4cCI6MjA2MzI2ODE1MX0.mFdYOMVX1pTyZ0wBYn-m3Q3gbhs3TOYJIcymVyiRWu8

    //jdbc:postgresql://db.wxqbzlomnfohdcrmomwg.supabase.co:5432/postgres?user=postgres&password=[YOUR-PASSWORD]


  //  private static final String URL = "jdbc:postgresql://db.wxqbzlomnfohdcrmomwg.supabase.co:5432/postgres?sslmode=require";

   // private static final String USER = "postgres";
   // private static final String PASSWORD = "PelucheyEsponjita"; // Reemplaza esto con tu contraseña real de Supabase



    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
