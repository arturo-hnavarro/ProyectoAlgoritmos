package Data;

import Domain.Aerolinea;
import Tda.Listas.ListaEnlazada;
import Tda.Listas.Nodo;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arelys Granados
 */
public class Archivos implements Serializable {

    ObjectOutputStream oos;
    ObjectInputStream ois;

    public void escribirArchivo(Object elemento, String nombreArchivo) {

        try {
            oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo,true));
            oos.writeObject((Aerolinea)elemento);
            oos.close();
            System.out.println("Escribio");
        } catch (IOException ex) {
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null + "error al escribir", ex);
        }
    }

    public Object leerArchivo(String nombreArchivo) {
        ListaEnlazada aerolineas = new ListaEnlazada();
        Aerolinea retorno = null;
        
        try {
            ois = new ObjectInputStream(new FileInputStream(nombreArchivo));
            retorno =(Aerolinea) ois.readObject();
            aerolineas.insertar(retorno);

            while (retorno != null) {
                
                retorno =(Aerolinea) ois.readObject();
                System.out.println("Estoy en leerArchivo: " );
                aerolineas.insertar(retorno);
                
            }
            ois.close();

        } catch (IOException ex) {
//            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null + "IOE", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aerolineas;
    }
    
}
