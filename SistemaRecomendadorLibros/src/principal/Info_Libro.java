/*
 * Info_Libro.java
 *
 * Created on 04/05/2011, 03:47:32 PM
 */
package principal;

import BaseDatos.BaseDatos;
import javax.swing.JOptionPane;
import objetos.Libros;

/**
 *
 * @author Cumar C.
 */
public class Info_Libro extends javax.swing.JFrame {

    private int idLibro1;
    private int idLibro2;
    private int idLibro3;
    private Libros informacionLibro;

    /** Creates new form Info_Libro */
    public Info_Libro() {
        initComponents();
    }

    Info_Libro(
            Libros libroSeleccionado,
            BaseDatos bd,
            int idLibroRecomendado1,
            String dirLibroRecomendado1,
            int idLibroRecomendado2,
            String dirLibroRecomendado2,
            int idLibroRecomendado3,
            String dirLibroRecomendado3
            ) {
        initComponents();
        
        this.informacionLibro = libroSeleccionado;

        cargarDatos();
              
        this.setLblLibro1(idLibroRecomendado1, dirLibroRecomendado1);
        this.setLblLibro2(idLibroRecomendado2, dirLibroRecomendado2);
        this.setLblLibro3(idLibroRecomendado3, dirLibroRecomendado3);

    }

    /**
     * Carga los datos del Libro actual al Formulario
     */
    public void cargarDatos(){
        this.setLblAnio(String.valueOf(this.informacionLibro.getAnioLanzamiento()));
        this.setLblAutor(this.informacionLibro.getAutor().getNombre());
        this.setLblBestSeller(this.informacionLibro.isBestseller());
        this.setLblCategoria(this.informacionLibro.getCategoria().getCategoria());
        this.setLblEditorial(this.informacionLibro.getEditorial());
        this.setLblIdioma(this.informacionLibro.getIdioma().getIdioma());
        this.setLblPrecio(String.valueOf(this.informacionLibro.getPrecio()));
        this.setLblTitulo(this.informacionLibro.getTitulo());
        this.setLblVistas(String.valueOf(this.informacionLibro.getVistas()));
        this.setTxtReview(this.informacionLibro.getResumen());

        lblImgBookPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgLibros/" + this.informacionLibro.getImagen() + ".jpg")));

    }

