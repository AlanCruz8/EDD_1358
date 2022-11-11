package fes.aragon;

import java.util.ArrayList;

public class Cola<T> {
    private ArrayList<T> datos;

    public Cola() {
        this.datos = new ArrayList<>();
    }

    public boolean isEmpty() {
        return this.datos.isEmpty();
    }

    public int length() {
        return this.datos.size();
    }

    public void enqueue(T elemento) {
        this.datos.add(elemento);
    }

    public T dequeue() {
        T elemento = this.datos.get(0);
        this.datos.remove(0);
        return elemento;
    }

    @Override
    public String toString() {
        String estado = " [ ";
        for (int i = 0; i < this.datos.size(); i++) {
            if (i == (this.datos.size() - 1)) {
                estado += this.datos.get(i) + " ]";
            } else {
                estado += this.datos.get(i) + " , ";
            }
        }

        return estado;
    }
}
