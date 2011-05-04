/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import BaseDatos.BaseDatos;
import java.sql.ResultSet;

/**
 *
 * @author kradac
 */
public class Libros {
    //int idAutor;

    private int idLibro;
    private String titulo;
    private double precio;
    private String resumen;
    private String editorial;
    private boolean bestseller;
    private int vistas;
    private int anioLanzamiento;
    private Idiomas idioma;
    private Paises pais;
    private Categorias categoria;
    private Autores autor;

    public Libros() {
    }

    public Libros(int idLibro, BaseDatos bd) {
        this.idLibro = idLibro;
        ResultSet rs = bd.obtenerInformacionLibro(idLibro);
    }

    /**
     * @return the idLibro
     */
    public int getIdLibro() {
        return idLibro;
    }

    /**
     * @param idLibro the idLibro to set
     */
    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the resumen
     */
    public String getResumen() {
        return resumen;
    }

    /**
     * @param resumen the resumen to set
     */
    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    /**
     * @return the editorial
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * @param editorial the editorial to set
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    /**
     * @return the bestseller
     */
    public boolean isBestseller() {
        return bestseller;
    }

    /**
     * @param bestseller the bestseller to set
     */
    public void setBestseller(boolean bestseller) {
        this.bestseller = bestseller;
    }

    /**
     * @return the vistas
     */
    public int getVistas() {
        return vistas;
    }

    /**
     * @param vistas the vistas to set
     */
    public void setVistas(int vistas) {
        this.vistas = vistas;
    }

    /**
     * @return the anioLanzamiento
     */
    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }

    /**
     * @param anioLanzamiento the anioLanzamiento to set
     */
    public void setAnioLanzamiento(int anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }

    /**
     * @return the idioma
     */
    public Idiomas getIdioma() {
        return idioma;
    }

    /**
     * @param idioma the idioma to set
     */
    public void setIdioma(Idiomas idioma) {
        this.idioma = idioma;
    }

    /**
     * @return the pais
     */
    public Paises getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(Paises pais) {
        this.pais = pais;
    }

    /**
     * @return the categoria
     */
    public Categorias getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the autor
     */
    public Autores getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(Autores autor) {
        this.autor = autor;
    }
}
