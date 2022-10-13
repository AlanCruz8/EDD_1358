/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package fes.aragon;

/**
 *
 * @author hp
 */
public class Arreglo2DADT <T>{
    private int renglones;
    private int columnas;
    ArregloADT<ArregloADT<T>> matriz;
    
    public Arreglo2DADT(int reng, int cols){
        this.renglones=reng;
        this.columnas=cols;
        matriz=new ArregloADT(this.renglones);
        
        for (int i = 0; i < matriz.getLongitud(); i++) {
            matriz.setElemento(i, new ArregloADT(this.columnas));
        }
        
        for (int i = 0; i < matriz.getLongitud(); i++) {
            for (int j = 0; j < matriz.getElemento(i).getLongitud(); j++) {
                matriz.getElemento(i).setElemento(j, null);
            }
        }
    }
    
    
    public int getRenglones(){
        return matriz.getLongitud();
    }
    
    public int getColumnas(){
        return matriz.getElemento(0).getLongitud();
    }
    
    public T getElemento(int ren, int col){
        if(comprobarIndiceRenglones(ren) && comprobarIndiceColumnas(col)){
            return matriz.getElemento(ren).getElemento(col);
        }else{
            System.out.println("El indice del renglon o columna que quiere obtener estan fuera del rango");
        } 
        return null;
    }
    
    public void setElemento(int ren, int col, T dato){
        if(comprobarIndiceRenglones(ren) && comprobarIndiceColumnas(col)){
            matriz.getElemento(ren).setElemento(col, dato);
        }else{
            System.out.println("El indice del renglon o columna que quiere modificar estan fuera del rango");
        }
    }
    
    public void limpiar(T dato){
        for (int i = 0; i < matriz.getLongitud(); i++) {
            for (int j = 0; j < matriz.getElemento(i).getLongitud(); j++) {
                matriz.getElemento(i).setElemento(j, dato);
            }
        }
    }
    
    public String toString(){
        String estado = "";
        for (int i = 0; i < matriz.getLongitud(); i++) {
            for (int j = 0; j < matriz.getElemento(i).getLongitud(); j++) {
               estado =  matriz.getElemento(i).getElemento(j).toString();
              
            }
        } return estado;
    }
    
    public boolean comprobarIndiceRenglones(int indice){
        return indice >=0 && indice < matriz.getLongitud();
    }
    
    public boolean comprobarIndiceColumnas(int indice){
        return indice >=0 && indice < matriz.getElemento(0).getLongitud();
    }
    
    public void mostrarMatriz(){
        for (int i = 0; i < matriz.getLongitud(); i++) {
            System.out.println("");
            for (int j = 0; j < matriz.getElemento(i).getLongitud(); j++) {
                System.out.print(" " + matriz.getElemento(i).getElemento(j));
            }
        }
    }
}
