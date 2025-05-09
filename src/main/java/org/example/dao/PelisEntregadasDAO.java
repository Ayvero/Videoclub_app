package org.example.dao;

import org.example.Database;
import org.example.model.PelisMasEntregadas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PelisEntregadasDAO {


        public static List<PelisMasEntregadas> obtenerTodas() {
            List<PelisMasEntregadas> lista = new ArrayList<>();

            try (Connection conn = Database.connect()) {

                String sql = "SELECT * FROM pelis_mas_entragadas";
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    lista.add(new PelisMasEntregadas(
                            rs.getInt("codigo_pelicula"),
                            rs.getString("titulo"),
                            rs.getInt("cantidad_de_entregas")


                    ));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return lista;
        }

        public static void agregar(PelisMasEntregadas pelis) throws SQLException  {
            String sql = "INSERT INTO pelis_mas_entragadas (codigo_pelicula, titulo, cantidad_de_entregas) VALUES (?, ?,?)";

            try (Connection conn = Database.connect()) {

                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, pelis.getCodigo_pelicula());
                stmt.setString(2, pelis.getTitulo());
                stmt.setInt(3, pelis.getCantidad_de_entregas());
                stmt.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        public static void actualizar(Integer id, PelisMasEntregadas pelis) {
            String sql = "UPDATE pelis_mas_entragadas SET titulo = ?, cantidad_de_entregas = ?  WHERE  codigo_pelicula = ?";

            try (Connection conn = Database.connect()) {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, pelis.getTitulo());
                stmt.setInt(2, pelis.getCantidad_de_entregas());
                stmt.setInt(3, id);


                int filasActualizadas = stmt.executeUpdate();
                System.out.println("Filas actualizadas: " + filasActualizadas);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }




        public static void eliminar(Integer id) {
            String sql = "DELETE FROM pelis_mas_entragadas WHERE codigo_pelicula = ?";

            try (Connection conn = Database.connect()) {
                PreparedStatement stmt = conn.prepareStatement(sql);

                stmt.setInt(1, id);
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }






