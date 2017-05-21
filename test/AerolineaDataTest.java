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
public class AerolineaDataTest {

    AerolineaData aerolineaData;
    Archivos arhivos;

    public AerolineaDataTest() {
        aerolineaData = new AerolineaData();
        arhivos = new Archivos();
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
//    @Test
//    public void agregarAerolinea() throws ListaException {
//
//        ListaEnlazada telefonos = new ListaEnlazada();
//        telefonos.insertar("8647-8247");
//        telefonos.insertar("2222-8247");
//        telefonos.insertar("2256-8247");
//        telefonos.insertar("2548-8247");
//        Aerolinea aerolinea = new Aerolinea("FlyEmirates", "flyemirates.com", telefonos, "correo@flyemirates.com");
//        aerolineaData.agregarAerolinea(aerolinea);
//        
//        arhivos.escribirArchivo(aerolinea, "aerolineas.dat");
//        
//        ListaEnlazada telefonos2 = new ListaEnlazada();
//        telefonos2.insertar("8647-8247");
//        telefonos2.insertar("2222-8247");
//        telefonos2.insertar("2256-8247");
//        telefonos2.insertar("2548-8247");
//        Aerolinea aerolinea2 = new Aerolinea("Etihad", "ethihad.com",telefonos2,  "correo@ethihad.com");
//        aerolineaData.agregarAerolinea(aerolinea2);
//        
//        arhivos.escribirArchivo(aerolinea2, "aerolineas.dat");
//        ListaEnlazada telefonos3 = new ListaEnlazada();
//        telefonos3.insertar("8647-8247");
//        telefonos3.insertar("2222-8247");
//        telefonos3.insertar("2256-8247");
//        telefonos3.insertar("2548-8247");
//        Aerolinea aerolinea3 = new Aerolinea("Taca", "taca.com", telefonos3, "correo@taca.com");
//        aerolineaData.agregarAerolinea(aerolinea3);
//        
//        arhivos.escribirArchivo(aerolinea3, "aerolineas.dat");
//    }
    
    @Test
    public void leerAerolinea(){
//        Aerolinea a = (Aerolinea)arhivos.leerArchivo("aerolineas.dat") ;
        ListaEnlazada a = (ListaEnlazada)arhivos.leerArchivo("aerolineas.dat") ;
        try {
            //        System.out.println(a.toString());
            for (int i = 1; i <= a.getSize(); i++) {
                Aerolinea aerolinea = (Aerolinea)a.getNodo(i).elemento;
                System.out.println("aerolinea"+i+" "+aerolinea.toString()+"\n");
            }
        } catch (ListaException ex) {
            Logger.getLogger(AerolineaDataTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
