/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tienda.view;

/**
 *
 * @author heber
 */
public class JFHistorial extends javax.swing.JFrame {

    /**
     * Creates new form JFHistorial
     */
    public JFHistorial() {
        initComponents();
        cerrado();
    }
    
    public void cerrado(){
        this.setDefaultCloseOperation(JFHistorial.DO_NOTHING_ON_CLOSE);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblHistorial = new javax.swing.JTable();
        jBtnOk = new javax.swing.JButton();
        jLblVentas = new javax.swing.JLabel();
        jLblVentasPapeleria = new javax.swing.JLabel();
        jLblVentasOtros = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("HISTORIAL DE VENTAS");

        jTblHistorial.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTblHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FECHA", "ARTICULOS", "TOTAL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTblHistorial.setEnabled(false);
        jTblHistorial.setFocusable(false);
        jTblHistorial.setRowHeight(25);
        jTblHistorial.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTblHistorial.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTblHistorial);
        jTblHistorial.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (jTblHistorial.getColumnModel().getColumnCount() > 0) {
            jTblHistorial.getColumnModel().getColumn(0).setResizable(false);
            jTblHistorial.getColumnModel().getColumn(1).setResizable(false);
            jTblHistorial.getColumnModel().getColumn(2).setResizable(false);
        }

        jBtnOk.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jBtnOk.setText("OK");

        jLblVentas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLblVentas.setText("Ventas del Día:");

        jLblVentasPapeleria.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLblVentasPapeleria.setText("Papeleria:");

        jLblVentasOtros.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLblVentasOtros.setText("Otros:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLblVentas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLblVentasPapeleria)
                            .addComponent(jLblVentasOtros))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLblVentasPapeleria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLblVentasOtros)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnOk)
                    .addComponent(jLblVentas))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jBtnOk;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLblVentas;
    public javax.swing.JLabel jLblVentasOtros;
    public javax.swing.JLabel jLblVentasPapeleria;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTblHistorial;
    // End of variables declaration//GEN-END:variables
}
