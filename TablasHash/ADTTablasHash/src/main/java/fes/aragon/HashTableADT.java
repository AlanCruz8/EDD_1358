package fes.aragon;

public class HashTableADT<T> {

    private ArregloADT<ListaLigadaADT<T>> datos;
    private int tamanio;

    public HashTableADT(int tam) {
        if (tam >= 7 && this.esPrimo(tam)) {
            this.tamanio = tam;
            this.datos = new ArregloADT<>(tam);
            for (int i = 0; i < this.datos.getLongitud(); i++) {
                this.datos.setElemento(i, new ListaLigadaADT());
            }
        } else {
            System.out.println("El tamaño ingresado no es primo o es menor a 7");
        }
    }

    public void add(int llave, T valor) {
        int indice = this.hashDivision(llave);
        if (this.datos.getElemento(indice).estaVacia()) {
            this.datos.getElemento(indice).agregarAlInicio(llave, valor);
        } else {
            this.datos.getElemento(indice).agregarAlFinal(llave, valor);
        }
    }

    public T valueOf(int llave) {
        int indice = this.hashDivision(llave);
        T valorAsociado;

        if (this.datos.getElemento(indice).getTamanio() > 1) {
            valorAsociado = this.datos.getElemento(indice).getValorLlave(llave);
        } else {
            valorAsociado = this.datos.getElemento(indice).valorHead();
        }
        return valorAsociado;
    }

    public void remove(int llave) {
        int indice = this.hashDivision(llave);
        if (this.datos.getElemento(indice).getTamanio() > 1) {
            T valorAsociado = this.datos.getElemento(indice).getValorLlave(llave);
            int posicionValor = this.datos.getElemento(indice).buscar(valorAsociado);
            this.datos.getElemento(indice).eliminar(posicionValor);
        } else {
            this.datos.getElemento(indice).eliminarElPrimero();
        }
    }

    private int hashDivision(int llave) {
        return llave % this.tamanio;
    }

    private boolean esPrimo(int numero) {
        //Revisa si n es multiplo de 2
        if (numero % 2 == 0) {
            return false;
        }
        //Si no, solo revisa los impares
        for (int i = 3; i * i <= numero; i += 2) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
}
