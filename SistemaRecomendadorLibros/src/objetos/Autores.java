/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import BaseDatos.BaseDatos;

/**
 *
 * @author kradac
 */
public class Autores {

    private int idAutor;
    private String nombre;

    public Autores(int idAutor, String nombre) {
        this.idAutor = idAutor;
        this.nombre = nombre;
    }

    /**
     * Se carga el nombre del autor enviandole el ID del autor.
     * @param idAutor
     * @param bd
     */
    public Autores(int idAutor, BaseDatos bd) {
        this.idAutor = idAutor;
        this.nombre = bd.obtenerNombreAutor(idAutor);
    }

    /**
     * @return the idAutor
     */
    public int getIdAutor() {
        return idAutor;
    }

    /**
     * @param idAutor the idAutor to set
     */
    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
