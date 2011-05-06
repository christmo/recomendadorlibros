/**
 * @Caso_1: El cliente es nuevo o no ha realizado ninguna compra.
 * Se presentarán los libros del mismo idioma del
 * usuario considerados los más vendidos de la tienda,
 * tomando en cuenta para su selección el calificativo
 * de best-sellers, se recomendará a estos libros como
 * de posible preferencia para el usuario.
 */
package algoritmos;

import BaseDatos.BaseDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import principal.Buscador;

/**
 *
 * @author qmarqeva10
 */
public class Caso1 {

    /**
     *  El cliente es nuevo o no ha realizado ninguna compra.
     *  Se presentarán los libros del mismo idioma que el usuario,
     * tomando en cuenta para su selección el calificativo de best-sellers.
     *
     * @param bd
     * @param limite  Cuantos libros deberá buscar ¿?
     * @param special Se debe considerar el historial de compra del cliente ¿?
     * 
     * @return
     *  [0]=idLibro1 [1]=imgLibro1
     *  [2]=idLibro2 [3]=imgLibro2
     *  [4]=idLibro3 [5]=imgLibro3
    
     */
    public String[] recomendacion3Libros(BaseDatos bd, int limite, boolean special) {
        String partialSql = " AND V1.IDCLIENTE != " + Buscador.sesion[1];
        try {
            String[] dataLibros = new String[6];
            String sql = "  SELECT A.IDLIBRO, B.IMG FROM "
                    + " ( SELECT IDLIBRO, COUNT(IDLIBRO) AS CANT FROM VENTAS "
                    + " WHERE IDLIBRO IN (SELECT V1.IDLIBRO "
                    + " FROM LIBROS L1, VENTAS V1 "
                    + " WHERE L1.IDIDIOMA = " + Buscador.sesion[3]
                    + " AND L1.IDLIBRO = V1.IDLIBRO  ";

            if (special) {
                sql += partialSql;
            }

            sql += " ) "
                    + " GROUP BY IDLIBRO ) A, LIBROS B "
                    + " WHERE A.IDLIBRO = B.IDLIBRO "
                    + " ORDER BY B.BESTSELLER DESC, A.CANT DESC LIMIT "
                    + limite;
            ResultSet rs = bd.ejecutarConsulta(sql);
            int indice = 0;
            while (rs.next()) {
                dataLibros[indice] = rs.getString("IDLIBRO");
                indice++;
                dataLibros[indice] = rs.getString("IMG");
                indice++;

            }
            return dataLibros;
        } catch (SQLException ex) {
            Logger.getLogger(Caso1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