    /**
     * Actualiza la información del libro
     */
    public void setLibroSeleccionado(Libros libroSeleccionado,
            int idLibroRecomendado1,
            String dirLibroRecomendado1,
            int idLibroRecomendado2,
            String dirLibroRecomendado2,
            int idLibroRecomendado3,
            String dirLibroRecomendado3) {
        this.informacionLibro = libroSeleccionado;
        cargarDatos();
        this.setLblLibro1(idLibroRecomendado1, dirLibroRecomendado1);
        this.setLblLibro2(idLibroRecomendado2, dirLibroRecomendado2);
        this.setLblLibro3(idLibroRecomendado3, dirLibroRecomendado3);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLibro1 = new javax.swing.JLabel();
        lblLibro3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblImgBookPrincipal = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        lblVistas = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtReview = new javax.swing.JTextArea();
        lblReview = new javax.swing.JLabel();
        lblEditorial = new javax.swing.JLabel();
        lblBestSeller = new javax.swing.JLabel();
        lblAnio = new javax.swing.JLabel();
        lblIdioma = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        lblAutor = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        lblLibro2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        lblLibro1.setBackground(new java.awt.Color(255, 255, 255));
        lblLibro1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblLibro1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLibro1MouseClicked(evt);
            }
        });

        lblLibro3.setBackground(new java.awt.Color(255, 255, 255));
        lblLibro3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Info_Book"));

        lblImgBookPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgLibros/lib1.jpg"))); // NOI18N

        lblTitulo.setText("Titulo");

        lblCategoria.setText("Categoría");

        lblVistas.setText("Visto # veces");

        txtReview.setColumns(20);
        txtReview.setEditable(false);
        txtReview.setRows(5);
        jScrollPane1.setViewportView(txtReview);

        lblReview.setText("Review :");

        lblEditorial.setText("Editorial");

        lblBestSeller.setText("Best Seller");

        lblAnio.setText("Año");

        lblIdioma.setText("Idioma");

        lblPrecio.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblPrecio.setForeground(new java.awt.Color(0, 51, 255));
        lblPrecio.setText("Precio");

        lblAutor.setText("Autor");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/comprar.png"))); // NOI18N
        jButton1.setText("Comprar");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/regresar.png"))); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegresar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(374, Short.MAX_VALUE)
                .addComponent(lblBestSeller, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(199, 199, 199))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblReview)
                            .addComponent(lblEditorial)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblVistas, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lblImgBookPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblAutor, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(lblIdioma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAnio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblTitulo)
                .addGap(11, 11, 11)
                .addComponent(lblCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblReview)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(lblEditorial)
                .addGap(18, 18, 18)
                .addComponent(lblVistas, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lblBestSeller)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImgBookPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblAnio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(152, 152, 152)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        lblLibro2.setBackground(new java.awt.Color(255, 255, 255));
        lblLibro2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLibro1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLibro2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLibro3, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLibro1, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblLibro2, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                        .addComponent(lblLibro3, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int val = JOptionPane.showConfirmDialog(this, "El valor sera debito de su cuenta.\n ¿De acuerdo?","Confirmación",JOptionPane.OK_CANCEL_OPTION);        
        if (val == 0) {
            //implementar el registro de la
            //compra
            JOptionPane.showMessageDialog(this, "Su compra ha sido realizada !!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
}//GEN-LAST:event_btnRegresarActionPerformed

    private void lblLibro1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLibro1MouseClicked
        JOptionPane.showMessageDialog(this, this.getLblLibro1(), String.valueOf(this.getLblLibro2()), 1);
        //cerrar esta ventana y generar otra igual pero
        //con los datos del libro seleccionado.

    }//GEN-LAST:event_lblLibro1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAnio;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblBestSeller;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblEditorial;
    private javax.swing.JLabel lblIdioma;
    private javax.swing.JLabel lblImgBookPrincipal;
    private javax.swing.JLabel lblLibro1;
    private javax.swing.JLabel lblLibro2;
    private javax.swing.JLabel lblLibro3;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblReview;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblVistas;
    private javax.swing.JTextArea txtReview;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the lblAnio
     */
    public String getLblAnio() {
        return lblAnio.getText();
    }

    /**
     * @param lblAnio the lblAnio to set
     */
    public void setLblAnio(String Anio) {
        this.lblAnio.setText(Anio);
    }

    /**
     * @return the lblAutor
     */
    public String getLblAutor() {
        return lblAutor.getText();
    }

    /**
     * @param lblAutor the lblAutor to set
     */
    public void setLblAutor(String Autor) {
        this.lblAutor.setText(Autor);
    }

    /**
     * @return the lblBestSeller
     */
    public String getLblBestSeller() {
        return lblBestSeller.getText();
    }

    /**
     * @param lblBestSeller the lblBestSeller to set
     */
    public void setLblBestSeller(boolean BS) {
        if (BS) {
            this.lblBestSeller.setText("Best-Seller");
        } else {
            this.lblBestSeller.setText("");
        }

    }

    /**
     * @return the lblCategoria
     */
    public String getLblCategoria() {
        return lblCategoria.getText();
    }

    /**
     * @param lblCategoria the lblCategoria to set
     */
    public void setLblCategoria(String Categoria) {
        this.lblCategoria.setText(Categoria);
    }

    /**
     * @return the lblEditorial
     */
    public String getLblEditorial() {
        return lblEditorial.getText();
    }

    /**
     * @param lblEditorial the lblEditorial to set
     */
    public void setLblEditorial(String Editorial) {
        this.lblEditorial.setText(Editorial);
    }

    /**
     * @return the lblIdioma
     */
    public String getLblIdioma() {
        return lblIdioma.getText();
    }

    /**
     * @param lblIdioma the lblIdioma to set
     */
    public void setLblIdioma(String Idioma) {
        this.lblIdioma.setText(Idioma);
    }

    /**
     * @return the lblLibro1
     */
    public int getLblLibro1() {
        return this.idLibro1;
    }

    /**
     * @param lblLibro1 the lblLibro1 to set
     */
    public void setLblLibro1(int idLibro, String dirImg) {
        this.idLibro1 = idLibro;
        lblLibro1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgLibros/" + dirImg+ ".jpg")));
    }

    /**
     * @return the lblLibro2
     */
    public int getLblLibro2() {
        return this.idLibro2;
    }

    /**
     * @param lblLibro2 the lblLibro2 to set
     */
    public void setLblLibro2(int idLibro, String dirImg) {
        this.idLibro2 = idLibro;
        lblLibro2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgLibros/" + dirImg + ".jpg")));
    }

    /**
     * @return the lblLibro3
     */
    public int getLblLibro3() {
        return this.idLibro3;
    }

    /**
     * @param lblLibro3 the lblLibro3 to set
     */
    public void setLblLibro3(int idLibro, String dirImg) {
        this.idLibro3 = idLibro;
        lblLibro3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgLibros/" + dirImg + ".jpg")));

    }

    /**
     * @return the lblPrecio
     */
    public String getLblPrecio() {
        return lblPrecio.getText();
    }

    /**
     * @param lblPrecio the lblPrecio to set
     */
    public void setLblPrecio(String Precio) {
        this.lblPrecio.setText("Precio: $ " + Precio + " dólares");
    }

    /**
     * @return the lblTitulo
     */
    public String getLblTitulo() {
        return lblTitulo.getText();
    }

    /**
     * @param lblTitulo the lblTitulo to set
     */
    public void setLblTitulo(String Titulo) {
        this.lblTitulo.setText(Titulo);
    }

    /**
     * @return the lblVistas
     */
    public String getLblVistas() {
        return lblVistas.getText();
    }

    /**
     * @param lblVistas the lblVistas to set
     */
    public void setLblVistas(String Vistas) {
        this.lblVistas.setText("Ha sido visto " + Vistas + " veces. ");
    }

    /**
     * @return the txtReview
     */
    public String getTxtReview() {
        return txtReview.getText();
    }

    /**
     * @param txtReview the txtReview to set
     */
    public void setTxtReview(String Review) {
        this.txtReview.setText(Review);
    }
}
