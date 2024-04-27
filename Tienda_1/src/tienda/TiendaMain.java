/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tienda;

import java.io.IOException;
import tienda.controller.Controller;
import tienda.model.FacturaDAO;
import tienda.model.ProductoDAO;
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
public class TiendaMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        JFProducto jfProducto = new JFProducto ();
        JFTienda jfTienda = new JFTienda();
        JFHistorial jfHistorial = new JFHistorial();
        JFFacturas jfFacturas = new JFFacturas();
        JFExportar jfExportar = new JFExportar();
        
        ProductoDAO productoDAO = new ProductoDAO();
        VentaDAO ventaDAO = new VentaDAO();
        FacturaDAO facturaDAO = new FacturaDAO();
        
        
        Controller controlador = new Controller (jfProducto, productoDAO, jfTienda, ventaDAO, jfHistorial, jfFacturas, facturaDAO, jfExportar);
        
        jfProducto.setLocationRelativeTo(jfProducto);
        jfProducto.setTitle("PAPELERIA");
        jfProducto.setVisible(false);
        
        jfHistorial.setLocationRelativeTo(jfHistorial);
        jfHistorial.setTitle("PAPELERIA");
        jfHistorial.setVisible(false);
        
        jfFacturas.setLocationRelativeTo(jfFacturas);
        jfFacturas.setTitle("PAPELERIA");
        jfFacturas.setVisible(false);
        
        jfExportar.setLocationRelativeTo(jfExportar);
        jfExportar.setResizable(false);
        jfExportar.setTitle("PAPELERIA");
        jfExportar.setVisible(false);
        
        jfTienda.setLocationRelativeTo(jfTienda);
        jfTienda.setTitle("PAPELERIA");
        jfTienda.setVisible(true);
        
    }
    
}
