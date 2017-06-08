/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package TDA.lista;

import java.io.Serializable;

/**
 *
 * @author Equipo
 */
public class ListaCircular implements Lista, Serializable{
    
    private Nodo inicio;
    private Nodo fin;
    public ListaCircular() {
        inicio = fin = null;
    }
    
    @Override
    public int getSize() throws ListaException {
        if(isEmpty()) throw new ListaException("La lista no existe");
        Nodo aux = inicio;
        int cont =1;
        while(aux != fin){
            aux = aux.sgte;
            cont++;
        }
        return cont;
    }
    
    @Override
    public void anular() {
        inicio = fin = null;
    }
    
    @Override
    public boolean isEmpty() {
        return inicio == null;
    }
    
    @Override
    public Nodo getNodo(int posicion) throws ListaException {
        if(isEmpty()) throw new ListaException("La lista no existe");
        int pos = 1;
        Nodo aux = inicio;
        while(aux != fin){
            if(pos == posicion){
                return aux;
            }else{
                aux = aux.sgte;
                pos++;
            }
        }
        //sale cuando nodo == fin
        if(pos == posicion){
            return aux;
        }
        return null;
    }
    
    @Override
    public Nodo getNodo(Object elemento) throws ListaException {
        if(isEmpty()) throw new ListaException("La lista no existe");
        Nodo aux = inicio;
        while(aux != fin){
            if(aux.elemento.equals(elemento)){
                return aux;
            }else{
                aux = aux.sgte;
            }
        }
        //sale cuando nodo == fin
        if(aux.elemento.equals(elemento)){
            return aux;
        }
        return null;
    }
    
    @Override
    public int getPosicion(Object elemento) throws ListaException {
        if(isEmpty()) throw new ListaException("La lista no existe");
        Nodo aux = inicio;
        int pos = 1;
        while(aux != fin){
            if(aux.elemento.equals(elemento))
                return pos;
            aux = aux.sgte;
            pos++;
        }
        if(aux.elemento.equals(elemento))
            return pos;
        return -1;
    }
    
    @Override
    public void insertar(Object elemento) {
        Nodo nuevoNodo = new Nodo(elemento);
        if(inicio == null){
            inicio = fin = nuevoNodo;
        }else{
            Nodo aux = inicio;
            while(aux != fin){
                aux = aux.sgte;
            }
            //sale cuando auxiliar es igual a fin
            aux.sgte = nuevoNodo;
            //fin apunte a nuevNodo
            fin = nuevoNodo;
            //enlace circular
            fin.sgte = inicio;
        }
    }
    
    @Override
    public void insertarOrdenado(Object elemento) {
        Nodo nuevoNodo = new Nodo(elemento);
        if (inicio==null) {
            inicio= fin =nuevoNodo;
        }else
            if (inicio.sgte==fin.sgte && esMayorQ(inicio.elemento,elemento)) {
                nuevoNodo.sgte = inicio;
                inicio = nuevoNodo;
                fin.sgte = inicio;
            }else
                if (inicio.sgte == fin.sgte && !esMayorQ(inicio.elemento,elemento)) {
                    inicio.sgte = nuevoNodo;
                    fin = nuevoNodo;
                    fin.sgte = inicio;
                }else
                    if (esMayorQ(inicio.elemento,elemento)) {
                        nuevoNodo.sgte = inicio;
                        inicio = nuevoNodo;
                        fin.sgte = inicio;
                    }else{
                        boolean insertado = false;
                        Nodo nodoAnterior = inicio;
                        Nodo aux = inicio.sgte;
                        while(aux!=fin && !insertado){//check
                            if (esMayorQ(aux.elemento,elemento)) {
                                nodoAnterior.sgte = nuevoNodo;
                                nuevoNodo.sgte = aux;
                                insertado = true;
                            }//if
                            nodoAnterior=aux;
                            aux=aux.sgte;
                        }//while
                        
                        if(!insertado){
                            if (esMayorQ(aux.elemento,elemento)) {
                                nodoAnterior.sgte = nuevoNodo;
                                nuevoNodo.sgte=aux;
                            }//if
                            else{//se enlaza al final
                                aux.sgte = nuevoNodo;
                                fin = nuevoNodo;
                                fin.sgte = inicio;
                            }//else
                        }
                    }
    }
    
