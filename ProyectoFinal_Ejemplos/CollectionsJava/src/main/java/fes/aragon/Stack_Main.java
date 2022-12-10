/*

Framework: Java Collections
Stack
Cruz Carcamo Alan Eduardo

 */
package fes.aragon;

import java.util.Stack;

public class Stack_Main {

    public static void main(String[] args) {
        //Hacemos una instancia de tipo Stack con una variable de instancia llamada pila
        Stack pila = new Stack();
        
        //Agregamos algunos elementos a nuestra pila
        pila.push(1);
        pila.push(2);
        pila.push(3);
        pila.push(4);
        pila.push(5);
        
        //Checamos si nuestra pila está vacia
        System.out.println("¿La pila está vacia' : " + pila.isEmpty());
        
        //Checamos el tamaño de nuestra pila
        System.out.println("Tamaño de pila : " + pila.size());
        
        //Verificamos cuál es el elemento que está hasta arriba en nuestra pila
        System.out.println("Top : " + pila.peek());
        
        //Imprimimos a la par que eliminamos el elemento que está hasta arriba de nuestra pila
        System.out.println("Elemento eliminado : " +pila.peek());
        
        //Imprimimos los elementos que se encuentran en nuestra pila
        System.out.println("Estado de la pila : " + pila);
    }
}
