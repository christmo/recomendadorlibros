/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package principal;

import BaseDatos.BaseDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kradac
 */
public class Main {
    public static void main(String[] args) {
        BaseDatos bd = new BaseDatos();

        ResultSet r = bd.ejecutarConsulta("Select * from categorias");
        try {
            while (r.next()) {
                System.out.println(""+r.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
