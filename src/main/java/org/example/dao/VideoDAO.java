package org.example.dao;

import org.example.Database;
import org.example.model.Entrega;
import org.example.model.Video;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VideoDAO {


        public static List<Video> obtenerTodas() {
            List<Video> lista = new ArrayList<>();

            try (Connection conn = Database.connect()) {

                String sql = "SELECT * FROM video";
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    lista.add(new Video(
                            rs.getInt("id_video"),
                            rs.getString("razon_social"),
                            rs.getString("direccion"),
                            rs.getString("telefono"),
                            rs.getString("propietario")
                    ));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return lista;
        }

        public static void agregar(Video video) throws SQLException  {
            String sql = "INSERT INTO video (id_video,razon_social,direccion, telefono, propietario) VALUES (?, ?,?,?,?)";

            try (Connection conn = Database.connect()) {

                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, video.getId_video());
                stmt.setString(2, video.getRazon_social());
                stmt.setString(3, video.getDireccion());
                stmt.setString(4, video.getTelefono());
                stmt.setString(5, video.getPropietario());
                stmt.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        public static void actualizar(Integer id, Video video) {
            String sql = "UPDATE video SET razon_social = ?, direccion = ? , telefono = ? , propietario = ?  WHERE  id_video = ?";

            try (Connection conn = Database.connect()) {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, video.getRazon_social());
                stmt.setString(2, video.getDireccion());
                stmt.setString(3, video.getTelefono());
                stmt.setString(4, video.getPropietario());
                stmt.setInt(5, id);


                int filasActualizadas = stmt.executeUpdate();
                System.out.println("Filas actualizadas: " + filasActualizadas);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }




        public static void eliminar(Integer id) {
            String sql = "DELETE FROM video WHERE id_video = ?";

            try (Connection conn = Database.connect()) {
                PreparedStatement stmt = conn.prepareStatement(sql);

                stmt.setInt(1, id);
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }













