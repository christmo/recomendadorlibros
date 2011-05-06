/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import BaseDatos.BaseDatos;
import java.util.ArrayList;
import objetos.Libros;
import principal.Buscador;

/**
 *
 * @author kradac
 */
public class Caso2 {

    private BaseDatos bd;
    private String idIdiomaCliente = Buscador.sesion[3];

    /**
     * Caso 2: El cliente tiene al menos una compra.
     * En este caso se considera que el cliente ya ha realizado interacción con
     * el sistema por tanto, se recomendará en base a lo siguiente:
     *
     * -Se seleccionarán dos categorías más preferidas por el usuario (en caso
     * de no existir el sistema solo trabajará con una)
     * -Se extraerá un rango de precios que el cliente estaria dispuesto a pagar,
     * mediante la extracción de la desviación estandar de todos los precios de
     * los libros que ha comprado el usuario.
     * -El idioma del cliente será el más utilizado dentro de las dos categorías
     * seleccionadas.
     *
     * A partir de estos datos se procederá a:
     *
     * -Extraer 2 y 1 (libros más vendidos de esas categorias) libros por las
     * categorías primera y segunda extraídas respectivamente.
     * -Extraer los libros de la categoría e idioma, que el cliente no haya
     * comprado todavía y que estén dentro del rango de precios determinado
     * anteriormente.
     * -Los libros serán seleccionados tomando en consideración el número de
     * ventas y el calificativo de best-sellers.
     * -En caso de no existir libros de estas características, se omitirá la
     * verificación de precios, si luego de esto tampoco existiese libros se
     * brindará recomendaciones en base al Caso 1.
     * @param bd
     */
    public Caso2(BaseDatos bd) {
        this.bd = bd;
    }

    /**
     * Obtiene las dos categorias que el cliente compra mas libros
     * @param idCliente
     * @return int[] dos categorias más comprada por el ciente
     */
    private int[] obtener2CategoriasPreferidasCliente(String idCliente) {
        return bd.obtener2CategoriasPreferidasCliente(idCliente);
    }

    /**
     * Obtiene el rango de precios minimo y maximo que un cliente podria preferir
     * pagar
     * [0] Precio minimo
     * [1] Precio maximo
     * @param idCliente
     * @return double[]
     */
    private double[] obtenerRangoPreciosMinMaxCliente(String idCliente) {
        return bd.obtenerRangoPreciosMinMaxCliente(idCliente);
    }
    

    public ArrayList<Libros> obtenerLibrosRecomendadosClienteHistorial(String idCliente) {
        ArrayList<Libros> Libros = new ArrayList<Libros>();
        int[] catg = obtener2CategoriasPreferidasCliente(idCliente);
        double[] precios = obtenerRangoPreciosMinMaxCliente(idCliente);

        int[] libros2 = bd.obtener2LibrosCategoriaMasPreferida(idCliente,
                "" + catg[0],
                idIdiomaCliente,
                precios);

        int libros1 = bd.obtener1LibroCategoriaMenosPreferida(idCliente,
                "" + catg[1],
                idIdiomaCliente,
                precios);
        
        Libros.add(new Libros(libros2[0], bd));
        Libros.add(new Libros(libros2[1], bd));
        Libros.add(new Libros(libros1, bd));

        return Libros;
    }
}
