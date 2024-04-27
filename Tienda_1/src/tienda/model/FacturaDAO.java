/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author heber
 */
public class FacturaDAO {
    ObjectOutputStream output;
    ObjectInputStream input;
    
    public void write(ArrayList<Factura> facturas){
        writeArchive();
        Factura factura;
       // System.out.print(offices.size());
        for (int i = 0; i < facturas.size(); i++) {
            factura = (Factura) facturas.get(i);
            try {
                if (factura != null){
                    output.writeObject((Factura) facturas.get(i));
                }
            } catch (IOException e) {
                System.out.println("Error al write()" + e);
            }
        }  
        closeWrite();
    }
    
    public ArrayList<Factura> read(){
        readArchive();
        ArrayList<Factura> facturas = new ArrayList();
        Factura factura;
        
        boolean left = true;
        do{
            try{
                factura = (Factura) input.readObject();
                //System.out.println("aa");
                if (factura != null) {
                    facturas.add(factura);
                }else{
                    left = false;
                }
            } catch (Exception ex) {
                left = false;
            }
        }while(left);
        
        closeRead();
        return facturas;
    }
    
    
    public void readArchive() {
        try {
            input = new ObjectInputStream(new FileInputStream("facturas.of"));
        } catch (IOException e) {
            System.err.println("Error al leer el archivo");
        }
    }
    
    public void writeArchive() {
        try {
            output = new ObjectOutputStream(new FileOutputStream("facturas.of"));
        } catch (IOException e) {
            System.err.println("Error al abrir el archivo");
            
        }
    }
    
    public void closeRead() {
        try {
            if (input != null) {
                input.close();
            }
        } catch (IOException e) {
            System.err.println("Error al cerrar el archivo de input");
            System.exit(1);
        }
    }

    public void closeWrite() {
        try {
            if (output != null) {
                output.close();
            }
        } catch (IOException e) {
            System.err.println("Error al cerrar el archivo de output");
            System.exit(1);
        }
    }
    
}
