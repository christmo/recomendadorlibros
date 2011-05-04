/*
 * Este proyecto pertenece a KRADAC soluciones tecnologicas
 * Creando Tecnologia de Loja para el Mundo ;-)
 */

/*
 * LoginGUI.java
 *
 * Created on 02/08/2010, 05:57:26 PM
 */
package principal;

import BaseDatos.BaseDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

/**
 * @author christmo
 */
public class LoginGUI extends javax.swing.JFrame {

    private String strUser = null;
    private char[] chrPass = null;
    private String strPass = "";
    private BaseDatos cb = null;
    private ResultSet rs = null;

    /** Creates new form LoginGUI */
    public LoginGUI() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/iconos/idea.png")).getImage());
        jbtIngresar.setText("<html><center>INGRESAR</center></html>");
        jbtIngresar.setVerticalTextPosition(SwingConstants.BOTTOM);
        jbtIngresar.setHorizontalTextPosition(SwingConstants.CENTER);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtUser = new javax.swing.JTextField();
        jpPass = new javax.swing.JPasswordField();
        jbtIngresar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ingreso al Sistema...");
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jLabel1.setText("Usuario:");

        jLabel2.setText("Clave:");

        jtUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtUserFocusLost(evt);
            }
        });
        jtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtUserKeyPressed(evt);
            }
        });

        jpPass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jpPassFocusGained(evt);
            }
        });
        jpPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jpPassKeyPressed(evt);
            }
        });

        jbtIngresar.setText("Ingresar");
        jbtIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtIngresarActionPerformed(evt);
            }
        });
        jbtIngresar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtIngresarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jbtIngresar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpPass, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtUser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jpPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jbtIngresar))
        );

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/idea.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtIngresarActionPerformed
        ingresar();
    }//GEN-LAST:event_jbtIngresarActionPerformed

    /**
     * Ingreso al sistema
     */
    private void ingresar() {
        strUser = null;
        chrPass = null;
        strPass = "";
        boolean entrar = false;

        strUser = jtUser.getText();
        chrPass = jpPass.getPassword();

        for (int i = 0; i < chrPass.length; i++) {
            strPass += chrPass[i];
        }
        try {
            cb = new BaseDatos();
            entrar = true;
        } catch (UnsupportedOperationException ux) {
        }
        if (entrar) {
            System.out.println("Iniciar sistema de Recomendador... ;-)");
            try {
                String sql = "SELECT IDCLIENTE,NOMBRE,USER,PASS "
                        + "FROM CLIENTES "
                        + "WHERE USER = '" + strUser + "' AND PASS = '" + strPass + "'";

                rs = cb.ejecutarConsultaUnDato(sql);


                String usuarioBase = rs.getString("USER");
                String claveBase = rs.getString("PASS");

                boolean boolUsuario = (usuarioBase.toUpperCase().equals(strUser.toUpperCase()));
                boolean boolClave = (claveBase.equals(strPass));

                if (boolUsuario) {
                    if (boolClave) {
                        /**
                         * Sesion 
                         * [0]IDCLIENTE,
                         * [1]NOMBRE,
                         */
                        String sesion[] = {
                            strUser,
                            rs.getString("IDCLIENTE"),
                            rs.getString("NOMBRE")};


                        /*iNGRESAR*/
                        Buscador buscador = new Buscador(cb, sesion);
                        buscador.setVisible(true);
                        buscador.setLocationRelativeTo(this);

                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "Clave incorrecta", "Error", 0);
                        jpPass.setFocusCycleRoot(true);
                        jpPass.setText("");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Usuario incorrecto", "Error", 0);
                    jtUser.setFocusCycleRoot(true);
                    jtUser.setText("");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Comprobar si el usuario y la clave son correctos...", "Error", 0);
                jpPass.setFocusCycleRoot(true);
            } catch (NullPointerException npe) {
                JOptionPane.showMessageDialog(this, "No hay acceso a la base de datos, comprobar si la clave de la base de datos es corercta en el archivo de configuración...", "Error", 0);
                System.exit(0);
            }
        }
    }

    private void jpPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpPassKeyPressed
        int cod = evt.getKeyCode();
        if (cod == 10) {
            ingresar();
        } else if (cod == 27) {
            System.exit(0);
        }
    }//GEN-LAST:event_jpPassKeyPressed

    private void jpPassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jpPassFocusGained
        jpPass.setText("");
    }//GEN-LAST:event_jpPassFocusGained

    private void jtUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtUserKeyPressed
        int cod = evt.getKeyCode();
        if (cod == 10) {
            ingresar();
        } else if (cod == 27) {
            System.exit(0);
        }
    }//GEN-LAST:event_jtUserKeyPressed

    private void jtUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtUserFocusLost
        jtUser.setText(jtUser.getText().toUpperCase());
    }//GEN-LAST:event_jtUserFocusLost

    private void jbtIngresarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtIngresarKeyPressed
        if (evt.getKeyCode() == 10) {
            ingresar();
        }
    }//GEN-LAST:event_jbtIngresarKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    /**
                     * TODO: con el estilo no funciona el redibujado de la tabla
                     * vehiculos -=revisar=-
                     * Problema ocurre cuando se cambia de turnos dinamicamente
                     */
//                    UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceOfficeBlue2007LookAndFeel");
//                    UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceDustLookAndFeel");
//                    UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceMistSilverLookAndFeel");
                    UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceNebulaBrickWallLookAndFeel");
//                    UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceSaharaLookAndFeel");

                } catch (Exception e) {
                    System.out.println("Problemas al cargar Temas Substance");
                }

                new LoginGUI().setVisible(true);



            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtIngresar;
    private javax.swing.JPasswordField jpPass;
    private javax.swing.JTextField jtUser;
    // End of variables declaration//GEN-END:variables
}
