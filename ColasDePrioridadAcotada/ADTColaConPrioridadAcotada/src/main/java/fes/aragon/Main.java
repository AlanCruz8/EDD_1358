package fes.aragon;

public class Main {

    public static void main(String[] args) {
        BoundedPriorityQueue<String> fila = new BoundedPriorityQueue<>(7);
        fila.enqueue(1, "Niñas");
        fila.enqueue(2, "Niños");
        fila.enqueue(2, "3ra edad");
        fila.enqueue(3, "Mujeres");
        fila.enqueue(3, "Hombres");
        fila.enqueue(4, "Maestre");
        fila.enqueue(4, "Mecánico");
        fila.enqueue(4, "Vigia");
        fila.enqueue(4, "Timonel");
        fila.enqueue(5, "Capitan");
        System.out.println("¿La fila para evacuar esta vacia?  " + fila.isEmpty());
        System.out.println("¿Cual es el tamaño de la fila?  " + fila.length());
        System.out.println(fila);
        System.out.println("El mas importante es : " + fila.dequeue());
    }

}
