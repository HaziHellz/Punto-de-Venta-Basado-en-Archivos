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
public class VentaDAO {
    
    ObjectOutputStream output;
    ObjectInputStream input;
    
    public void write(ArrayList<Venta> ventas){
        writeArchive();
        Venta venta;
       // System.out.print(offices.size());
        for (int i = 0; i < ventas.size(); i++) {
            venta = (Venta) ventas.get(i);
            try {
                if (venta != null){
                    output.writeObject((Venta) ventas.get(i));
                }
            } catch (IOException e) {
                System.out.println("Error al write()" + e);
            }
        }  
        closeWrite();
    }
    
    public ArrayList<Venta> read(){
        readArchive();
        ArrayList<Venta> ventas = new ArrayList();
        Venta venta;
        
        boolean left = true;
        do{
            try{
                venta = (Venta) input.readObject();
                //System.out.println("aa");
                if (venta != null) {
                    ventas.add(venta);
                }else{
                    left = false;
                }
            } catch (Exception ex) {
                left = false;
            }
        }while(left);
        
        closeRead();
        return ventas;
    }
    
    
    public void readArchive() {
        try {
            input = new ObjectInputStream(new FileInputStream("sells.of"));
        } catch (IOException e) {
            System.err.println("Error al leer el archivo");
        }
    }
    
    public void writeArchive() {
        try {
            output = new ObjectOutputStream(new FileOutputStream("sells.of"));
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
