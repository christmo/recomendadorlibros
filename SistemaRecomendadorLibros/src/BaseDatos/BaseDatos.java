/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kradac
 */
public class BaseDatos {

    private Connection conexion;
    /**
     * Nombre de la Base de datos
     */
    private String bd = "recomendador";
    private String ip = "localhost";
    private String usr = "root";
    private String pass = "";
    private ResultSet rs = null;

    public BaseDatos() {
        ConexionBase();
    }

    /**
     * Crea una conexion a cualquier base de datos mysql, con parametros
     * de conexion indepenientes
     * @param ip - IP del servidor
     * @param bd - Nombre de la Base de datos
     * @param usr -  Nombre de Usuario
     * @param pass - Clave de la Base de datos
     */
    private void ConexionBase() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://" + ip + "/" + bd;
        try {
            try {
                Class.forName(driver).newInstance();
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conexion = DriverManager.getConnection(url, usr, pass);
        } catch (SQLException ex) {
            System.out.println("No se puede obtener la conexion...");
        }

        System.out.println("Conexion a Base de Datos OK: " + bd);
    }

    /**
     * Ejecuta una consulta en la base de datos, que devuelve valores
     * es necesario recorrer el resultset
     * @param sql - debe ser Select
     * @return ResultSet
     */
    public ResultSet ejecutarConsulta(String sql) {
        ResultSet r = null;
        try {
            Statement stat = (Statement) conexion.createStatement();
            r = stat.executeQuery(sql);
            System.out.println("SQL:" + sql);
        } catch (SQLException ex) {
            System.out.println("No se pudo completar la consulta...");
        } catch (NullPointerException ex) {
        }
        return r;
    }

    /**
     * Ejecuta una consulta en la base de datos, que devuelve valores
     * no es necesario recorrer el resultset
     * @param sql - debe ser Select
     * @return ResultSet
     */
    public ResultSet ejecutarConsultaUnDato(String sql) {
        ResultSet rsCUD = null;
        try {
            Statement sta = (Statement) conexion.createStatement();
            rsCUD = sta.executeQuery(sql);
            System.out.println("SQL:" + sql);
            rsCUD.next();
        } catch (SQLException ex) {
            System.out.println("No se pudo completar la consulta...");
        }
        return rsCUD;
    }

    /**
     * Ejecuta una sentencia en la base esta puede ser de INSERT, UPDATE O
     * DELETE
     * @param sql - Sentencias INSERT, UPDATE, DELETE
     * @return int - confirmacion del resultado 1 valido || 0 invalido
     */
    public boolean ejecutarSentencia(String sql) {
        try {
            Statement st = (Statement) conexion.createStatement();

            System.out.println("Ejecutar: " + sql);

            int rta = st.executeUpdate(sql);
            if (rta >= 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo completar la ejecución...");
            return false;
        } catch (NullPointerException ex) {
            return false;
        }
    }

    /**
     * Cierra la conexion con la base de datos
     * @return Connection
     * @throws SQLException
     */
    public void CerrarConexion() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("No se pudo completar el cierre de la BD...");
        } catch (NullPointerException ex) {
            System.out.println("NO está abierta la base de datos...");
        }
    }

    /**
     * Obtiene el nombre del Autor según el id de este, null si no
     * encuentra nada
     * @param idAutor
     * @return String
     */
    public String obtenerNombreAutor(int idAutor) {
        try {
            String sql = "SELECT NOMBRE FROM AUTORES WHERE IDAUTOR=" + idAutor;
            return ejecutarConsultaUnDato(sql).getString("NOMBRE");
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Obtiene el nombre de la categoria segun el id que se le envie, null si no
     * encuentra nada
     * @param idCategoria
     * @return String
     */
    public String obtenerNombreCategoria(int idCategoria) {
        try {
            String sql = "SELECT NOMBRE FROM AUTORES WHERE IDCATEGORIA=" + idCategoria;
            return ejecutarConsultaUnDato(sql).getString("NOMBRE");
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Se obtiene el idioma a partir del id
     * retorna null si no hay valores
     * @param idIdioma
     * @return String
     */
    public String obtenerNombreIdioma(int idIdioma) {
        try {
            String sql = "SELECT IDIOMA FROM AUTORES WHERE IDIDIOMA=" + idIdioma;
            return ejecutarConsultaUnDato(sql).getString("IDIOMA");
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Se obtiene el NOMBRE DEL PAIS a partir del id
     * retorna null si no hay valores
     * @param idPais
     * @return String
     */
    public String obtenerNombrePais(int idPais) {
        try {
            String sql = "SELECT PAIS FROM AUTORES WHERE IDPAIS=" + idPais;
            return ejecutarConsultaUnDato(sql).getString("PAIS");
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet obtenerInformacionLibro(int idLibro) {
        String sql ="SELECT "
                + "IDLIBRO,"
                + "TITULO,"
                + "PRECIO,"
                + "RESUMEN,"
                + "EDITORIAL,"
                + "BESTSELLER,"
                + "IDIDIOMA,"
                + "IDPAIS,"
                + "VISTAS,"
                + "ANIOLANZAMIENTO,"
                + "IDCATEGORIA,"
                + "IDAUTOR,"
                + "IMG "
                + "FROM LIBROS ;";
        return ejecutarConsultaUnDato(sql);
    }
}
