package Data;

import Domain.Aerolinea;
import Tda.Listas.ListaEnlazada;
import Tda.Listas.ListaException;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arturo
 */
public class AerolineaData implements Serializable {

    Archivos arhivos;
    ListaEnlazada aerolineas;

    public AerolineaData() throws IOException {

        arhivos = new Archivos("aerolineas.dat");
        this.aerolineas = new ListaEnlazada();
        cargar();

    }

    public void agregarAerolinea(Aerolinea aerolinea) throws ListaException {

        if (!this.aerolineas.existe(aerolinea)) {
            this.aerolineas.insertar(aerolinea);
            arhivos.escribirArchivo(aerolineas);
        }
    }//agregarAerolinea

    public void eliminarAerolinea(Aerolinea aerolinea) throws ListaException {
        
        int posicion = busquedaBinariaIterativa(this.aerolineas, aerolinea.getCodigo(), 1, this.aerolineas.getSize());
        if (posicion > 0) {
            Aerolinea aerolineaActual = (Aerolinea) aerolineas.getNodo(posicion).elemento;
            this.aerolineas.suprimir(aerolineaActual);
            arhivos.escribirArchivo(aerolineas);
        }
    }

    public void modificarAerolinea(Aerolinea aerolineaModificada, int codigo) throws ListaException {
        //aerolineaModificada son los atributos que se cambian
        //int codigo, es el código de la aerolinea que está registrada en la ListaEnlazada

        int posicion = busquedaBinariaIterativa(this.aerolineas, codigo, 1, this.aerolineas.getSize());//Ubica la posición en la lista
        if (posicion > 0) {
            this.aerolineas.getNodo(posicion).setElemento(aerolineaModificada);
            arhivos.escribirArchivo(aerolineas);
        }
    }

    public ListaEnlazada obtenerTodasLasAerolineas() {
        return aerolineas;
    }

    //METODOS UTILITARIOS
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

    //CRUD
    private void cargar() throws IOException {
        this.aerolineas = (ListaEnlazada) arhivos.leerArchivo();

    }
}
