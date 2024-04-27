/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author heber
 */
public class Factura implements Serializable, Comparable{
    private double cantidad;
    private String nombre;
    private String fecha;
    private int categoria;
    long timeStamp;
    
    public Factura(double cantidad, String nombre, long timeStamp, int categoria) {
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.timeStamp = timeStamp;
        this.categoria = categoria;
        fecha = new SimpleDateFormat("dd-MM-yy hh:mm:ss").format(new Date(timeStamp));
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public double getCantidad() {
        return cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public int compareTo(Object o) {
        Factura factura = (Factura) o;
        if (factura.getTimeStamp() < timeStamp ) {
            return 0;
        }else{
            return 1;
        }
    }
    
    
    
    
}
