/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fes.aragon;

/**
 *
 * @author hp
 */
public class Prueba {

    public static void main(String[] args) {
        
        ListaDobleLigada<Integer> listaDoble = new ListaDobleLigada();
        
        System.out.println("Probando implementacion de lista doblemente ligada\n");
        System.out.println("Agregando al inicio un nodo valor 10");
        listaDoble.agregarAlInicio(10);
        listaDoble.tranversal(true);
        System.out.println("");
        
        System.out.println("Agregando al final un nodo valor 20");
        listaDoble.agregarAlFinal(20);
        listaDoble.tranversal(true);
        System.out.println("");
        
        System.out.println("Agregando un 15 despues del nodo valor 10");
        listaDoble.agregarDespuesDe(15, 0);
        listaDoble.tranversal(true);
        System.out.println("");
        
        System.out.println("Agregando al final un nodo valor 30");
        listaDoble.agregarAlFinal(30);
        listaDoble.tranversal(true);
        System.out.println("");
        
        System.out.println("Buscando la posicion del nodo valor 20");
        System.out.println("Posicion : " +listaDoble.buscar(30));
        System.out.println("");
        
        System.out.println("---------------------------");
        System.out.println("Recorriendo la lista desde el head");
        listaDoble.tranversal(true);
        System.out.println("Recorriendo la lista a la inversa del head");
        listaDoble.tranversal(false);
        System.out.println("---------------------------");
        System.out.println("");
        
        System.out.println("Eliminando el nodo valor 20");
        listaDoble.eliminar(2);
        listaDoble.tranversal(true);
        System.out.println("");
        
        System.out.println("Obteniendo el tamaño de la lista");
        System.out.println("Tamañio : " + listaDoble.getTamanio());
        System.out.println("");
        
        System.out.println("Eliminando el nodo final");
        listaDoble.eliminarElFinal();
        listaDoble.tranversal(true);
        System.out.println("");
        
        System.out.println("Eliminando el nodo inicial");
        listaDoble.eliminarElPrimero();
        listaDoble.tranversal(true);
        System.out.println("");
        
        System.out.println("Actualizando el valor 15 por el 100");
        listaDoble.actualizar(15, 100);
        listaDoble.tranversal(true);
        System.out.println("");
        
        System.out.println("Chechando si la lista esta vacia");
        System.out.println("¿Esta vacia? : " + listaDoble.estaVacia());
    }
}
