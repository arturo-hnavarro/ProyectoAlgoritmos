package Archivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Archivo {

    String temp = "";
    String temporal;

    public void escribirFoto(String nueva, String archivo) {

        try {
            File f = new File(archivo);
            FileWriter fw;
            BufferedWriter bw;
            if (f.exists()) {
                fw = new FileWriter(f);
                bw = new BufferedWriter(fw);
                bw.newLine();
                bw.write(nueva);
            } else {
                fw = new FileWriter(f);
                bw = new BufferedWriter(fw);
                bw.write(nueva);
            }

            bw.close();
            fw.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String imprimir() {

        String texto = "";

        try {
            File f = new File("Reservaciones.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String cadena = "";
            int valor = fr.read();
            while (valor != -1) {
                cadena = cadena + (char) valor;
                valor = fr.read();
            }
            setTemporal(texto);
            fr.close();
        } catch (Exception e) {
            System.err.println("No se encontro archivo");
        }
        return texto;
    }

    @Override
    public String toString() {
        return "Archivo{" + "temp=" + getTemporal() + '}';
    }

    public String getTemporal() {
        return temporal;
    }

    public void setTemporal(String temporal) {
        this.temporal = temporal;
    }

    public String leer(String archivo) //El parametro nombre indica el nombre del archivo por ejemplo "prueba.txt"
    {

        try {

            File f;

            FileReader lectorArchivo;

//Creamos el objeto del archivo que vamos a leer
            f = new File(archivo);

//Creamos el objeto FileReader que abrira el flujo(Stream) de datos para realizar la lectura
            lectorArchivo = new FileReader(f);

//Creamos un lector en buffer para recopilar datos a travez del flujo "lectorArchivo" que hemos creado
            BufferedReader br = new BufferedReader(lectorArchivo);

            String l = "";

//Esta variable "l" la utilizamos para guardar mas adelante toda la lectura del archivo
            String aux = "";/*variable auxiliar*/


            while (true) //este ciclo while se usa para repetir el proceso de lectura, ya que se lee solo 1 linea de texto a la vez
            {

                aux = br.readLine();

//leemos una linea de texto y la guardamos en la variable auxiliar
                if (aux != null) {
                    l = l + aux;
                } /*si la variable aux tiene datos se va acumulando en la variable l,
07
* en caso de ser nula quiere decir que ya nos hemos leido todo
08
* el archivo de texto*/ else {
                    break;
                }

            }

            br.close();

            lectorArchivo.close();

            return l;

        } catch (IOException e) {

            System.out.println("Error:" + e.getMessage());

        }

        return null;

    }

}
