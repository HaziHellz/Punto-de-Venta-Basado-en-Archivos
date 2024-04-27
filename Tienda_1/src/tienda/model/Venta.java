/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author heber
 */
public class Venta implements Comparable, Serializable{
    ArrayList <Producto> venta;
    double total = 0;
    Long fecha;
    Date fechaF;
    String date;
    private String articulos = "";
    
    public Venta(ArrayList<Producto> venta, Long fecha) {
        this.venta = venta;
        this.fecha = fecha;
        this.fechaF = new Date(fecha);
        this.date = new SimpleDateFormat("dd-MM-yy HH:mm:ss").format(fechaF);
        for (int i = 0; i < venta.size(); i++) {
            total += venta.get(i).getTotal();
            if (i < venta.size() - 1) {
                articulos += venta.get(i).getProducto() + ", ";
            }else{
                articulos += venta.get(i).getProducto() + ".";
            }
        }
       
    }

    public String getDate() {
        return date;
    }

    public String getArticulos() {
        return articulos;
    }
    
    public Long getFecha() {
        return fecha;
    }
 
    public double getTotal() {
        return total;
    }
    
    public void actualizarTotal(){
        total = 0;
        for (int i = 0; i < venta.size(); i++) {
            total += venta.get(i).getTotal();
        }
    }

    public ArrayList<Producto> getVenta() {
        return venta;
    }

    public void setVenta(ArrayList<Producto> venta) {
        this.venta = venta;
    }
    
    @Override
    public String toString(){
        String toString = "Venta {\n";
        for (int i = 0; i < venta.size(); i++) {
            
            if (i < venta.size() - 1) {
                toString = toString + "{producto: " + venta.get(i).getProducto() + ", cantidad: " + venta.get(i).getCantidad() + ", precio U: " + venta.get(i).getPrecio() + ", total P: " + venta.get(i).getTotal() + "},\n";
            }else{
                toString = toString + "{producto: " + venta.get(i).getProducto() + ", cantidad: " + venta.get(i).getCantidad() + ", precio U: " + venta.get(i).getPrecio() + ", total P: " + venta.get(i).getTotal() + "} ||| TOTAL: " + getTotal() + "}";
            }
        }
        
        return toString;
    }

    @Override
    public int compareTo(Object o) {
        Venta dos = (Venta) o;
        
        return dos.getFecha().compareTo(fecha);
    }
}
