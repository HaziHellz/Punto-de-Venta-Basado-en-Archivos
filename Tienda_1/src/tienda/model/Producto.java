/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda.model;

import java.io.Serializable;
import java.util.Comparator;

/**
 *
 * @author heber
 */
public class Producto implements Serializable, Comparable{
    private String producto;
    private int cantidad;
    private double precio;
    private int ventas;
    private int categoria;
    private double total;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Producto(String producto, int cantidad, double precio, int categoria) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.categoria = categoria;
    }
    
    public Producto(Producto producto){
        this.precio = producto.precio;
        this.cantidad = 1;
        this.producto = producto.getProducto();
        this.total = producto.precio;
        this.categoria = producto.getCategoria();
    }

    public String getProducto (){
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public int getVentas() {
        return ventas;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Producto{" + "producto = " + producto + ", cantidad = " + cantidad + ", precio = " + precio + ", ventas = " + ventas + ", categoria = " + categoria + "}\n";
    }

    /*
    @Override
    public String compareTo(Object o) {
        Producto that = (Producto) o;
        String p1 = this.getProducto();
        String p2 = that.getProducto();

       if (p1 > p2) {
           return 1;
       } else if (p1 < p2){
           return -1;
       } else {
           return 0;
       }
    }
    */

    @Override
    public int compareTo(Object o) {
        Producto dos = (Producto) o;
        return this.getProducto().compareTo(dos.getProducto());
    }
}
