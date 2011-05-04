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
public class Paises {

    private int idPais;
    private String pais;

    public Paises(int idPais, String pais) {
        this.idPais = idPais;
        this.pais = pais;
    }

    /**
     * Obtiene el nombre a partir del id que se envia
     * @param idPais
     * @param bd
     */
    public Paises(int idPais, BaseDatos bd) {
        this.idPais = idPais;
        this.pais = bd.obtenerNombrePais(idPais);
    }

    /**
     * @return the idPais
     */
    public int getIdPais() {
        return idPais;
    }

    /**
     * @param idPais the idPais to set
     */
    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }
}
