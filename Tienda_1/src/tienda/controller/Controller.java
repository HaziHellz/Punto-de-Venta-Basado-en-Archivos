package tienda.controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import tienda.model.Documento;
import tienda.model.Factura;
import tienda.model.FacturaDAO;
import tienda.model.Producto;
import tienda.model.ProductoDAO;
import tienda.model.Venta;
import tienda.model.VentaDAO;
import tienda.view.JFExportar;
import tienda.view.JFFacturas;
import tienda.view.JFHistorial;
import tienda.view.JFProducto;
import tienda.view.JFTienda;

/**
 *
 * @author heber
 */
public final class Controller implements ActionListener, KeyListener, MouseListener, TableModelListener {

    JFProducto jfProducto;
    JFTienda jfTienda;
    JFHistorial jfHistorial;
    JFFacturas jfFacturas;
    JFExportar jfExportar;

    ProductoDAO productoDAO;
    VentaDAO ventasDAO;
    FacturaDAO facturaDAO;

    ArrayList<Producto> productos;
    ArrayList<Producto> productosVenta = new ArrayList();
    ArrayList<Producto> ventaConfirmada;

    ArrayList<Venta> ventas = new ArrayList();

    ArrayList<Factura> facturas = new ArrayList();

    int selectedIndexProducts;
    int selectedIndexTiendaProducto;
    int selectedIndexTiendaVenta;
    int selectedIndexFactura;

    String selectedProduct = "";
    DefaultTableModel modelo = defaultTableProducts();

    public Controller(JFProducto jfProducto, ProductoDAO productoDAO, JFTienda jfTienda, VentaDAO ventasDAO, JFHistorial jfHistorial, JFFacturas jfFacturas, FacturaDAO facturaDAO, JFExportar jfExportar) {
        selectedIndexProducts = -1; //no seleccionado
        selectedIndexTiendaProducto = -1;
        selectedIndexFactura = -1;
        //configura la tabla para que no se pueda mover ni editar
        jfProducto.jTblDatos.getTableHeader().setReorderingAllowed(false);
        jfProducto.jTblDatos.setSelectionMode(0);
        jfProducto.jTblDatos.setDragEnabled(false);

        jfProducto.setIconImage(new ImageIcon(getClass().getResource("/images/icon.png")).getImage());
        jfHistorial.setIconImage(new ImageIcon(getClass().getResource("/images/icon.png")).getImage());
        jfTienda.setIconImage(new ImageIcon(getClass().getResource("/images/icon.png")).getImage());
        jfFacturas.setIconImage(new ImageIcon(getClass().getResource("/images/icon.png")).getImage());
        jfExportar.setIconImage(new ImageIcon(getClass().getResource("/images/icon.png")).getImage());

        //agrega listeners de teclado
        jfProducto.jTxtProducto.addKeyListener(this);
        jfProducto.jTxtCantidad.addKeyListener(this);
        jfProducto.jTxtPrecio.addKeyListener(this);
        jfProducto.jTxtCategoria.addKeyListener(this);
        jfProducto.jTxtSearch.addKeyListener(this);

        //agrega listener de botones
        jfProducto.jBtnInput.addActionListener(this);
        jfProducto.jBtnModify.addActionListener(this);
        jfProducto.jBtnDelete.addActionListener(this);
        jfProducto.jBtnGuardar.addActionListener(this);

        //agrega listener del mouse a la tabla
        jfProducto.jTblDatos.addMouseListener(this);

        jfTienda.jBtnSalir.addActionListener(this);
        jfTienda.jBtnRegistro.addActionListener(this);
        jfTienda.jBtnExportar.addActionListener(this);
        jfTienda.jBtnAgregar.addActionListener(this);
        
        jfTienda.jCBOpcionAgregar.addKeyListener(this);
        jfTienda.jTxtAgregar.addKeyListener(this);
        jfTienda.jTxtBuscadorTienda.addKeyListener(this);
        jfTienda.jTblDatos.addMouseListener(this);
        jfTienda.jTblDatos.getTableHeader().setReorderingAllowed(false);
        jfTienda.jTblDatos.setSelectionMode(0);
        jfTienda.jTblDatos.setDragEnabled(false);

        jfTienda.jTblVentas.addKeyListener(this);
        jfTienda.jTblVentas.getModel().addTableModelListener(this);

        jfTienda.jBtnVender.addActionListener(this);
        jfTienda.jBtnHistorial.addActionListener(this);
        jfTienda.jBtnFacturas.addActionListener(this);
        jfTienda.jBtnVender.addKeyListener(this);

        jfHistorial.jBtnOk.addActionListener(this);
        jfHistorial.jTblHistorial.setCellSelectionEnabled(false);
        jfHistorial.jTblHistorial.setColumnSelectionAllowed(false);
        jfHistorial.jTblHistorial.setRowSelectionAllowed(true);

        jfFacturas.jBtnInput.addActionListener(this);
        jfFacturas.jBtnModify.addActionListener(this);
        jfFacturas.jBtnDelete.addActionListener(this);
        jfFacturas.jBtnGuardar.addActionListener(this);
        jfFacturas.jTblFacturas.addMouseListener(this);
        jfFacturas.jTxtNombre.addKeyListener(this);
        jfFacturas.jTxtCantidad.addKeyListener(this);
        jfFacturas.jTxtSearch.addKeyListener(this);
        jfFacturas.jTblFacturas.setSelectionMode(0);
        jfFacturas.jBtnLimpiar.addActionListener(this);
        jfFacturas.jTxtCategoria.addKeyListener(this);

        jfExportar.jBtnCancelar.addActionListener(this);
        jfExportar.jBtnExportar.addActionListener(this);

        this.jfFacturas = jfFacturas;
        this.jfProducto = jfProducto;
        this.jfTienda = jfTienda;
        this.jfHistorial = jfHistorial;
        this.jfExportar = jfExportar;

        this.productoDAO = productoDAO;
        this.ventasDAO = ventasDAO;
        this.facturaDAO = facturaDAO;

        //System.out.println(officeDAO.read().toString());
        //lee el archivo de las oficinas
        productos = productoDAO.read();
        ventas = ventasDAO.read();
        facturas = facturaDAO.read();

        //offices.add(new Office(5, "DXD", "xd",7 , 9));
        //officeDAO.write(offices);
        //System.out.println(officeDAO.read().toString());
        //System.out.println(offices.toString());
        //refresca la tabla y regresa a la configuracion inicial del programa
        refreshAll();
        refreshTienda();
    }

