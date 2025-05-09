package org.example.dao;

import org.example.Database;
import org.example.model.Distribuidor;
import org.example.model.Pais;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DistribuidorDAO {


        public static List<Distribuidor> obtenerTodas() {
            List<Distribuidor> lista = new ArrayList<>();

            try (Connection conn = Database.connect()) {
                System.out.println("Distribuidores obtenidos: " + lista.size());


                String sql = "SELECT * FROM distribuidor";


                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    lista.add(new Distribuidor(
                            rs.getInt("id_distribuidor"),
                            rs.getString("nombre"),
                            rs.getString("direccion"),
                            rs.getString("telefono"),
                            rs.getString("tipo")
                    ));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return lista;
        }

        public static void agregarDistribuidor(Distribuidor distribuidor) throws SQLException  {
            String sql = "INSERT INTO distribuidor (id_distribuidor, nombre, direccion, telefono, tipo) VALUES (?, ?,?,?,?)";

            try (Connection conn = Database.connect()) {
                System.out.println("Distribuidor insertado con éxito.");

                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, distribuidor.getId_distribuidor());
                stmt.setString(2, distribuidor.getNombre());
                stmt.setString(3, distribuidor.getDireccion());
                stmt.setString(4, distribuidor.getTelefono());
                stmt.setString(5, distribuidor.getTipo());


                stmt.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        public static void actualizarDistribuidor(Integer id, Distribuidor distribuidor) {
            String sql = "UPDATE distribuidor SET nombre = ?, direccion = ?,telefono = ?, tipo  = ? WHERE id_distribuidor = ?";

            try (Connection conn = Database.connect()) {
                PreparedStatement stmt = conn.prepareStatement(sql);


                stmt.setString(1, distribuidor.getNombre());
                stmt.setString(2, distribuidor.getDireccion());
                stmt.setString(3, distribuidor.getTelefono());
                stmt.setString(4, distribuidor.getTipo());
                stmt.setInt(5, id);



                int filasActualizadas = stmt.executeUpdate();
                System.out.println("Filas actualizadas: " + filasActualizadas);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }




        public static void eliminarDistribuidor(Integer id) {
            String sql = "DELETE FROM distribuidor WHERE id_distribuidor = ?";

            try (Connection conn = Database.connect()) {
                PreparedStatement stmt = conn.prepareStatement(sql);

                stmt.setInt(1, id);
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


