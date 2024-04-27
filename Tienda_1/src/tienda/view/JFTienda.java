/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tienda.view;

/**
 *
 * @author heber
 */
public class JFTienda extends javax.swing.JFrame {

    /**
     * Creates new form JFProducto
     */
    public JFTienda() {
        initComponents();
        this.setDefaultCloseOperation(JFTienda.DO_NOTHING_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jBtnSalir = new javax.swing.JButton();
        jBtnRegistro = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblVentas = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTblDatos = new javax.swing.JTable();
        jBtnHistorial = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTxtBuscadorTienda = new javax.swing.JTextField();
        jLblTotal = new javax.swing.JLabel();
        jBtnVender = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jBtnFacturas = new javax.swing.JButton();
        jBtnExportar = new javax.swing.JButton();
        jTxtAgregar = new javax.swing.JTextField();
        jCBOpcionAgregar = new javax.swing.JComboBox<>();
        jBtnAgregar = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jBtnSalir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jBtnSalir.setText("Guardar y Salir");

        jBtnRegistro.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jBtnRegistro.setText("Registro de Productos");

        jTblVentas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTblVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Precio U", "Cantidad", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTblVentas.setRowHeight(25);
        jTblVentas.setRowSelectionAllowed(false);
        jTblVentas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTblVentas);
        if (jTblVentas.getColumnModel().getColumnCount() > 0) {
            jTblVentas.getColumnModel().getColumn(0).setResizable(false);
            jTblVentas.getColumnModel().getColumn(1).setResizable(false);
            jTblVentas.getColumnModel().getColumn(2).setResizable(false);
            jTblVentas.getColumnModel().getColumn(3).setResizable(false);
        }
        if (jTblVentas.getColumnModel().getColumnCount() > 0) {
            jTblVentas.getColumnModel().getColumn(0).setPreferredWidth(350);

        }

        jTblDatos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Producto", "Inventario", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTblDatos.setAutoscrolls(false);
        jTblDatos.setFocusable(false);
        jTblDatos.setMaximumSize(new java.awt.Dimension(2147483647, 3000));
        jTblDatos.setMinimumSize(new java.awt.Dimension(45, 45));
        jTblDatos.setRowHeight(25);
        jTblDatos.setDragEnabled(false);
        jTblDatos.getTableHeader().setReorderingAllowed(false);
        jTblDatos.setUpdateSelectionOnSort(false);
        jScrollPane2.setViewportView(jTblDatos);
        if (jTblDatos.getColumnModel().getColumnCount() > 0) {
            jTblDatos.getColumnModel().getColumn(0).setResizable(false);
            jTblDatos.getColumnModel().getColumn(1).setResizable(false);
            jTblDatos.getColumnModel().getColumn(2).setResizable(false);
            jTblDatos.getColumnModel().getColumn(2).setPreferredWidth(213);
        }

        jBtnHistorial.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jBtnHistorial.setText("Historial");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Buscador:");

        jTxtBuscadorTienda.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLblTotal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLblTotal.setText("Total: ");

        jBtnVender.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jBtnVender.setText("VENDER");
        jBtnVender.setNextFocusableComponent(jTxtAgregar);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("VENTAS");

        jBtnFacturas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jBtnFacturas.setText("Facturas");

        jBtnExportar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jBtnExportar.setText("Exportar Datos");

        jTxtAgregar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTxtAgregar.setNextFocusableComponent(jCBOpcionAgregar);

        jCBOpcionAgregar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCBOpcionAgregar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Papeleria", "Otro" }));
        jCBOpcionAgregar.setNextFocusableComponent(jTxtAgregar);

        jBtnAgregar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jBtnAgregar.setText("Agregar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTxtBuscadorTienda))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE))
                                .addGap(79, 79, 79))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jBtnHistorial)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jBtnRegistro)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jBtnFacturas, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jCBOpcionAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTxtAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jBtnAgregar)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLblTotal, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jBtnSalir)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBtnExportar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jBtnVender)))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTxtBuscadorTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 7, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblTotal)
                    .addComponent(jTxtAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBOpcionAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnAgregar))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnRegistro)
                    .addComponent(jBtnHistorial)
                    .addComponent(jBtnVender)
                    .addComponent(jBtnFacturas)
                    .addComponent(jBtnExportar)
                    .addComponent(jBtnSalir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jBtnAgregar;
    public javax.swing.JButton jBtnExportar;
    public javax.swing.JButton jBtnFacturas;
    public javax.swing.JButton jBtnHistorial;
    public javax.swing.JButton jBtnRegistro;
    public javax.swing.JButton jBtnSalir;
    public javax.swing.JButton jBtnVender;
    public javax.swing.JComboBox<String> jCBOpcionAgregar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLblTotal;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable jTblDatos;
    public javax.swing.JTable jTblVentas;
    public javax.swing.JTextField jTxtAgregar;
    public javax.swing.JTextField jTxtBuscadorTienda;
    // End of variables declaration//GEN-END:variables
}