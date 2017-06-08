/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dominio.Aerolinea;
import Logica.Utilidades;
import TDA.lista.ListaCircularEnlazadaDoble;
import TDA.lista.ListaEnlazada;
import TDA.lista.ListaException;
import java.awt.print.PrinterException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import logica.AerolineaData;
import dominio.Agencia;
import logica.AgenciaData;
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
public class AgenciaTest {

    AgenciaData agenciaData;

    public AgenciaTest() {
        try {
            agenciaData = new AgenciaData("agencias.dat");
        } catch (IOException ex) {
            Logger.getLogger(AgenciaTest.class.getName()).log(Level.SEVERE, null, ex);
        }

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
    public void hello() throws IOException, PrinterException {
        ListaEnlazada telefonos = new ListaEnlazada();
        telefonos.insertar("2540-1753");
        ListaEnlazada aerolineas = new ListaEnlazada();
        Aerolinea a = new Aerolinea(3, "DesinosTV", "destinostv.com",telefonos.toString(), "destinos@tv.com");
        aerolineas.insertar(a);

        Agencia ag = new Agencia("arturo", "Cartago", telefonos, "correo@algo.com", aerolineas);
       
//            agrego la agencia
//            agenciaData.agregarAgencia(ag);

            //modifico
//            Agencia agMod = new Agencia("cambio", "san jose", telefonos, "nuevo@algo.com", aerolineas);
////            agenciaData.eliminarAgencia(agMod);
            
            
            leerAgencias();
            
             JTextArea jta = new JTextArea( ag.toString()  );
        jta.print();
            
//            imprimirTest();

    }

    private void leerAgencias() {
        System.out.println("leyendo....");
        try {
            ListaCircularEnlazadaDoble l = agenciaData.obtenerTodasLasAgencias();
            System.out.println("l " + l.getSize());
            for (int i = 1; i <= l.getSize(); i++) {
                System.out.println(l.getNodo(i).elemento.toString());

            }

        } catch (IOException ex) {
            Logger.getLogger(AgenciaTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ListaException ex) {
            Logger.getLogger(AgenciaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//    @Test
    public void imprimirTest() throws IOException, PrinterException{
        String texto =agenciaData.obtenerTodasLasAgencias().toString();
        System.out.println("antes de llamar a imprimir\n"+texto);
        JTextArea jta = new JTextArea(texto);
        jta.print();
        //Utilidades.imprimir(texto);
    }

}
