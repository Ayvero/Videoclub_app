package org.example.dao;
import org.example.model.Ciudad;
import org.example.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CiudadDAO {

    // Insertar una nueva ciudad
    public static void agregarCiudad(Ciudad ciudad) {
        String sql = "INSERT INTO ciudad (id_ciudad, nombre_ciudad, id_pais) VALUES (?, ?, ?)";

        try (Connection conn = Database.connect()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ciudad.getId_ciudad());
            stmt.setString(2, ciudad.getNombre_ciudad());
            stmt.setString(3, ciudad.getId_pais());

            stmt.executeUpdate();
            System.out.println("Ciudad insertada con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Obtener todas las ciudades
    public static List<Ciudad> obtenerTodasLasCiudades() {
        List<Ciudad> lista = new ArrayList<>();
        String sql = "SELECT * FROM ciudad";

        try (Connection conn = Database.connect()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Ciudad ciudad = new Ciudad(
                        rs.getInt("id_ciudad"),
                        rs.getString("nombre_ciudad"),
                        rs.getString("id_pais")
                );
                lista.add(ciudad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Actualizar ciudad por ID
    public static void actualizarCiudad(int id, Ciudad ciudad) {
        String sql = "UPDATE ciudad SET nombre_ciudad = ?, id_pais = ? WHERE id_ciudad = ?";

        try (Connection conn = Database.connect()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, ciudad.getNombre_ciudad());
            stmt.setString(2, ciudad.getId_pais());
            stmt.setInt(3, id);

            int filas = stmt.executeUpdate();
            System.out.println("Filas actualizadas: " + filas);

        }catch (SQLException e) {
        if (e.getMessage().contains("violates foreign key constraint")) {
            throw new RuntimeException("No se puede actualizar la ciudad porque está siendo utilizada por una empresa productora.");
        } else {
            throw new RuntimeException("Error al actualizar la ciudad: " + e.getMessage());
        }
    }


}


    // Eliminar ciudad por ID

    public static void eliminarCiudad(int id) {
        String sql = "DELETE FROM ciudad WHERE id_ciudad = ?";

        try (Connection conn = Database.connect()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            int filas = stmt.executeUpdate();
            System.out.println("Filas eliminadas: " + filas);

        } catch (SQLException e) {
            if (e.getMessage().contains("violates foreign key constraint")) {
                throw new RuntimeException("No se puede eliminar la ciudad porque está siendo utilizada por una empresa productora.");
            } else {
                throw new RuntimeException("Error al eliminar la ciudad: " + e.getMessage());
            }
        }
    }

}