    @Override
    public void suprimir(Object elemento) throws ListaException {
        if(isEmpty()) throw new ListaException("La lista no existe");
        if(inicio.elemento.equals(elemento)){
            inicio = inicio.sgte;
        }else{
            Nodo aux = inicio.sgte;
            Nodo ant = inicio;
            while(aux != fin){
                if(aux.elemento.equals(elemento)){
                    ant.sgte = aux.sgte;
                }else{
                    ant = aux;
                    aux = aux.sgte;
                }
            }
            //sale cuando nodo == fin
            if(aux.elemento.equals(elemento)){
                ant.sgte = aux.sgte;
            }
            
            //fin apunte al ultimo nodo
            if(aux == fin){
                fin = ant;
            }
            
            //mantener el enlace circular
            fin.sgte = inicio;
        }
    }
    
    @Override
    public boolean existe(Object elemento) {
        
        Nodo aux = inicio;
        while(aux != fin){
            if(aux.elemento.equals(elemento)){
                return true;
            }
            aux = aux.sgte;
        }
        return false;
    }
    
    @Override
    public Object primero() throws ListaException {
        if(isEmpty()) throw new ListaException("La lista no existe");
        return inicio;
    }
    
    @Override
    public Object ultimo() throws ListaException {
        if(isEmpty()) throw new ListaException("La lista no existe");
        Nodo aux = inicio;
        while(aux != fin){
            aux = aux.sgte;
        }
        return aux;
    }
    
    @Override
    public void ordenar() throws ListaException {
        if(isEmpty())
            throw new ListaException("La lista no existe");
        Object temp;
        int n=getSize();
        for(int i=0;i<n;i++)
            for(int j=1;j<n-i;j++){
                if(getNodo(j)==null || getNodo(j+1)==null) break; //rompemos el ciclo
                if(esMayorQ(getNodo(j).elemento, getNodo(j+1).elemento)){
                    temp = getNodo(j).elemento;
                    getNodo(j).elemento = getNodo(j+1).elemento;
                    getNodo(j+1).elemento = temp;
                }//if esMayorQ
            }//for j
    }
    
    @Override
    public Object anterior(Object elemento) throws ListaException {
        if(isEmpty()) throw new ListaException("La lista no existe");
        if(inicio.elemento.equals(elemento)){
            return fin.elemento;
        }
        Nodo aux = inicio.sgte;
        Nodo ant = inicio;
        while(aux != fin){
            if(aux.elemento.equals(elemento)){
                return ant.elemento;
            }
            ant = aux;
            aux = aux.sgte;
        }
        if(aux.elemento.equals(elemento)){
            return ant.elemento;
        }
        return fin.elemento;
    }
    
    @Override
    public Object posterior(Object elemento) throws ListaException {
        if(isEmpty()) throw new ListaException("La lista no existe");
        Nodo pos = inicio.sgte;
        Nodo aux = inicio;
        while(pos != fin){
            if(aux.elemento.equals(elemento)){
                if(pos != fin){
                    return pos.elemento;
                }
                else{
                    return "No tiene";
                }
            }
            aux = aux.sgte;
            if(aux != fin){
                pos =aux.sgte;
            }
            
        }
        if(aux.elemento.equals(elemento))
            return pos.elemento;
        return inicio.elemento;
    }
    
    @Override
    public String toString() {
        return "ListaEnlazada{" + "inicio=" + inicio + '}';
    }
    
    private boolean esMayorQ(Object a, Object b){
        switch(instanceOf(a, b)){
            case "entero":
                int x=(int)a; int y=(int)b;
                return x>y;
                
            case "string":
                String p=(String)a; String q=(String)b;
                return p.compareToIgnoreCase(q)>0;
                
//            case "empleado":
//                Empleado r=(Empleado)a; Empleado s=(Empleado)b;
//                return r.getCedula().compareToIgnoreCase(s.getCedula())>0;
//
        }
        return false;
    }
    
    public String instanceOf(Object a, Object b){
        if(a instanceof Integer && b instanceof Integer) return "entero";
        if(a instanceof String && b instanceof String) return "string";
//        if(a instanceof Empleado && b instanceof Empleado) return "empleado";
        return "desconocido";
    }
    
}
