/**
 * @Caso_3: Recomendación basada en la selección de un libro.
 * El usuario podrá visualizar información sobre un
 * determinado libro, luego de realizar una búsqueda,
 * en este caso se recomendará libros de acuerdo a:
 * - Libros que pertenezcan a la misma @categoría del
 *   libro visualizado, basados en la @cantidad de
 *   ventas de los libros y considerando que el
 *   cliente @no posea ya está publicación, tomando
 *   como criterio de ordenación el calificativo de
 *   best-seller.
 *
 * Sino existiesen libros que cumplan con estas condiciones,
 * se tratará la recomendación como el Caso 1, pero
 * considerando que el cliente no posea esos libros.
 *
 **/
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
public class Caso3 {

    public String[] librosCaso3(int idCategoria, BaseDatos bd) {
        try {
            String[] dataLibros = new String[6];
            String sql = " SELECT IDLIBRO, IMG FROM LIBROS WHERE IDCATEGORIA = " + idCategoria + " AND IDLIBRO NOT IN ( " + " SELECT IDLIBRO FROM VENTAS WHERE IDCLIENTE = " + Buscador.sesion[1] + ") LIMIT 3;";
            ResultSet rs = bd.ejecutarConsulta(sql);
            int indice = 0;
            while (rs.next()) {
                dataLibros[indice] = rs.getString("IDLIBRO");
                indice++;
                dataLibros[indice] = rs.getString("IMG");
                indice++;
            }

            //No se encontraron 3 registros.
            //Se completan los libros faltantes.
            if (indice != 6) {  //2 registros
                Caso1 case1 = new Caso1();
                int libF = 0;
                switch (indice) {
                    case 0:
                        libF = 3;
                        break;
                    case 2:
                        libF = 2;
                        break;
                    case 4:
                        libF = 1;
                        break;
                }
                String[] librosFaltantes = case1.recomendacion3Libros(bd, libF, true);
                for (int i = 0; i < libF; i++) {
                    dataLibros[indice] = librosFaltantes[i*2];
                    indice++;
                    dataLibros[indice] = librosFaltantes[(i * 2) + 1];
                    indice++;
                }
            }

            return dataLibros;
        } catch (SQLException ex) {
            Logger.getLogger(Caso3.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