    public void validarNumero(KeyEvent e) {
        if (e.getKeyChar() < '0' || e.getKeyChar() > '9') {
            e.consume();
        }
    }

    public void validarNumero(KeyEvent e, String text) {
        boolean consume = false;
        int point = 1;
        for (int i = 0; i < text.length(); i++) {
            if ('.' == text.charAt(i)) {
                point += 1;
            }
        }
        if (e.getKeyChar() < '0' || e.getKeyChar() > '9') {
            consume = true;
            if (e.getKeyChar() == '.') {
                consume = false;
            }
        }

        if ((point > 1 && e.getKeyChar() == '.') || consume == true) {
            e.consume();
        }
    }

    //public void validarLetra(KeyEvent e) {
        //if ((e.getKeyChar() < 'a' || e.getKeyChar() > 'z') && (e.getKeyChar() < 'A' || e.getKeyChar() > 'Z') && e.getKeyChar() != ' ' && e.getKeyChar() != '.') {
            //e.consume();
        //}
    //}

    public void addFactura(ActionEvent e) {
        if (jfFacturas.jTxtCantidad.getText().equals("") || jfFacturas.jTxtNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(jfFacturas, "Llena todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {

            DefaultTableModel model = (DefaultTableModel) jfFacturas.jTblFacturas.getModel();
            Object[] row = new Object[4];
            Factura factura = new Factura(Double.parseDouble(jfFacturas.jTxtCantidad.getText()), jfFacturas.jTxtNombre.getText(), e.getWhen(), Integer.parseInt(jfFacturas.jTxtCategoria.getText()));

            row[0] = factura.getFecha();
            row[1] = factura.getNombre();
            row[2] = factura.getCantidad();
            row[3] = factura.getCategoria();

            facturas.add(factura);
            model.addRow(row);

            //System.out.println(offices.toString());
            //System.out.println(officeDAO.read().toString());
            jfFacturas.jTblFacturas.setModel(model);
            refreshFacturas();
            resetFormFactura();
        }
    }

    public void add() {
        //valida que los datos no estén vacios
        if (jfProducto.jTxtCantidad.getText().equals("") || jfProducto.jTxtProducto.getText().equals("") || jfProducto.jTxtCategoria.getText().equals("") || jfProducto.jTxtPrecio.getText().equals("")) {
            JOptionPane.showMessageDialog(jfProducto, "Llena todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            boolean validation = true;

            //valida una clave que las claves no sean iguales a otra oficina existente
            for (int i = 0; i < productos.size(); i++) {
                if (jfProducto.jTxtProducto.getText().equals(productos.get(i).getProducto())) {
                    validation = false;
                }
            }

            //si la validacion es correcta, se agrega al modelo de la tabla y al array de oficinas y se refresca la aplicacion
            if (validation) {
                DefaultTableModel model = (DefaultTableModel) jfProducto.jTblDatos.getModel();
                Object[] row = new Object[5];

                row[0] = jfProducto.jTxtProducto.getText();
                row[1] = jfProducto.jTxtCantidad.getText();
                row[2] = jfProducto.jTxtPrecio.getText();
                row[3] = jfProducto.jTxtCategoria.getText();
                Producto producto = new Producto(jfProducto.jTxtProducto.getText(), Integer.parseInt(jfProducto.jTxtCantidad.getText()), Double.parseDouble(jfProducto.jTxtPrecio.getText()), Integer.parseInt(jfProducto.jTxtCategoria.getText()));

                productos.add(producto);
                model.addRow(row);

                //System.out.println(offices.toString());
                //System.out.println(officeDAO.read().toString());
                jfProducto.jTblDatos.setModel(model);
                refreshAll();
            } else {
                //si la validacion de clave es incorrecta, lanza el mensaje
                JOptionPane.showMessageDialog(jfProducto, "Este `producto ya ha sido registrada antes", "Error", JOptionPane.ERROR_MESSAGE);
                jfProducto.jTxtProducto.requestFocus();
            }
        }

    }

    public void modify() {
        //verifica que los datos no esten vacios
        if (jfProducto.jTxtCantidad.getText().equals("") || jfProducto.jTxtProducto.getText().equals("") || jfProducto.jTxtCategoria.getText().equals("") || jfProducto.jTxtPrecio.getText().equals("")) {
            JOptionPane.showMessageDialog(jfProducto, "Llena todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Producto office = new Producto(
                    jfProducto.jTxtProducto.getText(),
                    Integer.parseInt(jfProducto.jTxtCantidad.getText()),
                    Double.parseDouble(jfProducto.jTxtPrecio.getText()),
                    Integer.parseInt(jfProducto.jTxtCategoria.getText()
                    )
            );
            productos.set(getIndex(), office);

            refreshAll();
        }

    }

    public void modifyFactura() {
        //verifica que los datos no esten vacios
        if (jfFacturas.jTxtCantidad.getText().equals("")) {
            JOptionPane.showMessageDialog(jfProducto, "Llena todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Factura factura = new Factura(
                    Double.parseDouble(jfFacturas.jTxtCantidad.getText()),
                    jfFacturas.jTxtNombre.getText(),
                    facturas.get(getIndexFactura()).getTimeStamp(),
                    Integer.parseInt(jfFacturas.jTxtCategoria.getText())
            );
            facturas.set(getIndexFactura(), factura);

            refreshFacturas();
        }

    }

    public void delete() {
        productos.remove(getIndex());
        refreshAll();
    }

    public void deleteFactura() {
        facturas.remove(getIndexFactura());
        refreshFacturas();
    }

    public void refreshAll() {
        Collections.sort(productos);

        DefaultTableModel model = defaultTableProducts();
        Object[] row = new Object[5];

        for (int i = 0; i < productos.size(); i++) {
            row[0] = productos.get(i).getProducto();
            row[1] = productos.get(i).getCantidad();
            row[2] = productos.get(i).getPrecio();
            row[3] = productos.get(i).getCategoria();
            row[4] = productos.get(i).getVentas();

            model.addRow(row);
        }

        jfProducto.jTblDatos.setModel(model);
        jfProducto.jTxtSearch.setText("");

        resetFormProduct();
        if (jfProducto.jTblDatos.getColumnModel().getColumnCount() > 0) {
            jfProducto.jTblDatos.getColumnModel().getColumn(0).setResizable(false);
            jfProducto.jTblDatos.getColumnModel().getColumn(1).setResizable(false);
            jfProducto.jTblDatos.getColumnModel().getColumn(2).setResizable(false);
            jfProducto.jTblDatos.getColumnModel().getColumn(3).setResizable(false);
            jfProducto.jTblDatos.getColumnModel().getColumn(4).setResizable(false);

            jfProducto.jTblDatos.getColumnModel().getColumn(0).setPreferredWidth(350);
        }
    }

    private DefaultTableModel defaultTableFacturas() {
        return new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Fecha", "Nombre", "Cantidad", "Categoria"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
    }

    private void refreshFacturas() {
        Collections.sort(facturas);
        DefaultTableModel model = defaultTableFacturas();
        Object[] row = new Object[4];

        for (int i = 0; i < facturas.size(); i++) {
            int alcance = jfFacturas.jTxtSearch.getText().length();
            try {
                String subString = String.valueOf(facturas.get(i).getFecha()).substring(0, alcance);
                //System.out.println(subString);
                if (subString.equals(jfFacturas.jTxtSearch.getText())) {
                    //System.out.println(facturas.get(i).getNombre());
                    row[0] = facturas.get(i).getFecha();
                    row[1] = facturas.get(i).getNombre();
                    row[2] = facturas.get(i).getCantidad();
                    row[3] = facturas.get(i).getCategoria();
                    model.addRow(row);
                }
            } catch (Exception e) {

            }

            //System.out.println("0");
        }

        jfFacturas.jTblFacturas.setModel(model);
        if (jfFacturas.jTblFacturas.getColumnModel().getColumnCount() > 0) {
            jfFacturas.jTblFacturas.getColumnModel().getColumn(0).setResizable(false);
            jfFacturas.jTblFacturas.getColumnModel().getColumn(1).setResizable(false);
            jfFacturas.jTblFacturas.getColumnModel().getColumn(2).setResizable(false);
        }

        jfFacturas.jTxtNombre.requestFocus();
        jfFacturas.jBtnInput.setEnabled(true);

        jfFacturas.jBtnDelete.setEnabled(false);
        jfFacturas.jBtnModify.setEnabled(false);

        jfFacturas.jTxtNombre.setEditable(true);
        jfFacturas.jTxtNombre.setText("");
        jfFacturas.jTxtCantidad.setText("");
        jfFacturas.jTxtCategoria.setText("");
    }

    public void refresh() {
        DefaultTableModel model = defaultTableProducts();
        Object[] row = new Object[5];

        for (int i = 0; i < productos.size(); i++) {
            int alcance = jfProducto.jTxtSearch.getText().length();
            try {
                String subString = String.valueOf(productos.get(i).getProducto()).substring(0, alcance);
                //System.out.println(subString);
                if (subString.equals(jfProducto.jTxtSearch.getText())) {
                    row[0] = productos.get(i).getProducto();
                    row[1] = productos.get(i).getCantidad();
                    row[2] = productos.get(i).getPrecio();
                    row[3] = productos.get(i).getCategoria();
                    row[4] = productos.get(i).getVentas();

                    model.addRow(row);
                }
            } catch (Exception e) {

            }

            //System.out.println("0");
        }

        jfProducto.jTblDatos.setModel(model);

        if (jfProducto.jTblDatos.getColumnModel().getColumnCount() > 0) {
            jfProducto.jTblDatos.getColumnModel().getColumn(0).setResizable(false);
            jfProducto.jTblDatos.getColumnModel().getColumn(1).setResizable(false);
            jfProducto.jTblDatos.getColumnModel().getColumn(2).setResizable(false);
            jfProducto.jTblDatos.getColumnModel().getColumn(3).setResizable(false);
            jfProducto.jTblDatos.getColumnModel().getColumn(4).setResizable(false);

            jfProducto.jTblDatos.getColumnModel().getColumn(0).setPreferredWidth(350);
        }

        selectedIndexProducts = -1;
    }

    public void refreshTienda() {
        selectedIndexTiendaProducto = -1;
        DefaultTableModel model = defaultTableTienda();
        Object[] row = new Object[3];

        for (int i = 0; i < productos.size(); i++) {
            int alcance = jfTienda.jTxtBuscadorTienda.getText().length();
            if (!productos.get(i).getProducto().equals("Papeleria") && !productos.get(i).getProducto().equals("Otro")) {
                try {
                    String subString = String.valueOf(productos.get(i).getProducto()).substring(0, alcance);
                    //System.out.println(subString);
                    if (subString.equals(jfTienda.jTxtBuscadorTienda.getText())) {
                        row[0] = productos.get(i).getProducto();
                        row[1] = productos.get(i).getCantidad();
                        row[2] = productos.get(i).getPrecio();

                        model.addRow(row);
                    }
                } catch (Exception e) {

                }
            }

            //System.out.println("0");
        }

        jfTienda.jTblDatos.setModel(model);
        if (jfTienda.jTblDatos.getColumnModel().getColumnCount() > 0) {
            jfTienda.jTblDatos.getColumnModel().getColumn(0).setResizable(false);
            jfTienda.jTblDatos.getColumnModel().getColumn(1).setResizable(false);
            jfTienda.jTblDatos.getColumnModel().getColumn(2).setResizable(false);
            jfTienda.jTblDatos.getColumnModel().getColumn(0).setPreferredWidth(350);
        }
        selectedIndexProducts = -1;
    }

    public DefaultTableModel defaultTableHistorial() {

        return new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "FECHA", "ARTICULOS", "TOTAL"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.Object.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }

        };
    }

