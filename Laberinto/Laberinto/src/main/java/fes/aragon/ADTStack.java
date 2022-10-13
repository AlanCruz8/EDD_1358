package fes.aragon;

import java.util.ArrayList;

public class ADTStack<T> {
    private ArrayList<T> pila;
    
    public ADTStack(){
        this.pila=new ArrayList<>();
    }
    
    public boolean isEmpty(){
        return this.pila.isEmpty();
    }
    
    public int length(){
        return this.pila.size();
    }
    
    public T pop(){
        T top = this.pila.get(this.pila.size()-1);
        this.pila.remove(this.pila.size()-1);
        return top;
    }
    
    public T peek(){
        return this.pila.get(this.pila.size()-1);
    }
    
    public void push(T valor){
        this.pila.add(valor);
    }
    
    public String toString(){
        String estado ="{";
        for (T elemento : pila) {
            estado+= " " + elemento + " ";
        }
        return estado + "]";
    }
    
    public ArrayList getPila(){
        return this.pila;
    }
    
    public T getBase(){
        return this.pila.get(0);
    }
}
