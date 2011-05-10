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
import principal.Buscador;

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
            System.out.println("No se pudo completar la consulta...\n" + ex.getMessage());
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
        String sql = "SELECT IDLIBRO "
                + "FROM LIBROS "
                + "WHERE IDCATEGORIA IN ("
                + "SELECT IDCATEGORIA "
                + "FROM CATEGORIAS "
                + "WHERE NOMBRE LIKE '%"+ txtIngresado +"%')";
        ResultSet rsLibros = ejecutarConsulta(sql);
        try {
            while (rsLibros.next()) {
                Libros l = new Libros(rsLibros.getInt("IDLIBRO"), bd);
                librosEncontrados.add(l);
            }
            return librosEncontrados;
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            return null;
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
     * @return ArrayList<Integer>
     */
    public ArrayList<Integer> obtener2CategoriasPreferidasCliente(String idCliente) {
        String sql = "SELECT IDCATEGORIA, COUNT(*) AS SUMA "
                + "FROM VENTAS V, LIBROS L "
                + "WHERE V.IDLIBRO = L.IDLIBRO "
                + "AND IDCLIENTE = " + idCliente
                + " GROUP BY IDCATEGORIA "
                + "ORDER BY SUMA DESC,L.BESTSELLER DESC LIMIT 2";
        ResultSet rsC = ejecutarConsulta(sql);
        ArrayList<Integer> categ = new ArrayList<Integer>();
        try {
            while (rsC.next()) {
                categ.add(rsC.getInt("IDCATEGORIA"));
            }
            return categ;
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categ;
    }

    /**
     * Verifica si el cliente es frecuente
     * (tiene historial de compra) o no.
     * @param idCliente
     * @return true de frecuente o false en caso de ser nuevo.
     */
    public boolean tieneHistorialCompra(int idCliente) {
        String sql = "SELECT COUNT(IDLIBRO) AS CANT FROM VENTAS WHERE IDCLIENTE = " + Buscador.sesion[1] + ";";
        ResultSet rsC = ejecutarConsulta(sql);
        try {

            while (rsC.next()) {
                if (rsC.getInt("CANT") > 0) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Retorna el precio minimo y el precio maximo segun la desviasion estandar
     * que el cliente podria pagar por un libro
     * [0] precio minimo
     * [1] precio maximo
     * @param idCliente
     * @return double[]
     */
    public double[] obtenerRangoPreciosMinMaxCliente(String idCliente) {
        String sql = "SELECT AVG(PRECIO)-STD(PRECIO) AS PMIN,STD(PRECIO)+AVG(PRECIO) AS PMAX "
                + "FROM VENTAS "
                + "WHERE IDCLIENTE = " + idCliente;
        ResultSet rsC = ejecutarConsultaUnDato(sql);
        double[] rango = new double[2];
        try {
            rango[0] = rsC.getDouble("PMIN");
            rango[1] = rsC.getDouble("PMAX");
            return rango;
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rango;
    }

    /**
     * Hace la obtencion de los ids de los libros que pertenecen a una categoria
     * determinada, en esta tambien se hace el filtrado de cuantos resultados
     * se quiere obtener y si se desea tomar en cuenta el rango de precios o no
     * @param idCliente
     * @param idCateg
     * @param idIdioma
     * @param rangoPrecio
     * @param tomarPrecio
     * @param N_Libros
     * @return ArrayList<Integer>
     */
    public ArrayList<Integer> obtenerLibrosCategoriaMasPreferida(String idCliente,
            String idCateg,
            String idIdioma,
            double[] rangoPrecio,
            boolean tomarPrecio,
            int N_Libros) {
        String strSQLini = "SELECT L.IDLIBRO AS LIBRO, COUNT(*) as SUMA "
                + "FROM VENTAS V, LIBROS L "
                + "WHERE V.IDLIBRO = L.IDLIBRO "
                + "AND V.IDLIBRO IN ( "
                + "  SELECT L.IDLIBRO "
                + "  FROM LIBROS L "
                + "  WHERE L.IDCATEGORIA = " + idCateg
                + "  AND L.IDLIBRO NOT IN ( "
                + "    SELECT L.IDLIBRO "
                + "    FROM LIBROS L, VENTAS V "
                + "    WHERE L.IDLIBRO = V.IDLIBRO "
                + "    AND IDCLIENTE = " + idCliente
                + "  ) "
                + ") "
                + "AND L.IDIDIOMA = " + idIdioma + " ";
        if (tomarPrecio) {
            String strPrecioSQL = "AND L.PRECIO BETWEEN " + rangoPrecio[0] + " AND " + rangoPrecio[1] + " ";
            strSQLini += strPrecioSQL;
        }
        String strSQLfin = "GROUP BY L.IDLIBRO "
                + "ORDER BY SUMA DESC, L.BESTSELLER DESC LIMIT " + N_Libros;
        strSQLini += strSQLfin;

        ResultSet rsC = ejecutarConsulta(strSQLini);
        ArrayList<Integer> categ = new ArrayList<Integer>();
        try {
            while (rsC.next()) {
                categ.add(rsC.getInt("LIBRO"));
            }
            return categ;
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categ;
    }

    /**
     * Obtiene el id del idioma de los libros que ha comprado el cliente y saca
     * el que mas se repite en esta lista
     * @param idCliente
     * @return String
     */
    public String obtnerIdIdiomaPreferenciaCliente(String idCliente) {
        String sql = "SELECT L.IDIDIOMA AS IDIDIOMA, COUNT(*) AS SUMA "
                + "FROM LIBROS L, VENTAS V "
                + "WHERE L.IDLIBRO = V.IDLIBRO "
                + "AND V.IDCLIENTE = " + idCliente
                + " GROUP BY L.IDIDIOMA "
                + "ORDER BY SUMA DESC LIMIT 1";
        ResultSet rsC = ejecutarConsultaUnDato(sql);
        String categ = "";
        try {
            categ = rsC.getString("IDIDIOMA");
            return categ;
        } catch (SQLException ex) {
            //Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categ;
    }

    /**
     * Registra la compra realizada por un usuario.
     * @return
     */
    public boolean registrarCompra(int idCliente,
            int idLibro,
            double precio){
        String sql = "INSERT INTO VENTAS (IDCLIENTE, IDLIBRO, PRECIO, FECHA) " +
                " VALUES("+idCliente+","+idLibro+","+precio+",NOW())";
        return this.ejecutarSentencia(sql);
    }
}
