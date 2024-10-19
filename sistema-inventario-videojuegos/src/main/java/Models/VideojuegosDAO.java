package Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que maneja las operaciones de base de datos para la entidad
 * Videojuegos.
 *
 * @autor seth
 */
public class VideojuegosDAO {

    // Consultas SQL utilizadas en la clase
    private final String SQL_INSERT = "INSERT INTO videojuegos (titulo, plataforma, genero, precio, stock) VALUES (?, ?, ?, ?, ?)";
    private final String SQL_UPDATE = "UPDATE videojuegos SET titulo = ?, plataforma = ?, genero = ?, precio = ?, stock = ? WHERE id = ?";
    private final String SQL_DELETE = "DELETE FROM videojuegos WHERE id = ?";
    private final String SQL_SELECT = "SELECT * FROM videojuegos";
    private final String SQL_SELECTBUSQUEDAID = "SELECT * FROM videojuegos WHERE id = ?";
    private final String SQL_SELECTBUSQUEDANOMBRE = "SELECT * FROM videojuegos WHERE titulo = ?";

    /**
     * Método para insertar un nuevo videojuego en la base de datos.
     *
     * @param videojuego El objeto Videojuegos a insertar
     * @throws SQLException Si ocurre un error al insertar el videojuego
     */
    public void insertarVideojuego(Videojuegos videojuego) throws SQLException {
        Connection conn = null; // Declaramos la conexión
        PreparedStatement stmt = null; // Declaramos el PreparedStatement

        try {
            conn = ConnectionMySQL.getConnection(); // Obtenemos la conexión desde ConnectionMySQL
            stmt = conn.prepareStatement(SQL_INSERT); // Preparamos la consulta SQL para insertar
            // Asignamos los valores a los parámetros de la consulta SQL
            stmt.setString(1, videojuego.getTitulo());
            stmt.setString(2, videojuego.getPlataforma());
            stmt.setString(3, videojuego.getGenero());
            stmt.setDouble(4, videojuego.getPrecio());
            stmt.setInt(5, videojuego.getStock());
            stmt.executeUpdate(); // Ejecutamos la consulta de inserción
        } finally {
            ConnectionMySQL.close(stmt); // Cerramos el PreparedStatement
            ConnectionMySQL.close(conn); // Cerramos la conexión
        }
    }

    /**
     * Método para actualizar un videojuego existente en la base de datos.
     *
     * @param videojuego El objeto Videojuegos a actualizar
     * @throws SQLException Si ocurre un error al actualizar el videojuego
     */
    public void actualizarVideojuego(Videojuegos videojuego) throws SQLException {
        Connection conn = null; // Declaramos la conexión
        PreparedStatement stmt = null; // Declaramos el PreparedStatement

        try {
            conn = ConnectionMySQL.getConnection(); // Obtenemos la conexión desde ConnectionMySQL
            stmt = conn.prepareStatement(SQL_UPDATE); // Preparamos la consulta SQL para actualizar
            // Asignamos los valores a los parámetros de la consulta SQL
            stmt.setString(1, videojuego.getTitulo());
            stmt.setString(2, videojuego.getPlataforma());
            stmt.setString(3, videojuego.getGenero());
            stmt.setDouble(4, videojuego.getPrecio());
            stmt.setInt(5, videojuego.getStock());
            stmt.setInt(6, videojuego.getId());
            stmt.executeUpdate(); // Ejecutamos la consulta de actualización
        } finally {
            ConnectionMySQL.close(stmt); // Cerramos el PreparedStatement
            ConnectionMySQL.close(conn); // Cerramos la conexión
        }
    }

    /**
     * Método para eliminar un videojuego de la base de datos.
     *
     * @param id El ID del videojuego a eliminar
     * @throws SQLException Si ocurre un error al eliminar el videojuego
     */
    public void eliminarVideojuego(int id) throws SQLException {
        Connection conn = null; // Declaramos la conexión
        PreparedStatement stmt = null; // Declaramos el PreparedStatement

        try {
            conn = ConnectionMySQL.getConnection(); // Obtenemos la conexión desde ConnectionMySQL
            stmt = conn.prepareStatement(SQL_DELETE); // Preparamos la consulta SQL para eliminar
            stmt.setInt(1, id); // Asignamos el valor del ID al parámetro de la consulta SQL
            stmt.executeUpdate(); // Ejecutamos la consulta de eliminación
        } finally {
            ConnectionMySQL.close(stmt); // Cerramos el PreparedStatement
            ConnectionMySQL.close(conn); // Cerramos la conexión
        }
    }

