package org.example.dao;

import org.example.Database;
import org.example.model.Internacional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InternacionalDAO {

        public static List<Internacional> obtenerTodas() {
            List<Internacional> lista = new ArrayList<>();

            try (Connection conn = Database.connect()) {

                String sql = "SELECT * FROM internacional";
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    lista.add(new Internacional(
                            rs.getInt("id_distribuidor"),
                            rs.getString("codigo_pais")


                    ));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return lista;
        }

        public static void agregarInternacional(Internacional internacional) throws SQLException  {
            String sql = "INSERT INTO internacional (id_distribuidor, codigo_pais) VALUES (?, ?)";

            try (Connection conn = Database.connect()) {

                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, internacional.getId_distribuidor());
                stmt.setString(2, internacional.getCodigo_pais());
                stmt.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        public static void actualizarInternacional(Integer id, Internacional internacional) {
            String sql = "UPDATE internacional SET codigo_pais = ?  WHERE id_distribuidor = ?";

            try (Connection conn = Database.connect()) {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, internacional.getCodigo_pais());
                stmt.setInt(2, id);


                int filasActualizadas = stmt.executeUpdate();
                System.out.println("Filas actualizadas: " + filasActualizadas);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }




        public static void eliminarInternacional(Integer id) {
            String sql = "DELETE FROM internacional WHERE id_distribuidor = ?";

            try (Connection conn = Database.connect()) {
                PreparedStatement stmt = conn.prepareStatement(sql);

                stmt.setInt(1, id);
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }




