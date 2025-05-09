package org.example.dao;

import org.example.Database;
import org.example.model.Pelicula;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeliculaDAO {

    public static List<Pelicula> obtenerTodas() {
        List<Pelicula> lista = new ArrayList<>();

        try (Connection conn = Database.connect()) {
           // String sql = "SELECT codigo_pelicula, titulo,idioma,formato, genero, codigo_productora FROM pelicula";
            System.out.println("Películas obtenidas: " + lista.size());


            String sql = "SELECT * FROM pelicula";


            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                lista.add(new Pelicula(
                        rs.getInt("codigo_pelicula"),
                        rs.getString("titulo"),
                        rs.getString("idioma"),
                        rs.getString("formato"),
                        rs.getString("genero"),
                        rs.getInt("codigo_productora")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }



    public static void agregarPelicula(Pelicula pelicula) {
        try (Connection conn = Database.connect()) {
            String sql = "INSERT INTO pelicula (titulo, idioma, formato, genero, codigo_productora) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            // ¡Primero seteás los valores!
            stmt.setString(1, pelicula.getTitulo());
            stmt.setString(2, pelicula.getIdioma());
            stmt.setString(3, pelicula.getFormato());
            stmt.setString(4, pelicula.getGenero());
            stmt.setInt(5, pelicula.getCodigo_productora());

            // Luego ejecutás el insert
            stmt.executeUpdate();

            System.out.println("Película agregada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void actualizarPelicula(int id, Pelicula pelicula) {
            String sql = "UPDATE pelicula SET titulo = ?, idioma = ?, formato = ?, genero = ?, codigo_productora = ? WHERE codigo_pelicula = ?";

            try (Connection conn = Database.connect()) {
                PreparedStatement stmt = conn.prepareStatement(sql);


                stmt.setString(1, pelicula.getTitulo());
                stmt.setString(2, pelicula.getIdioma());
                stmt.setString(3, pelicula.getFormato());
                stmt.setString(4, pelicula.getGenero());
                stmt.setInt(5, pelicula.getCodigo_productora());
                stmt.setInt(6, id);



                int filasActualizadas = stmt.executeUpdate();
                System.out.println("Filas actualizadas: " + filasActualizadas);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }




        public static void eliminarPelicula(int id) {
            String sql = "DELETE FROM pelicula WHERE codigo_pelicula = ?";

            try (Connection conn = Database.connect()) {
                PreparedStatement stmt = conn.prepareStatement(sql);

                stmt.setInt(1, id);
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



}