    /**
     * Método para obtener un videojuego por su ID.
     *
     * @param id El ID del videojuego a obtener
     * @return El objeto Videojuegos correspondiente al ID
     * @throws SQLException Si ocurre un error al obtener el videojuego
     */
    public Videojuegos obtenerVideojuegoPorId(int id) throws SQLException {
        Videojuegos videojuego = null; // Declaramos el objeto Videojuegos

        Connection conn = null; // Declaramos la conexión
        PreparedStatement stmt = null; // Declaramos el PreparedStatement
        ResultSet rs = null; // Declaramos el ResultSet para obtener los resultados de la consulta

        try {
            conn = ConnectionMySQL.getConnection(); // Obtenemos la conexión desde ConnectionMySQL
            stmt = conn.prepareStatement(SQL_SELECTBUSQUEDAID); // Preparamos la consulta SQL para seleccionar por id
            stmt.setInt(1, id); // Asignamos el valor del ID al parámetro de la consulta SQL
            rs = stmt.executeQuery(); // Ejecutamos la consulta de selección

            // Si se encuentra un resultado, creamos un nuevo objeto Videojuegos con los datos obtenidos
            if (rs.next()) {
                videojuego = new Videojuegos(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("plataforma"),
                        rs.getString("genero"),
                        rs.getDouble("precio"),
                        rs.getInt("stock")
                );
            }
        } finally {
            ConnectionMySQL.close(rs); // Cerramos el ResultSet
            ConnectionMySQL.close(stmt); // Cerramos el PreparedStatement
            ConnectionMySQL.close(conn); // Cerramos la conexión
        }
        return videojuego; // Retornamos el objeto Videojuegos
    }

    /**
     * Método para obtener un videojuego por su ID.
     *
     * @param nombre El nombre del videojuego a obtener
     * @return El la lista de Videojuegos correspondiente al nombre
     * @throws SQLException Si ocurre un error al obtener el videojuego
     */
    public List<Videojuegos> buscarVideojuegosPorTitulo(String titulo) throws SQLException {
        List<Videojuegos> listaVideojuegos = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionMySQL.getConnection();
            stmt = conn.prepareStatement(SQL_SELECTBUSQUEDANOMBRE);
            stmt.setString(1, titulo);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Videojuegos videojuego = new Videojuegos(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("plataforma"),
                        rs.getString("genero"),
                        rs.getDouble("precio"),
                        rs.getInt("stock")
                );
                listaVideojuegos.add(videojuego);
            }
        } finally {
            ConnectionMySQL.close(rs);
            ConnectionMySQL.close(stmt);
            ConnectionMySQL.close(conn);
        }
        return listaVideojuegos;
    }

    /**
     * Método para obtener todos los videojuegos de la base de datos.
     *
     * @return Lista de objetos Videojuegos
     * @throws SQLException Si ocurre un error al obtener los videojuegos
     */
    public List<Videojuegos> obtenerTodosLosVideojuegos() throws SQLException {
        List<Videojuegos> listaVideojuegos = new ArrayList<>(); // Creamos una lista para almacenar los videojuegos

        Connection conn = null; // Declaramos la conexión
        PreparedStatement stmt = null; // Declaramos el PreparedStatement
        ResultSet rs = null; // Declaramos el ResultSet para obtener los resultados de la consulta

        try {
            conn = ConnectionMySQL.getConnection(); // Obtenemos la conexión desde ConnectionMySQL
            stmt = conn.prepareStatement(SQL_SELECT); // Preparamos la consulta SQL para seleccionar todos los videojuegos
            rs = stmt.executeQuery(); // Ejecutamos la consulta de selección

            // Recorremos los resultados obtenidos y los añadimos a la lista de videojuegos
            while (rs.next()) {
                Videojuegos videojuego = new Videojuegos(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("plataforma"),
                        rs.getString("genero"),
                        rs.getDouble("precio"),
                        rs.getInt("stock")
                );
                listaVideojuegos.add(videojuego);
            }
        } finally {
            ConnectionMySQL.close(rs); // Cerramos el ResultSet
            ConnectionMySQL.close(stmt); // Cerramos el PreparedStatement
            ConnectionMySQL.close(conn); // Cerramos la conexión
        }
        return listaVideojuegos; // Retornamos la lista de videojuegos
    }
}
