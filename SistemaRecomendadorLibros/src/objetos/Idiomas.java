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
public class Idiomas {

    private int idIdioma;
    private String idioma;

    public Idiomas(int idIdioma, String idioma) {
        this.idIdioma = idIdioma;
        this.idioma = idioma;
    }

    /**
     * Se carga el nombre solo enviandole el id del idioma
     * @param idIdioma
     */
    public Idiomas(int idIdioma,BaseDatos bd) {
        this.idIdioma = idIdioma;
        this.idioma = bd.obtenerNombreIdioma(idIdioma);
    }



    /**
     * @return the idIdioma
     */
    public int getIdIdioma() {
        return idIdioma;
    }

    /**
     * @param idIdioma the idIdioma to set
     */
    public void setIdIdioma(int idIdioma) {
        this.idIdioma = idIdioma;
    }

    /**
     * @return the idioma
     */
    public String getIdioma() {
        return idioma;
    }

    /**
     * @param idioma the idioma to set
     */
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
}
