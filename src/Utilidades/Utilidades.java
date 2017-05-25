package Utilidades;

import Domain.Aerolinea;
import Tda.Listas.ListaEnlazada;



/**
 *
 * @author Arturo
 */
public class Utilidades {
//
//    public static boolean esMayorQ(Object a, Object b) {
//        switch (instanceOf(a, b)) {
//            case "entero":
//                int x = (int) a;
//                int y = (int) b;
//                return x > y;
//            case "string":
//                String p = (String) a;
//                String q = (String) b;
//                return p.compareToIgnoreCase(q) > 0;
//            case "persona":
//                Persona r = (Persona) a;
//                Persona s = (Persona) b;
//                return r.getNombre().compareToIgnoreCase(s.getNombre()) > 0;
//        }//switch
//        return false;
//    }
//
//    //Este metodo devuelve el tipo almacenado en la lista enlazada
//    private static String instanceOf(Object a, Object b) {
//        if (a instanceof Integer && b instanceof Integer) {
//            return "entero";
//        }
//        if (a instanceof String && b instanceof String) {
//            return "string";
//        }
//        if (a instanceof Persona && b instanceof Persona) {
//            return "persona";
//        }
//        return "desconocido";
//    }
    
    //Este metodo devuelve el tipo de objeto recibido en es
    public static String instanceOf(Object a) {
        if (a instanceof ListaEnlazada ) {
            return "ListaEnlazada";
        }
        if (a instanceof Aerolinea ) {
            return "Aerolinea";
        }
        return null;
    }
    
    

}