    public void refreshHistorial() {
        leerArchivos();
        DefaultTableModel model = defaultTableHistorial();
        Object[] row = new Object[3];
        Collections.sort(ventas);
        double ventasHoy = 0;
        double ventasPapeleria = 0;
        double ventasOtros = 0;

        for (int i = 0; i < ventas.size(); i++) {
            try {
                row[0] = ventas.get(i).getDate();
                row[1] = ventas.get(i).getArticulos();
                row[2] = ventas.get(i).getTotal();

                model.addRow(row);
            } catch (Exception e) {
            }
        }

        jfHistorial.jTblHistorial.setModel(model);
        if (jfHistorial.jTblHistorial.getColumnModel().getColumnCount() > 0) {
            jfHistorial.jTblHistorial.getColumnModel().getColumn(0).setResizable(false);
            jfHistorial.jTblHistorial.getColumnModel().getColumn(1).setResizable(false);
            jfHistorial.jTblHistorial.getColumnModel().getColumn(2).setResizable(false);

            jfHistorial.jTblHistorial.getColumnModel().getColumn(2).setMinWidth(35);
            jfHistorial.jTblHistorial.getColumnModel().getColumn(2).setMaxWidth(50);
            jfHistorial.jTblHistorial.getColumnModel().getColumn(0).setMinWidth(153);
            jfHistorial.jTblHistorial.getColumnModel().getColumn(0).setMaxWidth(155);
        }
        String fechaHoy = new SimpleDateFormat("dd").format(new Date(System.currentTimeMillis()));

        System.out.println(System.currentTimeMillis());
        System.out.println(fechaHoy);

        for (int i = 0; i < ventas.size(); i++) {
            if (ventas.get(i).getDate().substring(0, 2).equals(fechaHoy)) {
                ventasHoy += ventas.get(i).getTotal();
                for (int j = 0; j < ventas.get(i).getVenta().size(); j++) {
                    if (ventas.get(i).getVenta().get(j).getCategoria() == 1) {
                        ventasPapeleria += ventas.get(i).getVenta().get(j).getTotal();
                    }else{
                        ventasOtros += ventas.get(i).getVenta().get(j).getTotal();
                    }
                }
            }
        }

        jfHistorial.jLblVentas.setText("Ventas del Día: " + ventasHoy);
        jfHistorial.jLblVentasOtros.setText("Otros: " + ventasOtros);
        jfHistorial.jLblVentasPapeleria.setText("Papeleria: " + ventasPapeleria);
    }

