/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.List;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaSizeName;
import javax.swing.JOptionPane;

public class Utilidades {

    public static boolean esMayorQ(Object a, Object b) {
        switch (instanceOf(a, b)) {
            case "entero":
                int x = (int) a;
                int y = (int) b;
                return x > y;
            case "String":
                String p = (String) a;
                String q = (String) b;
                return p.compareToIgnoreCase(q) > 0;
            case "char":
                Character r = (Character) a;
                Character s = (Character) b;
                return r.compareTo(s) > 0;
        }
        return false;
    }

    public static boolean esMenorQ(Object a, Object b) {
        switch (instanceOf(a, b)) {
            case "entero":
                int x = (int) a;
                int y = (int) b;
                return x < y;
            case "String":
                String p = (String) a;
                String q = (String) b;
                return p.compareToIgnoreCase(q) < 0;
            case "char":
                Character r = (Character) a;
                Character s = (Character) b;
                return r.compareTo(s) < 0;
        }
        return false;
    }

    public static boolean esIgualQ(Object a, Object b) {
        switch (instanceOf(a, b)) {
            case "entero":
                int x = (int) a;
                int y = (int) b;
                return x == y;
            case "String":
                String p = (String) a;
                String q = (String) b;
                return p.compareToIgnoreCase(q) == 0;
            case "char":
                Character r = (Character) a;
                Character s = (Character) b;
                return r.equals(s);

        }
        return false;
    }

    public static String instanceOf(Object a, Object b) {
        if (a instanceof Integer && b instanceof Integer) {
            return "entero";
        }
        if (a instanceof String && b instanceof String) {
            return "String";
        }
        if (a instanceof Integer && b instanceof Integer) {
            return "char";
        }

        return "desconocido";
    }

    public static boolean validaTexto(String texto) {
        for (int x = 0; x < texto.length(); x++) {
            for (char i = 'a'; i < 'z'; i++) {
                if (!Character.isAlphabetic(texto.charAt(x))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean validaNumero(String numero) {
        char[] arreglo = numero.toCharArray();
        for (int x = 0; x < numero.length(); x++) {
            for (char i = 'a'; i < 'z'; i++) {
                if (arreglo[x] == i) {
                    return false;
                }
            }

        }
        return true;
    }

    public static boolean validaTextoNumero(String texto) {
        try {
            Integer.parseInt(texto);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    public static int Random() {
        return (int) Math.floor(Math.random() * 99);
    }

    public static char RandomLetras() {
        return (char) (Math.random() * 26 + 'a');
    }

    public static int comparar(Object a, Object b) {
        int resultado = 0;
        if (a instanceof Integer) {
            if ((int) a < (int) b) {
                resultado = -1;
            } else if ((int) a > (int) b) {
                resultado = 1;
            } else {
                resultado = 0;
            }
        } else if (a instanceof String) {
            if (((String) a).compareToIgnoreCase((String) b) < 0) {
                resultado = -1;
            } else if (((String) a).compareToIgnoreCase((String) b) > 0) {
                resultado = 1;
            } else {
                resultado = 0;
            }
        }
        return resultado;
    }

    public static Object minimo(Object obj1, Object obj2) {
        Object min = null;
        if (obj1 instanceof Integer) {
            if ((int) obj1 <= (int) obj2) {
                min = obj1;
            } else {
                min = obj2;
            }
        }
        if (obj1 instanceof String) {
            if (String.valueOf(obj1).compareToIgnoreCase(String.valueOf(obj2)) < 0) {
                min = obj1;
            } else {
                min = obj2;
            }
        }
        return min;
    }

    public static Object maximo(Object obj1, Object obj2) {
        Object max = null;
        if (obj1 instanceof Integer) {
            if ((int) obj1 > (int) obj2) {
                max = obj1;
            } else {
                max = obj2;
            }
        }
        if (obj1 instanceof String) {
            if (String.valueOf(obj1).compareToIgnoreCase(String.valueOf(obj2)) > 0) {
                max = obj1;
            } else {
                max = obj2;
            }
        }
        return max;
    }

    public static void imprimir(String texto) throws IOException {
       

    }

    public static PrintService[] getPrinterServiceNameList() {

        // get list of all print services
        PrintService[] services = PrinterJob.lookupPrintServices();

        return services;
    }

    private static void escribirDatosArchivo(String texto) {
        try {
            File archivo = new File("prueba.txt");
            //FileOutputStream, crea el archivo. Si existe lo elimina. 

            /*La instruccion(archivo,true) hace que el archivo no se 
    		elimine y se escriba desde la ultima linea*/
            FileOutputStream fos = new FileOutputStream(archivo, false);

            //Instrucción para escribir en archivo
            PrintStream ps = new PrintStream(fos);
            ps.print(texto);

        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, "error " + fnfe);
        }

    }// fin escribirDatosArchivo()

}
