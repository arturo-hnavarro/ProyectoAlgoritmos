/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Data.AerolineaData;
import Data.Archivos;
import Domain.Aerolinea;
import Tda.Listas.ListaEnlazada;
import Tda.Listas.ListaException;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Arturo
 */
public class AerolineaDataTest implements Serializable {

    AerolineaData aerolineaData;
    Archivos arhivos;
    ListaEnlazada aerolineas;

    public AerolineaDataTest() {
        try {
            aerolineaData = new AerolineaData();
            arhivos = new Archivos("aerolineas.dat");
            this.aerolineas = new ListaEnlazada();
            cargar();
        } catch (IOException ex) {
            Logger.getLogger(AerolineaDataTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void cargar() throws IOException {
        this.aerolineas = (ListaEnlazada) arhivos.leerArchivo();

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void agregarAerolinea() throws ListaException, IOException {
        //ListaEnlazada aerolineas = (ListaEnlazada) arhivos.leerArchivo();

        ListaEnlazada telefonos = new ListaEnlazada();
        telefonos.insertar("2256-7070");
        telefonos.insertar("1234-5678");
        telefonos.insertar("4321-8247");
        telefonos.insertar("2548-1753");
        Aerolinea aerolinea = new Aerolinea("FlyEmirates2", "fly.com", telefonos, "correo@flyEmirates.com");

        if (!this.aerolineas.existe(aerolinea)) {
            aerolineaData.agregarAerolinea(aerolinea);
            this.aerolineas.insertar(aerolinea);
        }

//        ListaEnlazada telefonos2 = new ListaEnlazada();
//        telefonos2.insertar("8647-8247");
//        telefonos2.insertar("2222-8247");
//        telefonos2.insertar("2256-8247");
//        telefonos2.insertar("2548-8247");
//        Aerolinea aerolinea2 = new Aerolinea("Ethihad", "ethihad.com", telefonos2, "correo@ethihad.com");
//
//        if (!this.aerolineas.existe(aerolinea2)) {
//            aerolineaData.agregarAerolinea(aerolinea2);
//            this.aerolineas.insertar(aerolinea2);
//        }
//
//        //arhivos.escribirArchivo(aerolinea2);
//        ListaEnlazada telefonos3 = new ListaEnlazada();
//        telefonos3.insertar("8647-8247");
//        telefonos3.insertar("2222-8247");
//        telefonos3.insertar("2256-8247");
//        telefonos3.insertar("2548-8247");
//        Aerolinea aerolinea3 = new Aerolinea("Taca", "taca.com", telefonos3, "correo@taca.com");
//
//        if (!this.aerolineas.existe(aerolinea3)) {
//            aerolineaData.agregarAerolinea(aerolinea3);
//            this.aerolineas.insertar(aerolinea3);
//        }
//        arhivos.escribirArchivo(aerolineas);
    }
//    @Test
//    public void modificarAerolinea() {
//        try {
//            System.out.println("MODIFICAR\n\n");
//            //Aerolinea por modificar
//            ListaEnlazada telefonos = new ListaEnlazada();
//            telefonos.insertar("2256-7070");
//            telefonos.insertar("1234-5678");
//            telefonos.insertar("4321-8247");
//            telefonos.insertar("2548-1753");
//            Aerolinea aerolineaPorModificar = new Aerolinea(1, "siiiiii", "siiiii.com", telefonos, "correo@siiiiiiiiiiiii.com");
//
//            int n = busquedaBinariaIterativa(this.aerolineas, aerolineaPorModificar.getCodigo(), 1, this.aerolineas.getSize(),
//                    this.aerolineas.getSize());
//            if (n > 0) {
//                Aerolinea modificarPor = new Aerolinea(1, "Este es el nuevo nombre", "ahorasi.com", telefonos, "nuevoCorreomi@micorreo");
//                this.aerolineas.getNodo(n).setElemento(modificarPor);
//            }
//
//            arhivos.escribirArchivo(aerolineas);
//
//        } catch (ListaException ex) {
//            Logger.getLogger(AerolineaDataTest.class.getName()).log(Level.SEVERE, null, ex);
//        }

//    }
    @Test
    public void eliminarAerolinea(){
         try {
            System.out.println("ELIMINAR\n\n");
            //Aerolinea por modificar
            ListaEnlazada telefonos = new ListaEnlazada();
            telefonos.insertar("2256-7070");
            telefonos.insertar("1234-5678");
            telefonos.insertar("4321-8247");
            telefonos.insertar("2548-1753");
            Aerolinea eliminar = new Aerolinea(1, "Este es el nuevo nombre", "ahorasi.com", telefonos, "nuevoCorreomi@micorreo");

            int n = busquedaBinariaIterativa(this.aerolineas, eliminar.getCodigo(), 1, this.aerolineas.getSize(),
                    this.aerolineas.getSize());
            
            if (n > 0) {
                Aerolinea aerolineaActual = (Aerolinea) aerolineas.getNodo(n).elemento;
                 this.aerolineas.suprimir(aerolineaActual);
            }
           
            arhivos.escribirArchivo(aerolineas);

        } catch (ListaException ex) {
            Logger.getLogger(AerolineaDataTest.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }

    @Test
    public void leerAerolinea() {
        ListaEnlazada a;
        try {
            a = (ListaEnlazada) arhivos.leerArchivo();
            for (int i = 1; i <= a.getSize(); i++) {
                Aerolinea aerolinea = (Aerolinea) a.getNodo(i).elemento;
                System.out.println("aerolinea" + i + " " + aerolinea.toString() + "\n");
            }

        } catch (ListaException ex) {
            Logger.getLogger(AerolineaDataTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AerolineaDataTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int busquedaBinaria(ListaEnlazada A, int codigoBuscado, int i, int j) throws ListaException {
        int medio;
        if (i > j) {
            return 0;
        }
        medio = (i + j) / 2;
        Aerolinea a = (Aerolinea) A.getNodo(medio).elemento;
        if (a.getCodigo() < codigoBuscado) {
            return busquedaBinaria(A, codigoBuscado, medio + 1, j);
        } else if (a.getCodigo() > codigoBuscado) {
            return busquedaBinaria(A, codigoBuscado, i, medio - 1);
        } else {
            return medio;
        }
    }

    public int busquedaBinariaIterativa(ListaEnlazada A, int elemento, int bajo, int alto, int tamanio) throws ListaException {

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