    public void refreshVenta() {
        DefaultTableModel model = defaultTableVenta();

        Object[] row = new Object[4];
        Collections.sort(productosVenta);

        for (int i = 0; i < productosVenta.size(); i++) {
            try {
                row[0] = productosVenta.get(i).getProducto();
                row[1] = productosVenta.get(i).getPrecio();
                row[2] = productosVenta.get(i).getCantidad();
                row[3] = productosVenta.get(i).getTotal();

                model.addRow(row);
            } catch (Exception e) {
            }
        }

        jfTienda.jTblVentas.setModel(model);
        jfTienda.jTblVentas.getModel().addTableModelListener(this);
        if (jfTienda.jTblVentas.getColumnModel().getColumnCount() > 0) {
            jfTienda.jTblVentas.getColumnModel().getColumn(0).setResizable(false);
            jfTienda.jTblVentas.getColumnModel().getColumn(1).setResizable(false);
            jfTienda.jTblVentas.getColumnModel().getColumn(2).setResizable(false);
            jfTienda.jTblVentas.getColumnModel().getColumn(3).setResizable(false);
            jfTienda.jTblVentas.getColumnModel().getColumn(0).setPreferredWidth(350);
        }
        
        
        
        selectedIndexProducts = -1;
        refreshTotal();
    }

