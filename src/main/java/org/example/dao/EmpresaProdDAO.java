package org.example.dao;

import org.example.Database;
import org.example.model.EmpresaProductora;
import org.example.model.Pais;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpresaProdDAO {


        public static List<EmpresaProductora> obtenerTodas() {
            List<EmpresaProductora> lista = new ArrayList<>();

            try (Connection conn = Database.connect()) {

                String sql = "SELECT * FROM empresa_productora";
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    lista.add(new EmpresaProductora(
                            rs.getString("codigo_productora"),
                            rs.getString("nombre_productora"),
                            rs.getInt("id_ciudad")

                    ));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return lista;
        }

        public static void agregarEmpresa(EmpresaProductora empresa) throws SQLException  {
            String sql = "INSERT INTO empresa_productora (codigo_productora, nombre_productora,id_ciudad) VALUES (?, ?,?)";

            try (Connection conn = Database.connect()) {

                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, empresa.getCodigo_productora());
                stmt.setString(2, empresa.getNombre_productora());
                stmt.setInt(3, empresa.getId_ciudad());
                stmt.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        public static void actualizarEmpresa(String id, EmpresaProductora empresa) {
            String sql = "UPDATE empresa_productora SET nombre_productora = ? , id_ciudad = ?  WHERE codigo_productora = ?";

            try (Connection conn = Database.connect()) {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, empresa.getNombre_productora());
                stmt.setInt(2, empresa.getId_ciudad());
                stmt.setString(3, id);

                int filasActualizadas = stmt.executeUpdate();
                System.out.println("Filas actualizadas: " + filasActualizadas);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }




        public static void eliminarEmpresa(String id) {
            String sql = "DELETE FROM empresa_productora WHERE codigo_productora = ?";

            try (Connection conn = Database.connect()) {
                PreparedStatement stmt = conn.prepareStatement(sql);

                stmt.setString(1, id);
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


