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
public class ListaEnlazadaDoble implements Lista, Serializable{
    
    private Nodo inicio;
    
    public ListaEnlazadaDoble() {
        inicio = null;
    }
    
    @Override
    public int getSize() throws ListaException {
        if(isEmpty()) throw new ListaException("La lista no existe");
        Nodo aux = inicio;
        int cont =0;
        while(aux != null){
            aux = aux.sgte;
            cont++;
        }
        return cont;
    }
    
    @Override
    public void anular() {
        inicio = null;
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
        while(aux != null){
            if(pos == posicion){
                return aux;
            }else{
                aux = aux.sgte;
                pos++;
            }
        }
        return null;
    }
    
    @Override
    public Nodo getNodo(Object elemento) throws ListaException {
        if(isEmpty()) throw new ListaException("La lista no existe");
        Nodo aux = inicio;
        while(aux != null){
            if(aux.elemento.equals(elemento)){
                return aux;
            }else{
                aux = aux.sgte;
            }
        }
        return null;
    }
    
    @Override
    public int getPosicion(Object elemento) throws ListaException {
        if(isEmpty()) throw new ListaException("La lista no existe");
        Nodo aux = inicio;
        int pos = 1;
        while(aux != null){
            if(aux.elemento.equals(elemento))
                return pos;
            aux = aux.sgte;
            pos++;
        }
        return -1;
    }
    
    @Override
    public void insertar(Object elemento) {
        Nodo nuevoNodo = new Nodo(elemento);
        if(inicio == null){
            inicio = nuevoNodo;
        }else{
            Nodo aux = inicio;
            while(aux.sgte != null){
                aux = aux.sgte;
            }
            aux.sgte = nuevoNodo;
            //doble enlace
            nuevoNodo.ant = aux;
        }
    }
    
    @Override
    public void insertarOrdenado(Object elemento) {
        Nodo nuevoNodo = new Nodo(elemento);
        if(inicio==null){
            inicio = nuevoNodo;
        }else
            if(inicio.sgte==null && esMayorQ(inicio.elemento, elemento)){
                nuevoNodo.sgte = inicio;
                inicio.ant = nuevoNodo; //doble enlace
                inicio = nuevoNodo;
                
            }else
                if(inicio.sgte==null && !esMayorQ(inicio.elemento, elemento)){
                    inicio.sgte = nuevoNodo;
                    nuevoNodo.ant = inicio; //doble enlace
                    
                }else
                    if(esMayorQ(inicio.elemento, elemento)){
                        nuevoNodo.sgte = inicio;
                        inicio.ant = nuevoNodo;
                        inicio = nuevoNodo;
                        
                    }else{
                        boolean insertado=false;
                        Nodo nodoAnterior = inicio; //un nodo atras
                        Nodo aux = inicio.sgte;
                        while(aux.sgte!=null && !insertado){
                            if(esMayorQ(aux.elemento, elemento)){
                                nodoAnterior.sgte = nuevoNodo;
                                nuevoNodo.ant = nodoAnterior; //doble enlace
                                nuevoNodo.sgte = aux;
                                aux.ant = nuevoNodo; //doble enlace
                                insertado=true;
                            }//if
                            nodoAnterior = aux;
                            aux = aux.sgte;
                        }//while
                        //se sale cuando aux==null
                        if(!insertado){
                            if(esMayorQ(aux.elemento, elemento)){
                                nodoAnterior.sgte = nuevoNodo;
                                nuevoNodo.ant = nodoAnterior; //doble enlace
                                nuevoNodo.sgte = aux;
                                aux.ant = nuevoNodo; //doble enlace
                            }//if
                            else{
                                //se enlaza al final
                                aux.sgte = nuevoNodo;
                                nuevoNodo.ant = aux; //doble enlace
                                
                            }//else
                        }//if(!insertado)
                    }//else
    }
    
    @Override
    public void suprimir(Object elemento) throws ListaException {
        if(isEmpty()) throw new ListaException("La lista no existe");
        if(inicio.elemento.equals(elemento)){
            inicio = inicio.sgte;
        }else{
            Nodo aux = inicio.sgte;
            Nodo ant = inicio;
            while(aux != null){
                if(aux.elemento.equals(elemento)){
                    ant.sgte = aux.sgte;
                    //doble enlace
                    aux.sgte.ant = ant;
                }
                ant = aux;
                aux = aux.sgte;
            }
        }
    }
    
    @Override
    public boolean existe(Object elemento) throws ListaException {
        
        Nodo aux = inicio;
        while(aux != null){
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
        while(aux != null){
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
            return "No tiene";
        }
        Nodo aux = inicio.sgte;
        while(aux != null){
            if(aux.elemento.equals(elemento)){
                return aux.ant.elemento;
            }
            aux = aux.sgte;
        }
        return "Elemento no existe";
    }
    
    @Override
    public Object posterior(Object elemento) throws ListaException {
        if(isEmpty()) throw new ListaException("La lista no existe");
        Nodo pos = inicio.sgte;
        Nodo aux = inicio;
        while(pos != null){
            if(aux.elemento.equals(elemento)){
                if(pos != null){
                    return pos.elemento;
                }
                else{
                    return "No tiene";
                }
            }
            aux = aux.sgte;
            if(aux != null){
                pos =aux.sgte;
            }
        }
        return "Elemento no existe";
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