    public void resetFormProduct() {
        selectedIndexProducts = -1;
        jfProducto.jTxtProducto.setText("");
        jfProducto.jTxtCantidad.setText("");
        jfProducto.jTxtPrecio.setText("");
        jfProducto.jTxtCategoria.setText("");

        jfProducto.jTxtProducto.setEditable(true);
        jfProducto.jTxtProducto.requestFocus();
        jfProducto.jBtnInput.setEnabled(true);
        jfProducto.jBtnDelete.setEnabled(false);
        jfProducto.jBtnModify.setEnabled(false);
    }

    public void resetFormFactura() {
        jfFacturas.jTxtCantidad.setText("");
        jfFacturas.jTxtNombre.setText("");
        jfFacturas.jTxtSearch.setText("");
        jfFacturas.jTxtCategoria.setText("");
    }

    public int getIndex() {
        String clave = (String) jfProducto.jTblDatos.getValueAt(selectedIndexProducts, 0);
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getProducto() == clave) {
                return i;
            }
        }
        return -1;
    }

    public int getIndexFactura() {
        String clave = (String) jfFacturas.jTblFacturas.getValueAt(selectedIndexFactura, 0);
        for (int i = 0; i < facturas.size(); i++) {
            if (facturas.get(i).getFecha() == clave) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void keyTyped(KeyEvent e) {

        if (e.getSource() == jfProducto.jTxtProducto) {
            
            if ('\n' == e.getKeyChar()) {
                jfProducto.jTxtCantidad.requestFocus();
            }
        }

        if (e.getSource() == jfProducto.jTxtCantidad) {
            validarNumero(e);

            if ('\n' == e.getKeyChar()) {
                jfProducto.jTxtPrecio.requestFocus();
            }
        }

        if (e.getSource() == jfProducto.jTxtPrecio) {
            validarNumero(e, jfProducto.jTxtPrecio.getText());

            if ('\n' == e.getKeyChar()) {
                jfProducto.jTxtCategoria.requestFocus();
            }
        }
        
        if(e.getSource() == jfTienda.jCBOpcionAgregar){
            if ('\n' == e.getKeyChar()) {
                jfTienda.jTxtAgregar.requestFocus();
            }
        }

        if (e.getSource() == jfProducto.jTxtCategoria) {
            if (e.getKeyChar() < '1' || e.getKeyChar() > '2' || jfProducto.jTxtCategoria.getText().length() > 0) {
                e.consume();
            }
        }

        if (e.getSource() == jfFacturas.jTxtNombre) {
            
            if ('\n' == e.getKeyChar()) {
                jfFacturas.jTxtCantidad.requestFocus();
            }
        }

        if (e.getSource() == jfFacturas.jTxtCantidad) {
            validarNumero(e, jfFacturas.jTxtCantidad.getText());
            if ('\n' == e.getKeyChar()) {
                jfFacturas.jTxtCategoria.requestFocus();
            }
        }

        if (e.getSource() == jfFacturas.jTxtCategoria) {
            if (e.getKeyChar() < '1' || e.getKeyChar() > '2' || jfFacturas.jTxtCategoria.getText().length() > 0) {
                e.consume();
            }
        }

        if (e.getSource() == jfTienda.jTxtAgregar) {
            System.out.println(e.getKeyLocation());
            validarNumero(e, jfTienda.jTxtAgregar.getText());
            if ('\n' == e.getKeyChar()) {
                agregarCantidad();
            }
            if ( ' ' == e.getKeyChar()) {
                jfTienda.jTblVentas.setEditingColumn(2);
                
            }
            

        }

    }

    private void agregarCantidad() {
        if (jfTienda.jTxtAgregar.getText().length() > 0) {
            Producto anonimo = new Producto(jfTienda.jCBOpcionAgregar.getItemAt(jfTienda.jCBOpcionAgregar.getSelectedIndex()), 1, Double.parseDouble(jfTienda.jTxtAgregar.getText()), jfTienda.jCBOpcionAgregar.getSelectedIndex() + 1);
            anonimo.setTotal(anonimo.getPrecio());
            productosVenta.add(anonimo);
            refreshVenta();
            refreshTotal();
            jfTienda.jTxtAgregar.setText("");
            jfTienda.jBtnVender.requestFocus();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jfTienda.jBtnAgregar) {
            agregarCantidad();
        }

        if (e.getSource() == jfProducto.jBtnGuardar) {
            productoDAO.write(productos);
            //System.out.println(officeDAO.read().toString());
            jfProducto.setVisible(false);
            jfTienda.setVisible(true);
            actualizarArchivos();
            refreshTienda();
            refreshAll();
        }

        if (e.getSource() == jfProducto.jBtnModify) {
            modify();
        }

        if (e.getSource() == jfProducto.jBtnDelete) {
            //System.out.println(jfVista.jTblDatos.getSelectedRow());
            delete();
        }

        if (e.getSource() == jfProducto.jBtnInput) {
            add();
        }

        if (e.getSource() == jfTienda.jBtnSalir) {
            leerArchivos();
            productoDAO.write(productos);
            ventasDAO.write(ventas);
            facturaDAO.write(facturas);
            System.exit(0);
        }

        if (e.getSource() == jfTienda.jBtnRegistro) {
            leerArchivos();
            jfProducto.setVisible(true);
            jfTienda.setVisible(false);
        }

        if (e.getSource() == jfTienda.jBtnVender) {
            //leerArchivos();
            vender(e);
        }

        if (e.getSource() == jfTienda.jBtnHistorial) {
            leerArchivos();
            jfTienda.setVisible(false);
            jfHistorial.setVisible(true);
            jfProducto.setVisible(false);
            refreshHistorial();
        }

        if (e.getSource() == jfHistorial.jBtnOk) {
            
            jfTienda.setVisible(true);
            jfHistorial.setVisible(false);
            refreshAll();
            refreshVenta();
            refreshTienda();

        }

        if (e.getSource() == jfTienda.jBtnFacturas) {
            leerArchivos();
            refreshFacturas();
            //for (int i = 0; i < facturas.size(); i++) {
            //System.out.println(facturas.get(i).getNombre());
            //}
            jfFacturas.setVisible(true);
            jfTienda.setVisible(false);
            //System.out.println(facturas);
        }

        if (e.getSource() == jfFacturas.jBtnDelete) {
            deleteFactura();
            
        }

        if (e.getSource() == jfFacturas.jBtnGuardar) {
            jfFacturas.setVisible(false);
            jfTienda.setVisible(true);
            facturaDAO.write(facturas);
            //System.out.println(facturaDAO.read());
        }

        if (e.getSource() == jfTienda.jBtnExportar) {
            
            jfExportar.setVisible(true);

        }

        if (e.getSource() == jfFacturas.jBtnInput) {

            addFactura(e);
        }

        if (e.getSource() == jfFacturas.jBtnLimpiar) {
            
            if (JOptionPane.showConfirmDialog(jfFacturas, "Estas seguro de eliminar los datos?", "Datos de venta", 0, JOptionPane.WARNING_MESSAGE) == 0) {
                leerArchivos();
                limpiar();
                actualizarArchivos();
            }
            
        }

        if (e.getSource() == jfFacturas.jBtnModify) {
            modifyFactura();
            jfFacturas.jTxtSearch.setText("");
            refreshFacturas();
        }

        if (e.getSource() == jfExportar.jBtnCancelar) {
            leerArchivos();
            jfExportar.setVisible(false);
        }

        if (e.getSource() == jfExportar.jBtnExportar) {
            leerArchivos();
            Documento documento = new Documento(contabilizar(jfExportar.jCBOpcion.getSelectedIndex()));
            documento.exportar(jfExportar.jCBOpcion.getItemAt(jfExportar.jCBOpcion.getSelectedIndex()));
            JOptionPane.showMessageDialog(jfExportar, "Se ha exportado con exito. Documento \"" + "Cuentas " + jfExportar.jCBOpcion.getItemAt(jfExportar.jCBOpcion.getSelectedIndex()) + new SimpleDateFormat("dd-MM-yyyy").format(new Date(System.currentTimeMillis())) + ".txt\"", "Exportar", selectedIndexFactura);
            jfExportar.setVisible(false);
        }
    }

    public void limpiar() {
        facturas = new ArrayList();
        ventas = new ArrayList();

        for (int i = 0; i < productos.size(); i++) {
            if (!productos.get(i).getProducto().equals("Papeleria") && !productos.get(i).getProducto().equals("Otro")) {
                productos.get(i).setVentas(0);
            } else {
                productos.get(i).setPrecio(0);
                productos.get(i).setVentas(1);
            }
        }

        refreshAll();
        refreshTienda();
        refreshVenta();
        refreshFacturas();
    }

    public ArrayList contabilizar(int modo) {
        ArrayList<Double> datos = new ArrayList();
        double cuenta = 0;

        System.out.println(modo);

        if (modo == 0 || modo == 1) {
            for (int i = 0; i < facturas.size(); i++) {
                System.out.println("categoria" + facturas.get(i).getCategoria());
                if (facturas.get(i).getCategoria() - 1 == modo) {
                    cuenta += facturas.get(i).getCantidad();
                }
            }

            datos.add(cuenta);
            cuenta = 0;

            for (int i = 0; i < ventas.size(); i++) {
                for (int j = 0; j < ventas.get(i).getVenta().size(); j++) {
                    System.out.println("categoria ventas: " + ventas.get(i).getVenta().get(j).getCategoria());
                    System.out.println(modo + "modo");
                    if (ventas.get(i).getVenta().get(j).getCategoria() - 1 == modo) {
                        System.out.println("entro333");
                        cuenta += ventas.get(i).getVenta().get(j).getTotal();
                    }
                }
            }

            datos.add(cuenta);

            cuenta = datos.get(1) - datos.get(0);

            datos.add(cuenta);
        } else {
            for (int i = 0; i < facturas.size(); i++) {
                cuenta += facturas.get(i).getCantidad();
            }

            datos.add(cuenta);
            cuenta = 0;

            for (int i = 0; i < ventas.size(); i++) {
                cuenta += ventas.get(i).getTotal();
            }

            datos.add(cuenta);

            cuenta = datos.get(1) - datos.get(0);

            datos.add(cuenta);
        }

        return datos;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getSource() == jfTienda.jBtnVender) {
            if (e.getKeyCode() == 10) {
                ActionEvent evt = new ActionEvent(jfTienda.jBtnVender, 10, "", e.getWhen(), 1);

                vender(evt);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == jfProducto.jTxtSearch) {
            resetFormProduct();
            jfProducto.jTxtSearch.requestFocus();
            refresh();

        }

        if (e.getSource() == jfTienda.jTxtBuscadorTienda) {

            refreshTienda();
        }

        if (e.getSource() == jfFacturas.jTxtSearch) {
            refreshFacturas();
            jfFacturas.jTxtSearch.requestFocus();
        }
    }

    private DefaultTableModel defaultTableProducts() {

        return new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Producto", "Inventario", "Precio", "Categoría", "Ventas"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
    }

    private DefaultTableModel defaultTableTienda() {
        return new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Producto", "Inventario", "Precio"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
    }

    private DefaultTableModel defaultTableVenta() {
        return new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Producto", "Precio U", "Cantidad", "Precio"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        if (e.getSource() == jfProducto.jTblDatos) {
            if (selectedIndexProducts != jfProducto.jTblDatos.getSelectedRow()) {//verifica que el renglon seleccionado sea diferente
                selectedIndexProducts = jfProducto.jTblDatos.getSelectedRow();
                //System.out.println(selectedIndex);

                selectedProduct = (String) jfProducto.jTblDatos.getValueAt(selectedIndexProducts, 0);

                for (int i = 0; i < productos.size(); i++) {
                    if (productos.get(i).getProducto() == null ? selectedProduct == null : productos.get(i).getProducto().equals(selectedProduct)) {
                        jfProducto.jTxtProducto.setText(String.valueOf(productos.get(i).getProducto()));
                        jfProducto.jTxtProducto.setEditable(false);
                        jfProducto.jTxtCantidad.setText(String.valueOf(productos.get(i).getCantidad()));
                        jfProducto.jTxtPrecio.setText(String.valueOf(productos.get(i).getPrecio()));
                        jfProducto.jTxtCategoria.setText(String.valueOf(productos.get(i).getCategoria()));

                    }
                }

                jfProducto.jTxtCantidad.requestFocus();
                jfProducto.jBtnInput.setEnabled(false);

                jfProducto.jBtnDelete.setEnabled(true);
                jfProducto.jBtnModify.setEnabled(true);
            } else {//si no es diferente renglon, vuelve a los valores de inicio y deselecciona el renglon

                refreshAll();
            }
        }

        if (e.getSource() == jfTienda.jTblDatos) {

            if (selectedIndexTiendaProducto != jfTienda.jTblDatos.getSelectedRow()) {//verifica que el renglon seleccionado sea diferente
                selectedIndexTiendaProducto = jfTienda.jTblDatos.getSelectedRow();
                //System.out.println(selectedIndexTiendaProducto);

                selectedProduct = (String) jfTienda.jTblDatos.getValueAt(selectedIndexTiendaProducto, 0);
                //System.out.println(selectedProduct);
            } else {

                if (e.getButton() == 1) {
                    for (int i = 0; i < productos.size(); i++) {
                        //System.out.println("BBB");
                        //POR HACER: VERIFICAR QUE EL PRODUCTO NO ESTÉ EN EL ARRAY PARA METERLO AL MISMO

                        //ENCUENTRA EL PRODUCTO A AGREGAR A LA LISTA
                        if (productos.get(i).getProducto().equals((String) selectedProduct)) {
                            System.out.println(selectedProduct);

                            if (productos.get(i).getCantidad() > 0) {
                                boolean equal = false;
                                //System.out.println(productos.get(i).toString());

                                //VERIFICA QUE NO ESTÉ EN LA LISTA DE COMPRA Y SI ESTÁ, AGREGA UNO EXTRA
                                for (int j = 0; j < productosVenta.size(); j++) {

                                    if (productosVenta.get(j).getProducto().equals(selectedProduct)) {

                                        if (productosVenta.get(j).getCantidad() < productos.get(i).getCantidad()) {
                                            System.out.println(productosVenta.get(j).getProducto() + productos.get(i).getProducto());
                                            equal = true;
                                            productosVenta.get(j).setCantidad(productosVenta.get(j).getCantidad() + 1);
                                            productosVenta.get(j).setTotal(productosVenta.get(j).getTotal() + productosVenta.get(j).getPrecio());
                                            productosVenta.get(j).toString();
                                        } else {
                                            JOptionPane.showMessageDialog(jfTienda, "No hay inventario", "Tienda", JOptionPane.WARNING_MESSAGE);
                                            System.out.println("2");
                                            equal = true;
                                        }
                                    }
                                }

                                if (equal == false) {
                                    productosVenta.add(new Producto(productos.get(i)));
                                }

                                //productosVenta.add(productos.get(i));
                                //System.out.println("BOTON: " + e.getButton());
                                refreshVenta();
                            } else {
                                JOptionPane.showMessageDialog(jfTienda, "No hay inventario", "Tienda", JOptionPane.WARNING_MESSAGE);
                                System.out.println("1");
                            }
                        }
                    }
                }

                if (e.getButton() == 3) {
                    for (int i = 0; i < productosVenta.size(); i++) {
                        if (selectedProduct == productosVenta.get(i).getProducto()) {
                            if (productosVenta.get(i).getCantidad() > 1) {
                                productosVenta.get(i).setCantidad(productosVenta.get(i).getCantidad() - 1);
                                productosVenta.get(i).setTotal(productosVenta.get(i).getTotal() - productosVenta.get(i).getPrecio());
                            } else {
                                productosVenta.remove(i);
                            }
                        }
                    }

                    refreshVenta();
                }

            }

        }

        if (e.getSource() == jfFacturas.jTblFacturas) {
            if (selectedIndexFactura != jfFacturas.jTblFacturas.getSelectedRow()) {//verifica que el renglon seleccionado sea diferente
                selectedIndexFactura = jfFacturas.jTblFacturas.getSelectedRow();
                //System.out.println(selectedIndex);

                selectedProduct = (String) jfFacturas.jTblFacturas.getValueAt(selectedIndexFactura, 0);

                for (int i = 0; i < facturas.size(); i++) {
                    if (facturas.get(i).getFecha() == null ? selectedProduct == null : facturas.get(i).getFecha().equals(selectedProduct)) {
                        jfFacturas.jTxtNombre.setText(String.valueOf(facturas.get(i).getNombre()));
                        jfFacturas.jTxtNombre.setEditable(false);
                        jfFacturas.jTxtCantidad.setText(String.valueOf(facturas.get(i).getCantidad()));
                        jfFacturas.jTxtCategoria.setText(String.valueOf(facturas.get(i).getCategoria()));

                    }
                }

                jfFacturas.jTxtNombre.requestFocus();
                jfFacturas.jBtnInput.setEnabled(false);

                jfFacturas.jBtnDelete.setEnabled(true);
                jfFacturas.jBtnModify.setEnabled(true);
            } else {//si no es diferente renglon, vuelve a los valores de inicio y deselecciona el renglon
                jfFacturas.jTxtSearch.setText("");
                selectedIndexFactura = -1;
                refreshFacturas();

            }
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void tableChanged(TableModelEvent e) {
        if (e.getSource() == jfTienda.jTblVentas.getModel()) {
            System.out.println(jfTienda.jTblVentas.getModel().getValueAt(jfTienda.jTblVentas.getSelectedRow(), jfTienda.jTblVentas.getSelectedColumn()-2));

            if (Integer.parseInt(String.valueOf(jfTienda.jTblVentas.getModel().getValueAt(e.getLastRow(), e.getColumn()))) > 0) {

                for (int i = 0; i < productos.size(); i++) {
                    if (productos.get(i).getProducto().equals(productosVenta.get(e.getLastRow()).getProducto())) {
                        System.out.println(productosVenta.get(e.getLastRow()).getCantidad());
                        System.out.println(productos.get(i).getCantidad());
                        if (Integer.parseInt((String) jfTienda.jTblVentas.getModel().getValueAt(jfTienda.jTblVentas.getSelectedRow(), jfTienda.jTblVentas.getSelectedColumn())) <= productos.get(i).getCantidad()) {
                            productosVenta.get(e.getLastRow()).setCantidad(Integer.parseInt(String.valueOf(jfTienda.jTblVentas.getModel().getValueAt(e.getLastRow(), e.getColumn()))));
                            productosVenta.get(e.getLastRow()).setTotal(productosVenta.get(e.getLastRow()).getPrecio() * productosVenta.get(e.getLastRow()).getCantidad());
                        } else if(jfTienda.jTblVentas.getModel().getValueAt(jfTienda.jTblVentas.getSelectedRow(), jfTienda.jTblVentas.getSelectedColumn()-2) == "Papeleria" || jfTienda.jTblVentas.getModel().getValueAt(jfTienda.jTblVentas.getSelectedRow(), jfTienda.jTblVentas.getSelectedColumn()-2) == "Otro"  ) {
                            productosVenta.get(e.getLastRow()).setCantidad(Integer.parseInt(String.valueOf(jfTienda.jTblVentas.getModel().getValueAt(e.getLastRow(), e.getColumn()))));
                            productosVenta.get(e.getLastRow()).setTotal(productosVenta.get(e.getLastRow()).getPrecio() * productosVenta.get(e.getLastRow()).getCantidad());
                        }else {
                            JOptionPane.showMessageDialog(jfTienda, "No hay inventario", "Tienda", JOptionPane.WARNING_MESSAGE);
                            refreshVenta();
                        }
                    }
                }

            } else {
                productosVenta.remove(e.getLastRow());
            }

            refreshVenta();
        }
    }

    public void refreshTotal() {
        double total = 0;

        for (int i = 0; i < productosVenta.size(); i++) {
            total += productosVenta.get(i).getTotal();
        }

        jfTienda.jLblTotal.setText("Total: $" + total);
    }

    private void vender(ActionEvent e) {
        leerArchivos();
        if (productosVenta.size() > 0) {
            ventas.add(new Venta(productosVenta, e.getWhen()));
            for (int i = 0; i < productosVenta.size(); i++) {

                for (int j = 0; j < productos.size(); j++) {
                    if (productosVenta.get(i).getProducto().equals(productos.get(j).getProducto()) && (String.valueOf(productosVenta.get(i).getProducto()).equals("Otro") || String.valueOf(productosVenta.get(i).getProducto()).equals("Papeleria"))) {
                        //System.out.println(jfTienda.jCBOpcionAgregar.getSelectedItem());
                        productos.get(j).setPrecio(productos.get(j).getPrecio() + productosVenta.get(i).getTotal());
                        //System.out.println("CACAMAX");
;
                    } else if (productosVenta.get(i).getProducto().equals(productos.get(j).getProducto())) {
                        productos.get(j).setCantidad(productos.get(j).getCantidad() - productosVenta.get(i).getCantidad());
                        productos.get(j).setVentas(productos.get(j).getVentas() + productosVenta.get(i).getCantidad());

                        break;
                    }
                }
            }

            productosVenta = new ArrayList();
            refreshVenta();
            refreshTienda();
            refreshAll();
            actualizarArchivos();
            //System.out.println(ventas.get(0).toString());
        } else {
            JOptionPane.showMessageDialog(jfProducto, "NO HAY PRODUCTOS SELECCIONADOS", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void leerArchivos() {
        this.productoDAO = new ProductoDAO();
        this.ventasDAO = new VentaDAO();
        this.facturaDAO = new FacturaDAO();

        //System.out.println(officeDAO.read().toString());
        //lee el archivo de las oficinas
        productos = productoDAO.read();
        ventas = ventasDAO.read();
        facturas = facturaDAO.read();

        refreshVenta();
        refreshTienda();
        refreshAll();
    }

    private void actualizarArchivos() {
        productoDAO.write(productos);
        ventasDAO.write(ventas);
        facturaDAO.write(facturas);
    }
}
