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
    private String idIdiomaCliente;
    /**
     * Almacena los libros a presentar
     */
    private ArrayList<Libros> Libros = new ArrayList<Libros>();

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
        idIdiomaCliente = bd.obtnerIdIdiomaPreferenciaCliente(Buscador.sesion[1]);
    }

    /**
     * Obtiene las dos categorias que el cliente compra mas libros
     * @param idCliente
     * @return int[] dos categorias más comprada por el ciente
     */
    private ArrayList<Integer> obtener2CategoriasPreferidasCliente(String idCliente) {
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
        ArrayList<Integer> libros3 = new ArrayList<Integer>(); // para obtener ids de 3 libros
        ArrayList<Integer> catg = obtener2CategoriasPreferidasCliente(idCliente);
        double[] precios = obtenerRangoPreciosMinMaxCliente(idCliente);
        if (catg.size() == 2) {
            ArrayList<Integer> libros2 = bd.obtenerLibrosCategoriaMasPreferida(idCliente,
                    "" + catg.get(0),
                    idIdiomaCliente,
                    precios,
                    true,
                    2);

            if (libros2.size() == 2) {
                llenarListaLibros(libros2);
            } else {
                libros2 = bd.obtenerLibrosCategoriaMasPreferida(idCliente,
                        "" + catg.get(0),
                        idIdiomaCliente,
                        precios,
                        false, 2);
                if (!libros2.isEmpty()) {
                    llenarListaLibros(libros2);
                }
            }

            ArrayList<Integer> libros1 = bd.obtenerLibrosCategoriaMasPreferida(idCliente,
                    "" + catg.get(1),
                    idIdiomaCliente,
                    precios,
                    true,
                    1);

            if (!libros1.isEmpty()) {
                llenarListaLibros(libros1);
            } else {
                libros1 = bd.obtenerLibrosCategoriaMasPreferida(idCliente,
                        "" + catg.get(1),
                        idIdiomaCliente,
                        precios,
                        false,
                        1);
                if (!libros1.isEmpty()) {
                    llenarListaLibros(libros1);
                }
            }
        } else if (catg.size() == 1) {
            libros3 = bd.obtenerLibrosCategoriaMasPreferida(idCliente,
                    "" + catg.get(0),
                    idIdiomaCliente,
                    precios,
                    true, 3);
            if (libros3.size() == 3) {
                llenarListaLibros(libros3);
            } else {
                libros3 = bd.obtenerLibrosCategoriaMasPreferida(idCliente,
                        "" + catg.get(0),
                        idIdiomaCliente,
                        precios,
                        false, 3);
                if (!libros3.isEmpty()) {
                    llenarListaLibros(libros3);
                }
            }
        }
        if (Libros.size() != 3) {
            Caso1 caso1 = new Caso1();
            String[] info = caso1.recomendacion3Libros(bd,3, false);
            if (Libros.size() == 1) {
                libros3.add(Integer.parseInt(info[0]));
                libros3.add(Integer.parseInt(info[2]));
            } else if (Libros.size() == 2) {
                libros3.add(Integer.parseInt(info[0]));
            } else if (Libros.isEmpty()) {
                libros3.add(Integer.parseInt(info[0]));
                libros3.add(Integer.parseInt(info[2]));
                libros3.add(Integer.parseInt(info[4]));
            }
            llenarListaLibros(libros3);
        }
        return Libros;
    }

    /**
     * Llena el arreglo con la informacion de los libros
     * @param libros
     * @return ArrayList<Libros>
     */
    private void llenarListaLibros(ArrayList<Integer> libros) {
        for (int idLibro : libros) {
            Libros.add(new Libros(idLibro, bd));
        }
    }
}
