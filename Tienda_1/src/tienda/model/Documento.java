/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda.model;

import java.util.ArrayList;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author heber
 */
public class Documento {
    
    ArrayList<Double> datos;

    public Documento(ArrayList<Double> datos) {
        this.datos = datos;
    }

    public ArrayList<Double> getDatos() {
        return datos;
    }
    
    public void exportar (String modo){
        try {
            String ruta = "Cuentas " + modo + new SimpleDateFormat("dd-MM-yyyy").format(new Date(System.currentTimeMillis())) + ".txt";
            String contenido = "Se exportó " + modo + " el " + (new SimpleDateFormat("dd-MM-yyyy").format(new Date(System.currentTimeMillis()))) + "\n" + "Total de Facturas: " + datos.get(0) + "\n" + "Total de Ventas: " + datos.get(1) + "\nGanancia: " + datos.get(2);
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    /*
    
    public void exportar(String modo) throws IOException{
        WordDocument documento = new WordDocument();
        Run run = new Run();
        Paragraph paragraph = new Paragraph();
        
        System.out.println(datos.toString());
        run.addText("Se exportó " + modo + " el " + new SimpleDateFormat("dd-MM-yyyy").format(new Date(System.currentTimeMillis())));
        paragraph.add(run);
        documento.getBody().add(paragraph);
        
        run = new Run();
        paragraph = new Paragraph();
        run.addText("Total de Facturas: " + datos.get(0));
        paragraph.add(run);
        documento.getBody().add(paragraph);
        
        run = new Run();
        paragraph = new Paragraph();
        run.addText("Total de Ventas: " + datos.get(1));
        paragraph.add(run);
        documento.getBody().add(paragraph);
        
        run = new Run();
        paragraph = new Paragraph();
        run.addText("Ganancia: " + datos.get(2));
        paragraph.add(run);
        documento.getBody().add(paragraph);
        
        documento.save("Cuentas " + modo + new SimpleDateFormat("dd-MM-yyyy").format(new Date(System.currentTimeMillis())) + ".docx", true);
        
    }
    */
}
