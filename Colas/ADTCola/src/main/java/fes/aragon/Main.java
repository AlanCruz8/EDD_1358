package fes.aragon;

public class Main {

    public static void main(String[] args) {
        Cola<String> tortilleria = new Cola<String>();
        tortilleria.enqueue("Paco");
        tortilleria.enqueue("Julian");
        tortilleria.enqueue("Juan");
        System.out.println("¿La fila de las tortillas esta vacia?  " + tortilleria.isEmpty());
        System.out.println("Fila de las tortillas : " + tortilleria);
        System.out.println("El primero en llegar fue : " + tortilleria.dequeue());
        System.out.println("Fila de las tortillas despues de atender a Paco  : " + tortilleria);
        tortilleria.enqueue("Sebastian");
        tortilleria.enqueue("Don Ramón");
        System.out.println(tortilleria);
    }

}
