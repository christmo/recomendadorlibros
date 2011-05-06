/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Buscador.java
 *
 * Created on 04/05/2011, 12:25:55 PM
 */
package principal;

import BaseDatos.BaseDatos;
import algoritmos.Caso1;
import algoritmos.Caso2;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import objetos.Libros;

/**
 *
 * @author kradac
 */
public class Buscador extends javax.swing.JFrame {

    private BaseDatos bd;
    /**
     * Sesion
     * [0]User
     * [1]IDCLIENTE,
     * [2]NOMBRE,
     * [3]ID_IDIOMA
     */
    public static String[] sesion;
    private String txtIngresado = "";
    private String txtValorInicial = "";
    private String txtValorFinal = "";

    private int idLibro1;
    private int idLibro2;
    private int idLibro3;

    /** Creates new form Buscador */
    public Buscador() {
        initComponents();
    }

    public Buscador(BaseDatos bd, String[] sesion) {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/iconos/idea.png")).getImage());
        this.bd = bd;
        Buscador.sesion = sesion;

        //Comprobar que el cliente es nuevo o no
        //Si es nuevo aplicar el caso1.
        if (!bd.tieneHistorialCompra(Integer.parseInt(sesion[1]))) {
            //aplicar recomendación caso1
            System.out.println("CASO 1 : " + sesion[1]);
            Caso1 auxCaso1 = new Caso1();
            String[] librosRecomendados = auxCaso1.recomendacion3Libros(bd);

            //ID libros
            idLibro1 = Integer.parseInt(librosRecomendados[0]);
            idLibro2 = Integer.parseInt(librosRecomendados[2]);
            idLibro3 = Integer.parseInt(librosRecomendados[4]);


            //Imagenes
            lblLibro1B.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgLibros/" + librosRecomendados[1]+ ".jpg")));
            lblLibro2B.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgLibros/" + librosRecomendados[3]+ ".jpg")));
            lblLibro3B.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgLibros/" + librosRecomendados[5]+ ".jpg")));



        } else {
            //aplicar recomendación caso 2
            System.out.println("CASO 2");
//            Caso2 caso2 = new Caso2(bd);
//            ArrayList<Libros> librosRecomendados = caso2.obtenerLibrosRecomendadosClienteHistorial(sesion[1]);
//
//            lblLibro1B.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgLibros/" + librosRecomendados.get(0).getImagen()+ ".jpg")));
//            lblLibro2B.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgLibros/" + librosRecomendados.get(1).getImagen()+ ".jpg")));
//            lblLibro3B.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgLibros/" + librosRecomendados.get(2).getImagen()+ ".jpg")));

        }


        pnlIngresoTexto.setVisible(false);
        pnlRangoValores.setVisible(false);
        this.setTitle("Rocomendador de Libros - Bienvenid@ " + sesion[2]);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cbxBuscarPor = new javax.swing.JComboBox();
        pnlIngresoTexto = new javax.swing.JPanel();
        lblIngreso = new javax.swing.JLabel();
        txtTextoBuscar = new javax.swing.JTextField();
        pnlRangoValores = new javax.swing.JPanel();
        lblValores = new javax.swing.JLabel();
        txtValIni = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtValFin = new javax.swing.JTextField();
        lblMoneda = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        lblLibro2B = new javax.swing.JLabel();
        lblLibro1B = new javax.swing.JLabel();
        lblLibro3B = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Busqueda de Libros");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Recomendaciones de Libros");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Búsqueda de Libros");

        jLabel3.setText("Buscar Por:");

