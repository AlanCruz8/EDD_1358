package fes.aragon;

public class BoundedPriorityQueue<T> {

    private ArregloADT<Cola<T>> niveles;
    private int tamanio;

    public BoundedPriorityQueue(int noPrioridades) {
        this.niveles = new ArregloADT<>(noPrioridades);
        this.tamanio = 0;
        for (int i = 0; i < this.niveles.getLongitud(); i++) {
            this.niveles.setElemento(i, new Cola<>());
        }
    }

    public boolean isEmpty() {
        return this.tamanio == 0;
    }

    public int length() {
        return this.tamanio;
    }

    public void enqueue(int prioridad, T elemento) {
        if (prioridad >= 0 && prioridad < this.niveles.getLongitud()) {
            this.niveles.getElemento(prioridad).enqueue(elemento);
            this.tamanio++;
        } else {
            System.out.println("El nivel de prioridad no se ha definido");
        }
    }

    public T dequeue() {
        T elementoVip;
        if (this.niveles.getElemento(0).length() == 0) {
            int prioridades = 1;
            while (this.niveles.getElemento(prioridades).length() == 0) {
                prioridades++;
            }
            elementoVip = this.niveles.getElemento(prioridades).dequeue();
        } else {
            elementoVip = this.niveles.getElemento(0).dequeue();
        }
        return elementoVip;
    }

    @Override
    public String toString() {
        String estado = "[";
        for (int i = 0; i < this.niveles.getLongitud(); i++) {
            if (this.niveles.getElemento(i).length() == 0) {
                estado += "";
            } else {
                estado += this.niveles.getElemento(i).toString();
            }
        }
        return estado + "]";
    }
}
