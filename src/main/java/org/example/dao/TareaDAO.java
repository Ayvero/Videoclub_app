package org.example.dao;

import org.example.Database;
import org.example.model.Tarea;
import org.example.model.Video;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TareaDAO {
        public static List<Tarea> obtenerTodas() {
            List<Tarea> lista = new ArrayList<>();

            try (Connection conn = Database.connect()) {

                String sql = "SELECT * FROM tarea";
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    lista.add(new Tarea(
                            rs.getString("id_tarea"),
                            rs.getString("nombre_tarea"),
                            rs.getInt("sueldo_maximo"),
                            rs.getInt("sueldo_minimo")
                          ));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return lista;
        }

        public static void agregar(Tarea tarea) throws SQLException  {
            String sql = "INSERT INTO tarea (id_tarea,nombre_tarea, sueldo_maximo, sueldo_minimo) VALUES (?, ?,?,?)";

            try (Connection conn = Database.connect()) {

                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, tarea.getId_tarea());
                stmt.setString(2, tarea.getNombre_tarea());
                stmt.setInt(3, tarea.getSueldo_maximo());
                stmt.setInt(4, tarea.getSueldo_minimo());
                stmt.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        public static void actualizar(String id, Tarea tarea) {
            String sql = "UPDATE tarea SET nombre_tarea = ?, sueldo_maximo = ? , sueldo_minimo = ?  WHERE  id_tarea= ?";

            try (Connection conn = Database.connect()) {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, tarea.getNombre_tarea());
                stmt.setInt(2, tarea.getSueldo_maximo());
                stmt.setInt(3, tarea.getSueldo_minimo());
                stmt.setString(4, id);


                int filasActualizadas = stmt.executeUpdate();
                System.out.println("Filas actualizadas: " + filasActualizadas);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }




        public static void eliminar(String id) {
            String sql = "DELETE FROM tarea WHERE id_tarea = ?";

            try (Connection conn = Database.connect()) {
                PreparedStatement stmt = conn.prepareStatement(sql);

                stmt.setString(1, id);
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }















