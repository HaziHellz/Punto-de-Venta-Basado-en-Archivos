/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda.model;

/**
 *
 * @author heber
 */
public class Apartado {
    String nombreDueno;
    String descripcion;
    double costoTotal;
    double pagado;
    double restante;

    public Apartado(String nombreDueno, String descripcion, double costoTotal, double pagado) {
        this.nombreDueno = nombreDueno;
        this.descripcion = descripcion;
        this.costoTotal = costoTotal;
        this.pagado = pagado;
    }

    public String getNombreDueno() {
        return nombreDueno;
    }

    public void setNombreDueno(String nombreDueno) {
        this.nombreDueno = nombreDueno;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public double getPagado() {
        return pagado;
    }

    public void setPagado(double pagado) {
        this.pagado = pagado;
    }

    public double getRestante() {
        return restante;
    }

    public void setRestante(double restante) {
        this.restante = restante;
    }
    
    
    
    
}
