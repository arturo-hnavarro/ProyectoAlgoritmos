package logica;

import dominio.Agencia;
import Archivos.Archivos;
import TDA.lista.ListaCircularEnlazadaDoble;
import TDA.lista.ListaException;
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
public class AgenciaData implements Serializable {

    ListaCircularEnlazadaDoble agencias;
    ObjectOutputStream oos;
    ObjectInputStream ois;
    String nombreArchivo;
    File file;

    public AgenciaData(String nombreArchivo) throws IOException {
        this.nombreArchivo = nombreArchivo;
        this.file = new File(nombreArchivo);
        agencias = leerArchivo();

    }

    public void agregarAgencia(Agencia agencia) throws ListaException, IOException {

        if (this.agencias.isEmpty()) {
            agencias.insertar(agencia);
            escribirArchivo(agencias);
        }

        if (!this.agencias.existe(agencia)) {
            this.agencias.insertar(agencia);
            escribirArchivo(agencias);
        } else {
            System.out.println("No se puede agregar, ya existe");
        }

    }//agregarAgencia

    public void eliminarAgencia(Agencia agencia) throws ListaException, IOException {

        int posicion = busquedaBinariaIterativa(this.agencias, agencia.getCodigo(), 1, this.agencias.getSize());
        if (posicion > 0) {
            Agencia agenciaActual = (Agencia) agencias.getNodo(posicion).elemento;
            this.agencias.suprimir(agenciaActual);
            escribirArchivo(agencias);
        }
    }

    public void modificarAgencia(Agencia agenciaModificada, int codigo) throws ListaException, IOException {
        //agenciaModificada son los atributos que se cambian
        //int codigo, es el código de la agencia que está registrada en la ListaCircularEnlazadaDoble

        int posicion = busquedaBinariaIterativa(this.agencias, codigo, 1, this.agencias.getSize());//Ubica la posición en la lista
        if (posicion > 0) {
            this.agencias.getNodo(posicion).setElemento(agenciaModificada);
            escribirArchivo(agencias);
        }
    }

    public ListaCircularEnlazadaDoble obtenerTodasLasAgencias() throws IOException {
        return this.agencias;
    }

    //METODOS UTILITARIOS
    private int busquedaBinariaIterativa(ListaCircularEnlazadaDoble A, int elemento, int bajo, int alto) throws ListaException {
        int central;
        while (bajo <= alto) {
            //determina el elemento central
            central = (bajo + alto) / 2;
            Agencia a = (Agencia) A.getNodo(central).elemento;
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
    private void escribirArchivo(ListaCircularEnlazadaDoble agencias) throws ListaException, IOException {

        oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo, false));
        int n = agencias.getSize();
        for (int i = 1; i <= n; i++) {
            Agencia temp = (Agencia) agencias.getNodo(i).elemento;
            oos.writeObject(temp);
        }
        oos.close();
    }

    private ListaCircularEnlazadaDoble leerArchivo() throws IOException {
        if (this.file.exists()) {
            ListaCircularEnlazadaDoble agencias = new ListaCircularEnlazadaDoble();
            Agencia retorno = new Agencia();
            ois = new ObjectInputStream(new FileInputStream(nombreArchivo));
            try {
                retorno = (Agencia) ois.readObject();
                while (retorno != null) {
                    agencias.insertar(retorno);
                    retorno = (Agencia) ois.readObject();
                }
                ois.close();
            } catch (IOException ex) {
                //Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null + "IOEasdf", ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
            }
            return agencias;
        }
        return new ListaCircularEnlazadaDoble();

    }

}
