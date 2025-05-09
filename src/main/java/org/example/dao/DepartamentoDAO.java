



package org.example.dao;
import org.example.model.Departamento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.example.Database;

public class DepartamentoDAO {



    public static List<Departamento> listarDepartamentos() throws SQLException {
        List<Departamento> lista = new ArrayList<>();
        String sql = "SELECT * FROM departamento";

        try (Connection conn = Database.connect()){
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Departamento d = new Departamento(
                rs.getInt("id_departamento"),
                        rs.getInt("id_distribuidor"),
                        rs.getString("nombre"),
                        rs.getString("calle"),
                        rs.getInt("numero"),
                        rs.getInt("id_ciudad"),
                        rs.getInt("jefe_departamento")
                );
                lista.add(d);
            }
        }

        return lista;
    }

    public static void agregarDepartamento(Departamento d) throws SQLException {
        String sql = "INSERT INTO departamento (id_departamento, id_distribuidor, nombre, calle, numero, id_ciudad, jefe_departamento) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Database.connect()) {
            PreparedStatement stmt = conn.prepareStatement(sql);


            stmt.setInt(1, d.getIdDepartamento());
            stmt.setInt(2, d.getIdDistribuidor());
            stmt.setString(3, d.getNombre());
            stmt.setString(4, d.getCalle());
            stmt.setInt(5, d.getNumero());
            stmt.setInt(6, d.getIdCiudad());
            stmt.setInt(7, d.getJefeDepartamento());
            stmt.executeUpdate();
        }
    }

    public static void actualizarDepartamento(int id_depart, int id_dist, Departamento d) throws SQLException {
        String sql = "UPDATE departamento SET nombre = ?, calle = ?, numero = ?, id_ciudad = ?, jefe_departamento = ? WHERE  id_departamento  = ? AND id_distribuidor = ?";

        try (Connection conn = Database.connect()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, d.getNombre());
            stmt.setString(2, d.getCalle());
            stmt.setInt(3, d.getNumero());
            stmt.setInt(4, d.getIdCiudad());
            stmt.setInt(5, d.getJefeDepartamento());
            stmt.setInt(6, d.getIdDepartamento());
            stmt.setInt(7, d.getIdDistribuidor());

            int filasActualizadas = stmt.executeUpdate();
            if (filasActualizadas == 0) {
                throw new SQLException("No se encontró el departamento para actualizar.");
            }
        }
    }

    public static void eliminarDepartamento( int idDepartamento ,int idDistribuidor) throws SQLException {
        String sql = "DELETE FROM departamento WHERE  id_departamento = ? AND id_distribuidor = ?";

        try (Connection conn = Database.connect()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idDepartamento);
            stmt.setInt(2, idDistribuidor);

            int filasEliminadas = stmt.executeUpdate();
            if (filasEliminadas == 0) {
                throw new SQLException("No se encontró el departamento para eliminar.");
            }
        } catch (SQLException e) {
            if (e.getSQLState().equals("23503")) { // Violación de clave foránea
                throw new SQLException("No se puede eliminar el departamento porque está relacionado con otras entidades.", e);
            } else {
                throw e;
            }
        }
    }

    public static Departamento obtenerDepartamento(int idDepartamento ,int idDistribuidor) throws SQLException {
        String sql = "SELECT * FROM departamento WHERE  id_departamento = ? AND  id_distribuidor = ?";

        try (Connection conn = Database.connect()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idDepartamento);
            stmt.setInt(2, idDistribuidor);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Departamento d = new Departamento();
                    d.setIdDepartamento(rs.getInt("id_departamento"));
                    d.setIdDistribuidor(rs.getInt("id_distribuidor"));
                    d.setNombre(rs.getString("nombre"));
                    d.setCalle(rs.getString("calle"));
                    d.setNumero(rs.getInt("numero"));
                    d.setIdCiudad(rs.getInt("id_ciudad"));
                    d.setJefeDepartamento(rs.getInt("jefe_departamento"));
                    return d;
                }
            }
        }
        return null;
    }
}

