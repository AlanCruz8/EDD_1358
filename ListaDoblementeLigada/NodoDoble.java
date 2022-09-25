/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fes.aragon;

/**
 *
 * @author hp
 */
public class NodoDoble <T>{
    private T dato;
    private NodoDoble anterior;
    private NodoDoble siguiente;
    
    public NodoDoble(){
        
    }
    
    public NodoDoble(T valor){
        this.dato=valor;
    }
    
    public NodoDoble(T valor, NodoDoble sig, NodoDoble ante){
        this.dato=valor;
        this.anterior=ante;
        this.siguiente=sig;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }

    public NodoDoble getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }
    
    public String toString(){
        return "<--|" + this.dato + "|-->";
    }
}
