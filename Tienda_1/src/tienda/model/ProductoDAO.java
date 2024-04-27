/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda.model;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author heber
 */
public class ProductoDAO {
    
    ObjectOutputStream output;
    ObjectInputStream input;
    
    public void write(ArrayList<Producto> productos){
        writeArchive();
        Producto producto;
       // System.out.print(offices.size());
        for (int i = 0; i < productos.size(); i++) {
            producto = (Producto) productos.get(i);
            try {
                if (producto != null){
                    output.writeObject((Producto) productos.get(i));
                }
            } catch (IOException e) {
                System.out.println("Error al write()" + e);
            }
        }  
        closeWrite();
    }
    
    public ArrayList<Producto> read(){
        readArchive();
        ArrayList<Producto> products = new ArrayList();
        Producto product;
        
        boolean left = true;
        do{
            try{
                product = (Producto) input.readObject();
                //System.out.println("aa");
                if (product != null) {
                    products.add(product);
                }else{
                    left = false;
                }
            } catch (Exception ex) {
                left = false;
            }
        }while(left);
        
        closeRead();
        return products;
    }
    
    
    public void readArchive() {
        try {
            input = new ObjectInputStream(new FileInputStream("products.of"));
        } catch (IOException e) {
            System.err.println("Error al leer el archivo");
        }
    }
    
    public void writeArchive() {
        try {
            output = new ObjectOutputStream(new FileOutputStream("products.of"));
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
