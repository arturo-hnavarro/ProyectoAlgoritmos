package Data;

import Domain.Aerolinea;
import Tda.Listas.ListaEnlazada;
import Tda.Listas.ListaException;
import java.io.File;
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
    String nombreArchivo = "aerolineas.dat";
    File file = new File("aerolineas.dat");

    public Archivos(String nombreArchivo) throws IOException {
    }

    public void escribirArchivo(ListaEnlazada aerolineas) throws ListaException {

        try {
            oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo, false));
            int n = aerolineas.getSize();
            for (int i = 1; i <= n; i++) {
                oos.writeObject((Aerolinea)aerolineas.getNodo(i).elemento);
            }
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null + " error al escribir", ex);
        }
    }

    public Object leerArchivo() throws IOException {
        ListaEnlazada aerolineas = new ListaEnlazada();
        Aerolinea retorno = new Aerolinea();
        ois = new ObjectInputStream(new FileInputStream(nombreArchivo));
        try {
            retorno = (Aerolinea) ois.readObject();
            while (retorno != null) {
                aerolineas.insertar(retorno);
                retorno = (Aerolinea) ois.readObject();

            }
            ois.close();
            
        } catch (IOException ex) {
            //Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null + "IOEasdf", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return aerolineas;
    }

}
