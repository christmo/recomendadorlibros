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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Libros;

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
    //private ResultSet rs = null;

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
            String sql = "SELECT NOMBRE FROM CATEGORIAS WHERE IDCATEGORIA=" + idCategoria;
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
            String sql = "SELECT IDIOMA FROM IDIOMAS WHERE IDIDIOMA=" + idIdioma;
            ResultSet rsIdioma = ejecutarConsultaUnDato(sql);
            String nombre = rsIdioma.getString("IDIOMA");
            return nombre;
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
            String sql = "SELECT PAIS FROM PAISES WHERE IDPAIS=" + idPais;
            return ejecutarConsultaUnDato(sql).getString("PAIS");
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet obtenerInformacionLibro(int idLibro) {
        String sql = "SELECT "
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
                + "FROM LIBROS "
                + "WHERE IDLIBRO=" + idLibro;
        return ejecutarConsultaUnDato(sql);
    }

    /**
     * Obtiene la lista de libros que se encuentren con un titulo determinado
     * @param txtIngresado
     * @param bd
     * @return ArrayList<Libros>
     */
    public ArrayList<Libros> obtenerLibrosPorTitulo(String txtIngresado, BaseDatos bd) {
        ArrayList<Libros> librosEncontrados = new ArrayList<Libros>();
        String sql = "SELECT "
                + "IDLIBRO "
                + "FROM LIBROS "
                + "WHERE TITULO like '%" + txtIngresado + "%'";
        ResultSet rsLibros = ejecutarConsulta(sql);
        try {
            while (rsLibros.next()) {
                Libros l = new Libros(rsLibros.getInt("IDLIBRO"), bd);
                librosEncontrados.add(l);
            }
            return librosEncontrados;
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Obtiene la lista de libros que se encuenten dentro de una categoria determinada
     * @param txtIngresado
     * @param bd
     * @return ArrayList<Libros>
     */
    public ArrayList<Libros> obtenerLibrosPorCategoria(String txtIngresado, BaseDatos bd) {
        ArrayList<Libros> librosEncontrados = new ArrayList<Libros>();
        String sql = "SELECT "
                + "IDLIBRO "
                + "FROM LIBROS "
                + "WHERE CATEGORIA like '%" + txtIngresado + "%'";
        ResultSet rsLibros = ejecutarConsulta(sql);
        try {
            while (rsLibros.next()) {
                Libros l = new Libros(rsLibros.getInt("IDLIBRO"), bd);
                librosEncontrados.add(l);
            }
            return librosEncontrados;
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Obtiene la lista de libros que dentro de su resumen contenga ciertas
     * palabras clave
     * @param txtIngresado
     * @param bd
     * @return ArrayList<Libros>
     */
    public ArrayList<Libros> obtenerLibrosPorPalabraClave(String txtIngresado, BaseDatos bd) {
        ArrayList<Libros> librosEncontrados = new ArrayList<Libros>();
        String sql = "SELECT "
                + "IDLIBRO "
                + "FROM LIBROS "
                + "WHERE RESUMEN like '%" + txtIngresado + "%'";
        ResultSet rsLibros = ejecutarConsulta(sql);
        try {
            while (rsLibros.next()) {
                Libros l = new Libros(rsLibros.getInt("IDLIBRO"), bd);
                librosEncontrados.add(l);
            }
            return librosEncontrados;
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Obtiene la lista de libros que correspondan a un autor especifico
     * @param txtIngresado
     * @param bd
     * @return ArrayList<Libros>
     */
    public ArrayList<Libros> obtenerLibrosPorAutor(String txtIngresado, BaseDatos bd) {
        ArrayList<Libros> librosEncontrados = new ArrayList<Libros>();
        String sql = "SELECT "
                + "IDLIBRO "
                + "FROM LIBROS "
                + "WHERE AUTOR like '%" + txtIngresado + "%'";
        ResultSet rsLibros = ejecutarConsulta(sql);
        try {
            while (rsLibros.next()) {
                Libros l = new Libros(rsLibros.getInt("IDLIBRO"), bd);
                librosEncontrados.add(l);
            }
            return librosEncontrados;
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Obtiene la lista de libros que se encunetran en un rango de años ingresado
     * @param txtValorInicial
     * @param txtValorFinal
     * @param bd
     * @return ArrayList<Libros>
     */
    public ArrayList<Libros> obtenerLibrosPorAnios(String txtValorInicial, String txtValorFinal, BaseDatos bd) {
        ArrayList<Libros> librosEncontrados = new ArrayList<Libros>();
        String sql = "SELECT "
                + "IDLIBRO "
                + "FROM LIBROS "
                + "WHERE ANIOLANZAMIENTO BETWEEN " + txtValorInicial + " AND " + txtValorFinal;
        ResultSet rsLibros = ejecutarConsulta(sql);
        try {
            while (rsLibros.next()) {
                Libros l = new Libros(rsLibros.getInt("IDLIBRO"), bd);
                librosEncontrados.add(l);
            }
            return librosEncontrados;
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Obtiene la lista de libros que se encuentran en un rango de precios
     * @param txtValorInicial
     * @param txtValorFinal
     * @param bd
     * @return ArrayList<Libros>
     */
    public ArrayList<Libros> obtenerLibrosPorPrecio(String txtValorInicial, String txtValorFinal, BaseDatos bd) {
        ArrayList<Libros> librosEncontrados = new ArrayList<Libros>();
        String sql = "SELECT "
                + "IDLIBRO "
                + "FROM LIBROS "
                + "WHERE PRECIO BETWEEN " + txtValorInicial + " AND " + txtValorFinal;
        ResultSet rsLibros = ejecutarConsulta(sql);
        try {
            while (rsLibros.next()) {
                Libros l = new Libros(rsLibros.getInt("IDLIBRO"), bd);
                librosEncontrados.add(l);
            }
            return librosEncontrados;
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Actualiza el numero de Vistas de un libro
     * @param i numero de vistas
     * @param idLibro
     */
    public void actualizarVistasLibro(int i, int idLibro) {
        String sql = "UPDATE LIBROS SET VISTAS = " + i + " WHERE IDLIBRO=" + idLibro;
        ejecutarSentencia(sql);
    }

    /**
     * Obtiene las dos categorias preferidas por ese cliente
     * @param idCliente
     * @return int[]
     */
    public int[] obtener2CategoriasPreferidasCliente(int idCliente) {
        String sql = "SELECT IDCATEGORIA, COUNT(*) AS SUMA "
                + "FROM VENTAS V, LIBROS L "
                + "WHERE V.IDLIBRO = L.IDLIBRO "
                + "AND IDCLIENTE = "+idCliente
                + " GROUP BY IDCATEGORIA "
                + "ORDER BY SUMA DESC LIMIT 2;";
        ResultSet rsC = ejecutarConsulta(sql);
        int [] categ = null;
        try {
            int i=0;
            while (rsC.next()) {
                categ[i]=rsC.getInt("IDCATEGORIA");
                i++;
            }
            return categ;
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categ;
    }
}
