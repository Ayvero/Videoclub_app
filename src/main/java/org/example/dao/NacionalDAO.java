package org.example.dao;

import org.example.Database;
import org.example.model.Nacional;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NacionalDAO {
        public static List<Nacional> obtenerTodas() {
            List<Nacional> lista = new ArrayList<>();

            try (Connection conn = Database.connect()) {

                String sql = "SELECT * FROM nacional";
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    lista.add(new Nacional(
                            rs.getInt("id_distribuidor"),
                            rs.getInt("nro_inscripcion"),
                            rs.getString("encargado"),
                            rs.getInt("id_distrib_mayorista")


                    ));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return lista;
        }

        public static void agregar(Nacional nacional) throws SQLException  {
            String sql = "INSERT INTO nacional (id_distribuidor, nro_inscripcion,encargado,id_distrib_mayorista) VALUES (?, ?,?,?)";

            try (Connection conn = Database.connect()) {

                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, nacional.getId_distribuidor());
                stmt.setInt(2, nacional.getNro_inscripcion());
                stmt.setString(3, nacional.getEncargado());
                stmt.setInt(4, nacional.getId_distrib_mayorista());
                stmt.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        public static void actualizar(Integer id, Nacional nacional) {
            String sql = "UPDATE nacional SET nro_inscripcion = ?, encargado=?, id_distrib_mayorista =?  WHERE id_distribuidor = ?";

            try (Connection conn = Database.connect()) {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, nacional.getNro_inscripcion());
                stmt.setString(2, nacional.getEncargado());
                stmt.setInt(3, nacional.getId_distrib_mayorista());
                stmt.setInt(4, id);


                int filasActualizadas = stmt.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }




        public static void eliminar(Integer id) {
            String sql = "DELETE FROM nacional WHERE id_distribuidor = ?";

            try (Connection conn = Database.connect()) {
                PreparedStatement stmt = conn.prepareStatement(sql);

                stmt.setInt(1, id);
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }






