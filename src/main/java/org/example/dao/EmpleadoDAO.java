package org.example.dao;

import org.example.Database;
import org.example.model.Empleado;
import org.example.model.Tarea;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {
        public static List<Empleado> obtenerTodas() {
            List<Empleado> lista = new ArrayList<>();

            try (Connection conn = Database.connect()) {

                String sql = "SELECT * FROM empleado";
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    lista.add(new Empleado(
                            rs.getInt("id_empleado"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getFloat("porc_comision"),
                            rs.getInt("sueldo"),
                            rs.getString("e_mail"),
                            rs.getDate("fecha_nacimiento"),
                            rs.getString("telefono"),
                            rs.getString("id_tarea"),
                            rs.getInt("id_departamento"),
                            rs.getInt("id_distribuidor"),
                            rs.getInt("id_jefe")
                    ));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return lista;
        }

        public static void agregar(Empleado empleado) throws SQLException  {
            String sql = "INSERT INTO empleado (id_empleado,nombre, apellido,porc_comision, sueldo,e_mail, fecha_nacimiento,telefono, id_tarea, id_departamento,id_distribuidor, id_jefe) VALUES (?, ?,?,?,?,?,?,?,?,?,?,?)";

            try (Connection conn = Database.connect()) {

                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, empleado.getId_empleado());
                stmt.setString(2, empleado.getNombre());
                stmt.setString(3, empleado.getApellido());
                stmt.setFloat(4, empleado.getPorc_comision());
                stmt.setInt(5, empleado.getSueldo());
                stmt.setString(6, empleado.getE_mail());
                stmt.setDate(7, empleado.getFecha_nacimiento());
                stmt.setString(8, empleado.getTelefono());
                stmt.setString(9, empleado.getId_tarea());
                stmt.setInt(10, empleado.getId_departamento());
                stmt.setInt(11, empleado.getId_distribuidor());
                stmt.setInt(12, empleado.getId_jefe());


                stmt.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        public static void actualizar(Integer id, Empleado empleado) {
            String sql = "UPDATE empleado SET nombre = ?, apellido = ? , porc_comision = ?,sueldo = ?,e_mail  = ? , fecha_nacimiento = ?,telefono = ?, id_tarea = ? , id_departamento = ?, id_distribuidor= ? , id_jefe = ? WHERE  id_empleado = ?";

            try (Connection conn = Database.connect()) {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, empleado.getNombre());
                stmt.setString(2, empleado.getApellido());
                stmt.setFloat(3, empleado.getPorc_comision());
                stmt.setInt(4, empleado.getSueldo());
                stmt.setString(5, empleado.getE_mail());
                stmt.setDate(6, empleado.getFecha_nacimiento());
                stmt.setString(7, empleado.getTelefono());
                stmt.setString(8, empleado.getId_tarea());
                stmt.setInt(9, empleado.getId_departamento());
                stmt.setInt(10, empleado.getId_distribuidor());
                stmt.setInt(11, empleado.getId_jefe());

                stmt.setInt(12, id);


                int filasActualizadas = stmt.executeUpdate();
                System.out.println("Filas actualizadas: " + filasActualizadas);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }




        public static void eliminar(Integer id) {
            String sql = "DELETE FROM tarea WHERE id_empleado = ?";

            try (Connection conn = Database.connect()) {
                PreparedStatement stmt = conn.prepareStatement(sql);

                stmt.setInt(1, id);
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

















