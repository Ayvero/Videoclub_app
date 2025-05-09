package org.example.dao;

import org.example.Database;
import org.example.model.Renglon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RenglonDAO {



        public static List<Renglon> obtenerTodas() {
            List<Renglon> lista = new ArrayList<>();

            try (Connection conn = Database.connect()) {

                String sql = "SELECT * FROM renglon_entrega";
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    lista.add(new Renglon(
                            rs.getInt("nro_entrega"),
                            rs.getInt("codigo_pelicula"),
                            rs.getInt("cantidad")


                    ));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return lista;
        }

        public static void agregar(Renglon renglon) throws SQLException  {
            String sql = "INSERT INTO renglon_entrega (nro_entrega, codigo_pelicula, cantidad) VALUES (?, ?,?)";

            try (Connection conn = Database.connect()) {

                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, renglon.getNro_entrega());
                stmt.setInt(2, renglon.getCodigo_pelicula());
                stmt.setInt(3, renglon.getCantidad());
                stmt.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        public static void actualizar(Integer id, Renglon renglon) {
            String sql = "UPDATE renglon_entrega SET codigo_pelicula = ?, cantidad = ?  WHERE  nro_entrega= ?";

            try (Connection conn = Database.connect()) {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, renglon.getCodigo_pelicula());
                stmt.setInt(2, renglon.getCantidad());
                stmt.setInt(3, id);


                int filasActualizadas = stmt.executeUpdate();
                System.out.println("Filas actualizadas: " + filasActualizadas);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }




        public static void eliminar(Integer id) {
            String sql = "DELETE FROM renglon_entrega WHERE nro_entrega = ?";

            try (Connection conn = Database.connect()) {
                PreparedStatement stmt = conn.prepareStatement(sql);

                stmt.setInt(1, id);
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }









