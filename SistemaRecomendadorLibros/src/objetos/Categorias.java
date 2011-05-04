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
public class Categorias {

    private int idCategoria;
    private String categoria;

    public Categorias(int idCategoria, String categoria) {
        this.idCategoria = idCategoria;
        this.categoria = categoria;
    }

    /**
     * Se carga el nombre al enviarle el ID de la categoria
     * @param idCategoria
     * @param bd
     */
    public Categorias(int idCategoria,BaseDatos bd) {
        this.idCategoria = idCategoria;
        this.categoria = bd.obtenerNombreCategoria(idCategoria);
    }

    /**
     * @return the idCategoria
     */
    public int getIdCategoria() {
        return idCategoria;
    }

    /**
     * @param idCategoria the idCategoria to set
     */
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
