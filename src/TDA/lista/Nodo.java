package TDA.lista;

import java.io.Serializable;

public class Nodo implements Serializable {
    //Atributos

    public Object elemento;
    public Nodo sgte, ant;

    //Constructor
    public Nodo(Object elemento) {
        this.elemento = elemento;
        this.ant = this.sgte = null;
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

    public Nodo getAnt() {
        return ant;
    }

    public void setAnt(Nodo ant) {
        this.ant = ant;
    }

    //RECARGAMOS EL CONSTRUCTOR PARA EL NODO CABECERA
    //NODO CABECERA == NODO VACIO
    public Nodo() {
        this.sgte = null;
        //es para la implementacion de la cola con nodo cabecera
    }

    @Override
    public String toString() {
        return elemento.toString();
    }
}//fin de la clase Nodo