        cbxBuscarPor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Título", "Categoría", "Año", "Palabras Clave", "Precio", "Autor" }));
        cbxBuscarPor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxBuscarPorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(29, 29, 29)
                .addComponent(cbxBuscarPor, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbxBuscarPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblIngreso.setText("Título del Libro:");

        txtTextoBuscar.setToolTipText("Ingrese el titulo del libro");
        txtTextoBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTextoBuscarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout pnlIngresoTextoLayout = new javax.swing.GroupLayout(pnlIngresoTexto);
        pnlIngresoTexto.setLayout(pnlIngresoTextoLayout);
        pnlIngresoTextoLayout.setHorizontalGroup(
            pnlIngresoTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIngresoTextoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIngreso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTextoBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlIngresoTextoLayout.setVerticalGroup(
            pnlIngresoTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIngresoTextoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlIngresoTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIngreso)
                    .addComponent(txtTextoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblValores.setText("Precio entre:");

        txtValIni.setToolTipText("Ingrese el titulo del libro");
        txtValIni.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValIniFocusLost(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("y");

        txtValFin.setToolTipText("Ingrese el titulo del libro");
        txtValFin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValFinFocusLost(evt);
            }
        });
        txtValFin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtValFinKeyPressed(evt);
            }
        });

        lblMoneda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMoneda.setText("dólares");

        javax.swing.GroupLayout pnlRangoValoresLayout = new javax.swing.GroupLayout(pnlRangoValores);
        pnlRangoValores.setLayout(pnlRangoValoresLayout);
        pnlRangoValoresLayout.setHorizontalGroup(
            pnlRangoValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRangoValoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblValores)
                .addGap(18, 18, 18)
                .addComponent(txtValIni, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtValFin, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblMoneda)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlRangoValoresLayout.setVerticalGroup(
            pnlRangoValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRangoValoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRangoValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValores)
                    .addComponent(txtValIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtValFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMoneda))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        lblLibro2B.setBackground(new java.awt.Color(255, 255, 255));
        lblLibro2B.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblLibro1B.setBackground(new java.awt.Color(255, 255, 255));
        lblLibro1B.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblLibro3B.setBackground(new java.awt.Color(255, 255, 255));
        lblLibro3B.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
                                    .addGap(269, 269, 269))
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(pnlIngresoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(10, 10, 10))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(pnlRangoValores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(477, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblLibro1B, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblLibro2B, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblLibro3B, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLibro3B, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                    .addComponent(lblLibro1B, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                    .addComponent(lblLibro2B, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlIngresoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlRangoValores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxBuscarPorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxBuscarPorActionPerformed
        int op = cbxBuscarPor.getSelectedIndex();
        mostraParamentrosIngresar(op);
    }//GEN-LAST:event_cbxBuscarPorActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtValFinFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValFinFocusLost
        int ini = 0;
        int fin = 0;
        try {
            ini = Integer.parseInt(txtValIni.getText());
        } catch (NumberFormatException ex) {
            txtValIni.setText("");
        }
        try {
            fin = Integer.parseInt(txtValFin.getText());
            if (ini > fin) {
                JOptionPane.showMessageDialog(this, "Número inicial debe ser mayor al final...", "Error...", 0);
                txtValFin.setText("");
            }
        } catch (NumberFormatException ex) {
            txtValFin.setText("");
        }
    }//GEN-LAST:event_txtValFinFocusLost

    private void txtValIniFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValIniFocusLost
        try {
            Integer.parseInt(txtValIni.getText());
        } catch (NumberFormatException ex) {
            txtValIni.setText("");
        }
    }//GEN-LAST:event_txtValIniFocusLost

    private void txtTextoBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTextoBuscarKeyPressed
        int cod = evt.getKeyCode();
        if (cod == 10) {
            buscar();
        } else if (cod == 27) {
            System.exit(0);
        }
    }//GEN-LAST:event_txtTextoBuscarKeyPressed

    private void txtValFinKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValFinKeyPressed
        int cod = evt.getKeyCode();
        if (cod == 10) {
            buscar();
        } else if (cod == 27) {
            System.exit(0);
        }
    }//GEN-LAST:event_txtValFinKeyPressed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cbxBuscarPor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblIngreso;
    private javax.swing.JLabel lblLibro1B;
    private javax.swing.JLabel lblLibro2B;
    private javax.swing.JLabel lblLibro3B;
    private javax.swing.JLabel lblMoneda;
    private javax.swing.JLabel lblValores;
    private javax.swing.JPanel pnlIngresoTexto;
    private javax.swing.JPanel pnlRangoValores;
    private javax.swing.JTextField txtTextoBuscar;
    private javax.swing.JTextField txtValFin;
    private javax.swing.JTextField txtValIni;
    // End of variables declaration//GEN-END:variables

    private void buscar() {
        int op = cbxBuscarPor.getSelectedIndex();
        buscarLibrosPor(op);
    }

    private void mostraParamentrosIngresar(int op) {
        switch (op) {
            case 0: //Titulo
                pnlIngresoTexto.setVisible(true);
                pnlRangoValores.setVisible(false);
                lblIngreso.setText("Título del Libro:");
                break;
            case 1: //Categoría del Libro:
                pnlIngresoTexto.setVisible(true);
                pnlRangoValores.setVisible(false);
                lblIngreso.setText("Categoría del Libro:");
                break;
            case 2://Años
                pnlRangoValores.setVisible(true);
                pnlIngresoTexto.setVisible(false);
                lblValores.setText("Entre los Años:");
                lblMoneda.setVisible(false);
                break;
            case 3://Palabras Clave:
                pnlIngresoTexto.setVisible(true);
                pnlRangoValores.setVisible(false);
                lblIngreso.setText("Palabras Clave:");
                break;
            case 4: // Precio
                pnlRangoValores.setVisible(true);
                pnlIngresoTexto.setVisible(false);
                lblValores.setText("Precio entre:");
                lblMoneda.setVisible(true);
                break;
            case 5: // Autor
                pnlIngresoTexto.setVisible(true);
                pnlRangoValores.setVisible(false);
                lblIngreso.setText("Nombre del Autor:");
                break;
            default:
                pnlIngresoTexto.setVisible(true);
                pnlRangoValores.setVisible(false);
                lblIngreso.setText("Título del Libro:");
        }
    }

    private void buscarLibrosPor(int op) {
        txtIngresado = txtTextoBuscar.getText();
        txtValorInicial = txtValIni.getText();
        txtValorFinal = txtValFin.getText();
        if (!txtIngresado.equals("")
                || !txtValorInicial.equals("")
                && !txtValorFinal.equals("")) {
            ArrayList<Libros> librosEncontrados = new ArrayList<Libros>();
            switch (op) {
                case 0: //Titulo
                    librosEncontrados = bd.obtenerLibrosPorTitulo(txtIngresado, bd);
                    break;
                case 1: //Categoría del Libro:
                    librosEncontrados = bd.obtenerLibrosPorCategoria(txtIngresado, bd);
                    break;
                case 2://Años
                    librosEncontrados = bd.obtenerLibrosPorAnios(txtValorInicial, txtValorFinal, bd);
                    break;
                case 3://Palabras Clave:
                    librosEncontrados = bd.obtenerLibrosPorPalabraClave(txtIngresado, bd);
                    break;
                case 4: // Precio
                    librosEncontrados = bd.obtenerLibrosPorPrecio(txtValorInicial, txtValorFinal, bd);
                    break;
                case 5: // Autor
                    librosEncontrados = bd.obtenerLibrosPorAutor(txtIngresado, bd);
                    break;
            }
            ResultadosBusqueda resultBusqueda = new ResultadosBusqueda(librosEncontrados, bd);
            resultBusqueda.setVisible(true);
            resultBusqueda.setLocationRelativeTo(this);
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "No hay una opción a buscar...", "Error...", 0);
        }
    }

    private void limpiarCampos() {
        txtTextoBuscar.setText("");
        txtValIni.setText("");
        txtValFin.setText("");
    }

}
