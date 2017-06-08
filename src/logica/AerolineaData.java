package logica;

import Archivos.Archivos;
import Interfaz.JIF_Aerolinea;
import TDA.lista.ListaEnlazada;
import TDA.lista.ListaException;
import dominio.Aerolinea;

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
 * @author Arturo
 */
public class AerolineaData extends Archivos implements Serializable {

    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private String nombreArchivo;
    private File file;
    private ListaEnlazada aerolineas;

    public AerolineaData(String nombreArchivo) throws IOException, ClassNotFoundException, ListaException {
        super(nombreArchivo);
        this.nombreArchivo = nombreArchivo;
        this.file = new File(nombreArchivo);
        aerolineas = (ListaEnlazada)leerArchivo();
    }

    public int getCodigoUltimaAerolinea() throws ListaException {
        //obtengo el codigo de la ultima aeronilinea para mantener el consecutivo    
        if (aerolineas.isEmpty()) {
            return 0;
        }
        Aerolinea ultima = (Aerolinea) aerolineas.getNodo(aerolineas.getSize()).getElemento();
        return ultima.getCodigo();
    }

    public boolean agregarAeorlinea(Aerolinea aerolinea) throws IOException, ClassNotFoundException {
        if (this.aerolineas.isEmpty()) {
            aerolineas.insertar(aerolinea);
            escribirArchivo(aerolineas);
        }
        if (!this.aerolineas.existe(aerolinea)) {
            this.aerolineas.insertar(aerolinea);
            escribirArchivo(aerolineas);
        } else {
            return false;
        }
        return true;
    }

     public void modificarAerolinea(Aerolinea aerolineaModificada, int codigo) throws ListaException, IOException {
        //aerolineaModificada son los atributos que se cambian
        //int codigo, es el código de la aerolinea que está registrada en la ListaEnlazada
        int posicion = busquedaBinariaIterativa(this.aerolineas, codigo, 1, this.aerolineas.getSize());//Ubica la posición en la lista
        if (posicion > 0) {
            this.aerolineas.getNodo(posicion).setElemento(aerolineaModificada);
            escribirArchivo(aerolineas);
        }
    }
    
    public void eliminarAerolinea(Aerolinea aerolinea) throws ListaException, IOException {
        int posicion = busquedaBinariaIterativa(this.aerolineas, aerolinea.getCodigo(), 1, this.aerolineas.getSize());
        if (posicion > 0) {
            Aerolinea aerolineaActual = (Aerolinea) aerolineas.getNodo(posicion).elemento;
            this.aerolineas.suprimir(aerolineaActual);
            escribirArchivo(aerolineas);
        }
    }
    
    //Utilitarios
//    private ListaEnlazada leerArchivo() throws IOException, ClassNotFoundException {
//        ListaEnlazada aerolineas = new ListaEnlazada();
//        if (this.file.exists()) {
//            ois = new ObjectInputStream(new FileInputStream(nombreArchivo));
//            aerolineas = (ListaEnlazada) ois.readObject();
//            ois.close();
//        }
//        return aerolineas;
//    }

    private void escribirArchivo(ListaEnlazada aerolineas) throws IOException {
        oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo, false));
        oos.writeObject(aerolineas);
        oos.close();
    }

    public String[][] getMostrarAerolineas() throws ListaException, IOException, ClassNotFoundException {
        //Actualizo la ListaEnlazada
        aerolineas.anular();
        aerolineas = (ListaEnlazada)leerArchivo();

        int totalAerolineas = aerolineas.getSize();
        String[][] mostrarAerolineas = new String[totalAerolineas][5];

        for (int i = 1; i <= totalAerolineas; i++) {
            Aerolinea aerolineaActual = (Aerolinea) aerolineas.getNodo(i).getElemento();
            mostrarAerolineas[i - 1][0] = "" + aerolineaActual.getCodigo();
            mostrarAerolineas[i - 1][1] = aerolineaActual.getNombre();
            mostrarAerolineas[i - 1][2] = aerolineaActual.getSitioWeb();
            mostrarAerolineas[i - 1][3] = aerolineaActual.getTelefono();
            mostrarAerolineas[i - 1][4] = aerolineaActual.getCorreo();
        }
        return mostrarAerolineas;
    }

    private int busquedaBinariaIterativa(ListaEnlazada A, int elemento, int bajo, int alto) throws ListaException {
        int central;
        while (bajo <= alto) {
            //determina el elemento central
            central = (bajo + alto) / 2;
            Aerolinea a = (Aerolinea) A.getNodo(central).elemento;
            if (elemento == a.getCodigo()) {
                return central;
            } else if (elemento < a.getCodigo()) {
                alto = central - 1;
            } else {
                bajo = central + 1;
            }
        }//while
        return 0;
    }
}
