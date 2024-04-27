/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tienda.view;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author heber
 */
public class JFApartado extends javax.swing.JFrame {

    /**
     * Creates new form MenuOpciones
     */
    public JFApartado() {
        initComponents();

        this.setDefaultCloseOperation(JFApartado.DO_NOTHING_ON_CLOSE);
    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtnInput = new javax.swing.JButton();
        jBtnModify = new javax.swing.JButton();
        jBtnDelete = new javax.swing.JButton();
        jBtnGuardar = new javax.swing.JButton();
        jTxtProducto = new javax.swing.JTextField();
        jTxtCantidad = new javax.swing.JTextField();
        jTxtPrecio = new javax.swing.JTextField();
        jTxtCategoria = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTxtSearch = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblDatos = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jBtnInput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jBtnInput.setText("Ingresar");

        jBtnModify.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jBtnModify.setText("Modificar");
        jBtnModify.setEnabled(false);

        jBtnDelete.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jBtnDelete.setText("Eliminar");
        jBtnDelete.setEnabled(false);

        jBtnGuardar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jBtnGuardar.setText("Guardar");

        jTxtProducto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTxtProducto.setToolTipText("Nombre");

        jTxtCantidad.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTxtCantidad.setToolTipText("");

        jTxtPrecio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jTxtCategoria.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTxtCategoria.setToolTipText("1 - papeleria , 2 - otros");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Producto:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Cantidad:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Precio:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Cantidad pagada:");

        jTxtSearch.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Buscador");

        jTblDatos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Nombre", "Precio", "Categoría", "Ventas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTblDatos.setAutoscrolls(false);
        jTblDatos.setFocusable(false);
        jTblDatos.setRowHeight(25);
        jTblDatos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTblDatos.getTableHeader().setReorderingAllowed(false);
        jTblDatos.setUpdateSelectionOnSort(false);
        jScrollPane1.setViewportView(jTblDatos);
        if (jTblDatos.getColumnModel().getColumnCount() > 0) {
            jTblDatos.getColumnModel().getColumn(0).setResizable(false);
            jTblDatos.getColumnModel().getColumn(1).setResizable(false);
            jTblDatos.getColumnModel().getColumn(2).setResizable(false);
            jTblDatos.getColumnModel().getColumn(3).setResizable(false);
            jTblDatos.getColumnModel().getColumn(4).setResizable(false);
        }
        if (jTblDatos.getColumnModel().getColumnCount() > 0) {
            jTblDatos.getColumnModel().getColumn(0).setPreferredWidth(350);

        }

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setText("REGISTRO DE PRODUCTOS APARTADOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTxtCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                            .addComponent(jTxtProducto, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtCantidad, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtPrecio, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtnModify, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                            .addComponent(jBtnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTxtSearch))
                            .addComponent(jBtnInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnInput)
                    .addComponent(jTxtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnModify)
                    .addComponent(jTxtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnDelete)
                    .addComponent(jTxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTxtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnGuardar)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jBtnDelete;
    public javax.swing.JButton jBtnGuardar;
    public javax.swing.JButton jBtnInput;
    public javax.swing.JButton jBtnModify;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTblDatos;
    public javax.swing.JTextField jTxtCantidad;
    public javax.swing.JTextField jTxtCategoria;
    public javax.swing.JTextField jTxtPrecio;
    public javax.swing.JTextField jTxtProducto;
    public javax.swing.JTextField jTxtSearch;
    // End of variables declaration//GEN-END:variables
}
