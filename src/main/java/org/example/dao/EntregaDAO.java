package org.example.dao;

import org.example.Database;
import org.example.model.Entrega;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntregaDAO {

        public static List<Entrega> obtenerTodas() {
            List<Entrega> lista = new ArrayList<>();

            try (Connection conn = Database.connect()) {

                String sql = "SELECT * FROM entrega";
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    lista.add(new Entrega(
                            rs.getInt("nro_entrega"),
                            rs.getDate("fecha_entrega"),
                            rs.getInt("id_video"),
                            rs.getInt("id_distribuidor")
                    ));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return lista;
        }

        public static void agregar(Entrega entrega) throws SQLException  {
            String sql = "INSERT INTO entrega (nro_entrega, fecha_entrega, id_video, id_distribuidor) VALUES (?, ?,?,?)";

            try (Connection conn = Database.connect()) {

                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, entrega.getNro_entrega());
                stmt.setDate(2, entrega.getFecha_entrega());
                stmt.setInt(3, entrega.getId_video());
                stmt.setInt(4, entrega.getId_distribuidor());
                stmt.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        public static void actualizar(Integer id, Entrega entrega) {
            String sql = "UPDATE entrega SET fecha_entrega = ?, id_video = ? , id_distribuidor = ?  WHERE  nro_entrega= ?";

            try (Connection conn = Database.connect()) {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setDate(1, entrega.getFecha_entrega());
                stmt.setInt(2, entrega.getId_video());
                stmt.setInt(3, entrega.getId_distribuidor());
                stmt.setInt(4, id);


                int filasActualizadas = stmt.executeUpdate();
                System.out.println("Filas actualizadas: " + filasActualizadas);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }




        public static void eliminar(Integer id) {
            String sql = "DELETE FROM entrega WHERE nro_entrega = ?";

            try (Connection conn = Database.connect()) {
                PreparedStatement stmt = conn.prepareStatement(sql);

                stmt.setInt(1, id);
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }











