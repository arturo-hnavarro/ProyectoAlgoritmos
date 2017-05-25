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
        Aerolinea aerolinea = new Aerolinea("FlyEmirates", "fly.com", telefonos, "correo@flyEmirates.com");
        aerolineaData.agregarAerolinea(aerolinea);

        this.aerolineas.insertar(aerolinea);
        ListaEnlazada telefonos2 = new ListaEnlazada();
        telefonos2.insertar("8647-8247");
        telefonos2.insertar("2222-8247");
        telefonos2.insertar("2256-8247");
        telefonos2.insertar("2548-8247");
        Aerolinea aerolinea2 = new Aerolinea("Ethihad", "ethihad.com", telefonos2, "correo@ethihad.com");
        aerolineaData.agregarAerolinea(aerolinea2);
        this.aerolineas.insertar(aerolinea2);

        //arhivos.escribirArchivo(aerolinea2);
        ListaEnlazada telefonos3 = new ListaEnlazada();
        telefonos3.insertar("8647-8247");
        telefonos3.insertar("2222-8247");
        telefonos3.insertar("2256-8247");
        telefonos3.insertar("2548-8247");
        Aerolinea aerolinea3 = new Aerolinea("Taca", "taca.com", telefonos3, "correo@taca.com");
        this.aerolineas.insertar(aerolinea3);
      
        arhivos.escribirArchivo(aerolineas);
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
//            Aerolinea modificarPor = new Aerolinea(1, "Este es el nuevo nombre", "ahorasi.com", telefonos, "nuevoCorreomi@micorreo");
//            
//            for (int i = 1; i <= aerolineas.getSize(); i++) {
//                Aerolinea aerolineaActual = (Aerolinea) aerolineas.getNodo(i).elemento;
//                System.out.println("aeroActual "+aerolineaActual.getCodigo());
//                
//                if (aerolineaPorModificar.getCodigo() == aerolineaActual.getCodigo()) {
//                    this.aerolineas.getNodo(i).setElemento(modificarPor);
//                    i=aerolineas.getSize();
//                }
//            }
//            arhivos.escribirArchivo(aerolineas);
//
//        } catch (ListaException ex) {
//            Logger.getLogger(AerolineaDataTest.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//
//    }

//    @Test
//    public void eliminarAerolinea(){
//         try {
//            System.out.println("ELIMINAR\n\n");
//            //Aerolinea por modificar
//            ListaEnlazada telefonos = new ListaEnlazada();
//            telefonos.insertar("2256-7070");
//            telefonos.insertar("1234-5678");
//            telefonos.insertar("4321-8247");
//            telefonos.insertar("2548-1753");
//            Aerolinea aerolineaPorModificar = new Aerolinea(1, "siiiiii", "siiiii.com", telefonos, "correo@siiiiiiiiiiiii.com");
//
//            
//            
//            for (int i = 1; i <= aerolineas.getSize(); i++) {
//                Aerolinea aerolineaActual = (Aerolinea) aerolineas.getNodo(i).elemento;
//                System.out.println("aeroActual "+aerolineaActual.getCodigo());
//                
//                if (aerolineaPorModificar.getCodigo() == aerolineaActual.getCodigo()) {
//                    this.aerolineas.suprimir(aerolineaActual);
//                    i=aerolineas.getSize();
//                }
//            }
//            arhivos.escribirArchivo(aerolineas);
//
//        } catch (ListaException ex) {
//            Logger.getLogger(AerolineaDataTest.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//        
//    }
    
    
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

}
