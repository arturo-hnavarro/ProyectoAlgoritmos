/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Archivos {

    ObjectOutputStream oos;
    ObjectInputStream ois;
    private String nombreArchivo;
    
      private File file;
    

    public Archivos() {
    }
    
    public Archivos(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
        this.file = new File(nombreArchivo);
    }
    
    public void escribirArchivo(Object objeto) {
        try {
            oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            oos.writeObject(objeto);
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Object leerArchivo() {
        Object retorno = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(nombreArchivo));
            retorno = ois.readObject();
            ois.close();
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);

        }
        return retorno;
    }
    
    
    
    
    public void escribirArchivo(Object objeto, String nombreArchivo) {
        try {
            oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            oos.writeObject(objeto);
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Object leerArchivo(String nombreArchivo) {
        Object retorno = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(nombreArchivo));
            retorno = ois.readObject();
            ois.close();

        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);

        }
        return retorno;
    }
}
