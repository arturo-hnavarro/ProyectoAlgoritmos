/** 
 * File     : Nodo.java
 * @author  : Prof. Gilberth Chaves Avila
 * Date     : 2017-05-09
 */
package Tda.Listas;

import java.io.Serializable;

public class Nodo implements Serializable {
    //Atributos
    public Object elemento;
    public Nodo sgte;
    
    //Constructor
    public Nodo(Object elemento){
        this.elemento=elemento;
        this.sgte=null;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public Nodo getSgte() {
        return sgte;
    }

    public void setSgte(Nodo sgte) {
        this.sgte = sgte;
    }
    
    //RECARGAMOS EL CONSTRUCTOR PARA EL NODO CABECERA
    //NODO CABECERA == NODO VACIO
    public Nodo(){
        this.sgte=null;
        //es para la implementacion de la cola con nodo cabecera
    }

    @Override
    public String toString() {
        return ""+ elemento;
    }
}