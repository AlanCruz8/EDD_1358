/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package fes.aragon;

/**
 *
 * @author hp
 */
public class ListaDobleLigada<T> {

    private NodoDoble<T> head;
    private int tamanio = 0;

    public ListaDobleLigada() {
        this.head = null;
        this.tamanio = 0;
    }

    public boolean estaVacia() {
        return this.head == null;
    }

    public int getTamanio() {
        return this.tamanio;
    }

    public void agregarAlFinal(T valor) {
        NodoDoble nuevo = new NodoDoble(valor);
        if (this.estaVacia()) {
            this.head = nuevo;
        } else {
            NodoDoble aux = this.head;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            nuevo.setAnterior(aux);
            aux.setSiguiente(nuevo);
            aux = null;
            nuevo = null;
        }
        this.tamanio++;
    }

    public void agregarAlInicio(T valor) {
        NodoDoble nuevo = new NodoDoble(valor);
        if (this.estaVacia()) {
            this.head = nuevo;
        } else {
            nuevo.setSiguiente(this.head);
            this.head.setAnterior(nuevo);
            this.head = nuevo;
        }
        this.tamanio++;
    }

    public void agregarDespuesDe(T valor, int posicion) {
        NodoDoble nuevo = new NodoDoble(valor);
        NodoDoble aux = this.head;
        //Nos colocamos en el nodo que va a estar antes del nuevo 
        for (int i = 0; i < posicion; i++) {
            aux = aux.getSiguiente();
        }
        //Comprobamos si la lista tiene elementos
        if (this.estaVacia()) {
            System.out.println("La lista aun no contiene ningun elemento");
        } else {
            //Cambiamos los punteros del nuevo nodo y del anterior al nuevo nodo
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);
            nuevo.setAnterior(aux);
            //Comprobamos si el nodo que le sigue al nuevo que colocamos no es null, si lo es no colocamos un puntero anterior ya que
            //seria el ultimo nodo pero si no lo es ponemos el puntero anterior direccion al nuevo nodo que colocamos
            if (nuevo.getSiguiente() != null) {
                nuevo.getSiguiente().setAnterior(nuevo);
            }
        }
        this.tamanio++;
    }

    public int buscar(T valor) {
        int posicion = 0;
        //Recorremos cada dato de cada nodo (incluido head) para 
        //comprobar que el dato de ese nodo no sea igual al que queremoos, si lo es salimos del while y regresamos
        //la posicion
        NodoDoble aux = this.head;
        while (aux.getDato() != valor) {
            aux = aux.getSiguiente();
            posicion++;
        }
        return posicion-1;
    }

    public void actualizar(T valorBuscado, T valor) {
        NodoDoble aux = this.head;
        //Buscamos el dato en cada nodo(incluido head), si el dato de el nodo actual es igual al buscado
        //salimos del while y cambiamos el dato del nodo actual por el que queremos actualizar
        while (aux.getDato() != valorBuscado) {
            aux = aux.getSiguiente();
        }
        aux.setDato(valor);
    }

    public void eliminar(int posicion) {
        NodoDoble aux = this.head;
        //Nos colocamos en el nodo que quiere eliminar
        for (int contador = 0; contador < posicion; contador++) {
            aux = aux.getSiguiente();
        }

        //Comprobamos si la lista tiene elementos 
        if(this.estaVacia()){
            System.out.println("La lista aun no tiene elementos");
        }
        //Comprobamos si el que quiere eliminar no es el head,
        //si no lo es cambiamos el puntero anterior del nodo siguiente al nodo que esta atras del que eliminaremos
        if(aux.getSiguiente() != null){
            aux.getSiguiente().setAnterior(aux.getAnterior());
        }else{
            this.eliminarElFinal();
        }
        //Comprobamos si el que quiere eliminar no es el ultimo,
        //si no lo es cambiamos el puntero del nodo anterior al siguiente del que se eliminara
        if(aux.getAnterior() != null){
            aux.getAnterior().setSiguiente(aux.getSiguiente());
        }else{
            this.eliminarElPrimero();
        }
        this.tamanio--;
    }
    

    

    public void eliminarElPrimero() {
        //COmprobamos si la lista tiene elementos
        if (this.estaVacia()) {
            System.out.println("La lista no tiene elementos");
        } else {
            NodoDoble aux = this.head;
            //Comprobamos si la lista tiene mas de un elemento, si es asi cambiamos el puntero de head
            //al siguiente nodo y modificamos el puntero anterior a null (con ayuda de aux)
            if (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
                head = aux;
                head.setAnterior(null);
            //Si la lista solo tiene un elemento convertimos directatemente head a null
            } else {
                aux = null;
                head = aux;
            }
        }
        this.tamanio--;
    }

    public void eliminarElFinal() {
        //Comprobamos si la lista tiene elementos
        if (this.estaVacia()) {
            System.out.println("La lista no tiene elementos");
        } else {
            NodoDoble aux = this.head;
            //Nos colocamos en el antepenultimo elemento
            while (aux.getSiguiente().getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            //Cambiamos el puntero siguiente del antepenultimo nodo para que apunte al nodo null que esta al final 
            aux.setSiguiente(aux.getSiguiente().getSiguiente());
        }
        this.tamanio--;
    }

    public void tranversal(boolean direccion) {
        //Si el parametro direccion es true recorremos la lista hacia adelante
        if (direccion) {
            NodoDoble aux = this.head;
            while (aux != null) {
                System.out.print(aux);
                aux = aux.getSiguiente();
            }
            System.out.println("");
        //Si el parametro direccion es false recorremos la lista hacia atras
        } else {
            //Nos colocamos en el ultimo nodo que es el que esta antes del nodo null
            NodoDoble aux = this.head;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            
            while (aux != null) {
                System.out.print(aux);
                aux = aux.getAnterior();
            }
            System.out.println("");
        }
    }
}
