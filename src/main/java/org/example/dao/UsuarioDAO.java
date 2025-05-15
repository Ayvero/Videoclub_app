package org.example.dao;


import org.example.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

    public class UsuarioDAO {

        public static boolean validarCredenciales(String nombre_usuario, String contrasena) {

            String sql = "SELECT * FROM usuarios WHERE nombre_usuario = ? AND contrasena = ?";

            try (Connection conn = Database.connect()) {

                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, nombre_usuario);
                stmt.setString(2, contrasena); // En producción: nunca guardar contraseñas en texto plano

                ResultSet rs = stmt.executeQuery();
                return rs.next(); // Devuelve true si encontró un usuario válido

            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }


