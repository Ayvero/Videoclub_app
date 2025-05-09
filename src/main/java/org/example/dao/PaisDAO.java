package org.example.dao;
import org.example.Database;
import org.example.model.Ciudad;
import org.example.model.Pais;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaisDAO {

        public static List<Pais> obtenerTodas() {
            List<Pais> lista = new ArrayList<>();

            try (Connection conn = Database.connect()) {
                System.out.println("Paises obtenidos: " + lista.size());


                String sql = "SELECT * FROM pais";


                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    lista.add(new Pais(
                            rs.getString("id_pais"),
                            rs.getString("nombre_pais")
                           ));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return lista;
        }

    public static void agregarPais(Pais pais) throws SQLException  {
        String sql = "INSERT INTO pais (id_pais, nombre_pais) VALUES (?, ?)";

        try (Connection conn = Database.connect()) {
            System.out.println("Ciudad insertada con éxito.");

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, pais.getIdPais());
            stmt.setString(2, pais.getNombrePais());


            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

/*
        public static void agregarPais(Pais pais) {

            String sql = "INSERT INTO pais (id_pais,nombre_pais) VALUES (?, ?)";

            try (Connection conn = Database.connect()) {
                PreparedStatement stmt = conn.prepareStatement(sql);

                // ¡Primero seteás los valores!
                stmt.setString(1, pais.getIdPais());
                stmt.setString(2, pais.getNombrePais());

                // Luego ejecutás el insert
                stmt.executeUpdate();

                System.out.println("Pais agregado correctamente.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

*/
        public static void actualizarPais(String id, Pais pais) {
            String sql = "UPDATE pais SET nombre_pais = ? WHERE id_pais = ?";

            try (Connection conn = Database.connect()) {
                PreparedStatement stmt = conn.prepareStatement(sql);


                stmt.setString(1, pais.getNombrePais());
                stmt.setString(2, id);



                int filasActualizadas = stmt.executeUpdate();
                System.out.println("Filas actualizadas: " + filasActualizadas);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }




        public static void eliminarPais(String id) {
            String sql = "DELETE FROM pais WHERE id_pais = ?";

            try (Connection conn = Database.connect()) {
                PreparedStatement stmt = conn.prepareStatement(sql);

                stmt.setString(1, id);
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

}
