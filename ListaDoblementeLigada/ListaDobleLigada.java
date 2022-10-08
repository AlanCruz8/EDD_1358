package fes.aragon;

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
       
        for (int i = 0; i <= posicion-1; i++) {
            aux = aux.getSiguiente();
        }
        if (this.estaVacia()) {
            System.out.println("La lista aun no contiene ningun elemento");
        } else {
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);
            nuevo.setAnterior(aux);
      
            if (nuevo.getSiguiente() != null) {
                nuevo.getSiguiente().setAnterior(nuevo);
            }
        }
        this.tamanio++;
    }

    public int buscar(T valor) {
        int posicion = 0;
        
        NodoDoble aux = this.head;
        while (aux.getDato() != valor) {
            aux = aux.getSiguiente();
            posicion++;
        }
        return posicion-1;
    }

    public void actualizar(T valorBuscado, T valor) {
        NodoDoble aux = this.head;
        while (aux.getDato() != valorBuscado) {
            aux = aux.getSiguiente();
        }
        aux.setDato(valor);
    }

    public void eliminar(int posicion) {
        NodoDoble aux = this.head;
        
        for (int contador = 0; contador <= posicion-1; contador++) {
            aux = aux.getSiguiente();
        }
        
        if(this.estaVacia()){
            System.out.println("La lista aun no tiene elementos");
        }
        if(aux.getSiguiente() != null){
            aux.getSiguiente().setAnterior(aux.getAnterior());
        }else{
            this.eliminarElFinal();
        }
        if(aux.getAnterior() != null){
            aux.getAnterior().setSiguiente(aux.getSiguiente());
        }else{
            this.eliminarElPrimero();
        }
        this.tamanio--;
    }
    
    public void eliminarElPrimero() {
        if (this.estaVacia()) {
            System.out.println("La lista no tiene elementos");
        } else {
            NodoDoble aux = this.head;
            if (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
                head = aux;
                head.setAnterior(null);
            } else {
                aux = null;
                head = aux;
            }
        }
        this.tamanio--;
    }

    public void eliminarElFinal() {
        if (this.estaVacia()) {
            System.out.println("La lista no tiene elementos");
        } else {
            NodoDoble aux = this.head;
            while (aux.getSiguiente().getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(aux.getSiguiente().getSiguiente());
        }
        this.tamanio--;
    }

    public void tranversal(boolean direccion) {
        if (direccion) {
            NodoDoble aux = this.head;
            while (aux != null) {
                System.out.print(aux);
                aux = aux.getSiguiente();
            }
            System.out.println("");
        } else {
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
