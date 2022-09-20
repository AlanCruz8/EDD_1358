/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fes.aragon;

import java.util.Scanner;

/**
 *
 * @author hp
 */
public class Tablero {

    //Nos va a servir para hacer una copia del tablero y asi poder hacer los calculos con esa copia pero modificando los datos del tablero original
    private Arreglo2DADT<Integer> aux;
    private Arreglo2DADT<Integer> tablero;
    private Scanner entradaDatos = new Scanner(System.in);

    public Tablero() {
        tablero = new Arreglo2DADT(10, 10);
        aux = new Arreglo2DADT(10, 10);
    }

    public void RellenadoAleatorio() {
        for (int i = 0; i < tablero.getRenglones(); i++) {
            for (int j = 0; j < tablero.getColumnas(); j++) {
                int celula = (int) (Math.random() * +2);
                tablero.setElemento(i, j, celula);
            }
        }
    }

    public void RellenadoManual() {
        int celula;
        System.out.println("\tDigite 1 si la celula va a estar viva o 0 si la celula va a estar muerta\n");
        for (int i = 0; i < tablero.getRenglones(); i++) {
            for (int j = 0; j < tablero.getColumnas(); j++) {
                System.out.print("Posicion [" + i + " x " + j + "] : ");
                celula = entradaDatos.nextInt();
                if (celula == 0 || celula == 1) {
                    tablero.setElemento(i, j, celula);
                } else {
                    System.out.println("El numero ingresado no es valido");
                    tablero.setElemento(i, j, 0);
                }
            }
        }
    }

    //0 es igual a celula muerta, 1 es igual a celula viva
    public void aplicarReglas(int renglon, int columna, int dato) {
        if (dato == 1) {
            //Reglas para las celulas vivas "1"
            if (contarVecinos(renglon, columna) == 2 || contarVecinos(renglon, columna) == 3) {
                tablero.setElemento(renglon, columna, dato);
            } else {
                tablero.setElemento(renglon, columna, 0);
            }
            //Reglas para las celulas muertas "0"
        } else {
            if (contarVecinos(renglon, columna) == 3) {
                tablero.setElemento(renglon, columna, 1);
            } else {
                tablero.setElemento(renglon, columna, dato);
            }
        }
    }

    public int contarVecinos(int renglon, int columna) {
        int vecinosVivos = 0;

        if (renglon - 1 < 0) {
            //Esquina superior izquierda
            if (columna == 0) {
                if (aux.getElemento(renglon, columna + 1) == 1) {
                    vecinosVivos++;
                }
                if (aux.getElemento(renglon + 1, columna) == 1) {
                    vecinosVivos++;
                }
                if (aux.getElemento(renglon + 1, columna + 1) == 1) {
                    vecinosVivos++;
                }
                //Esquina superior derecha   
            } else if (columna == tablero.getColumnas() - 1) {
                if (aux.getElemento(renglon, columna - 1) == 1) {
                    vecinosVivos++;
                }
                if (aux.getElemento(renglon + 1, columna) == 1) {
                    vecinosVivos++;
                }
                if (aux.getElemento(renglon + 1, columna - 1) == 1) {
                    vecinosVivos++;
                }
                //Parte central superior   
            } else {
                if (aux.getElemento(renglon, columna - 1) == 1) {
                    vecinosVivos++;
                }
                if (aux.getElemento(renglon, columna + 1) == 1) {
                    vecinosVivos++;
                }
                if (aux.getElemento(renglon + 1, columna) == 1) {
                    vecinosVivos++;
                }
                if (aux.getElemento(renglon + 1, columna - 1) == 1) {
                    vecinosVivos++;
                }
                if (aux.getElemento(renglon + 1, columna + 1) == 1) {
                    vecinosVivos++;
                }
            }
        } else if (renglon + 1 > aux.getRenglones() - 1) {
            //Esquina inferior izquierda
            if (columna == 0) {
                if (aux.getElemento(renglon, columna + 1) == 1) {
                    vecinosVivos++;
                }
                if (aux.getElemento(renglon - 1, columna) == 1) {
                    vecinosVivos++;
                }
                if (aux.getElemento(renglon - 1, columna + 1) == 1) {
                    vecinosVivos++;
                }
                //Esquina inferior derecha  
            } else if (columna == aux.getColumnas() - 1) {
                if (aux.getElemento(renglon, columna - 1) == 1) {
                    vecinosVivos++;
                }
                if (aux.getElemento(renglon - 1, columna) == 1) {
                    vecinosVivos++;
                }
                if (aux.getElemento(renglon - 1, columna - 1) == 1) {
                    vecinosVivos++;
                }
                //Parte central inferior   
            } else {
                if (aux.getElemento(renglon, columna - 1) == 1) {
                    vecinosVivos++;
                }
                if (aux.getElemento(renglon, columna + 1) == 1) {
                    vecinosVivos++;
                }
                if (aux.getElemento(renglon - 1, columna) == 1) {
                    vecinosVivos++;
                }
                if (aux.getElemento(renglon - 1, columna - 1) == 1) {
                    vecinosVivos++;
                }
                if (aux.getElemento(renglon - 1, columna + 1) == 1) {
                    vecinosVivos++;
                }
            }
        } else if (renglon > 1 || renglon < aux.getRenglones() - 2) {
            //Parte lateral izquierda
            if (columna == 0) {
                if (aux.getElemento(renglon - 1, columna) == 1) {
                    vecinosVivos++;
                }
                if (aux.getElemento(renglon - 1, columna + 1) == 1) {
                    vecinosVivos++;
                }
                if (aux.getElemento(renglon, columna + 1) == 1) {
                    vecinosVivos++;
                }
                if (aux.getElemento(renglon + 1, columna) == 1) {
                    vecinosVivos++;
                }
                if (aux.getElemento(renglon + 1, columna + 1) == 1) {
                    vecinosVivos++;
                }
                //Parte lateral derecha
            } else if (columna == aux.getColumnas() - 1) {
                if (aux.getElemento(renglon - 1, columna) == 1) {
                    vecinosVivos++;
                }
                if (aux.getElemento(renglon - 1, columna - 1) == 1) {
                    vecinosVivos++;
                }
                if (aux.getElemento(renglon, columna - 1) == 1) {
                    vecinosVivos++;
                }
                if (aux.getElemento(renglon + 1, columna) == 1) {
                    vecinosVivos++;
                }
                if (aux.getElemento(renglon + 1, columna - 1) == 1) {
                    vecinosVivos++;
                }
                //Partes centrales del tablero
            } else {
                if (aux.getElemento(renglon, columna - 1) == 1) {
                    vecinosVivos++;
                }
                if (aux.getElemento(renglon, columna + 1) == 1) {
                    vecinosVivos++;
                }
                if (aux.getElemento(renglon + 1, columna) == 1) {
                    vecinosVivos++;
                }
                if (aux.getElemento(renglon + 1, columna - 1) == 1) {
                    vecinosVivos++;
                }
                if (aux.getElemento(renglon + 1, columna + 1) == 1) {
                    vecinosVivos++;
                }
                if (aux.getElemento(renglon - 1, columna) == 1) {
                    vecinosVivos++;
                }
                if (aux.getElemento(renglon - 1, columna - 1) == 1) {
                    vecinosVivos++;
                }
                if (aux.getElemento(renglon - 1, columna + 1) == 1) {
                    vecinosVivos++;
                }
            }
        }
        return vecinosVivos;
    }

    public void jugar() {
        int generaciones = 0;
        do {
            //Pasamos los datos del tablero original "tablero" al 2DADT "aux" para
            //poder hacer los calculos sin tomar en cuenta las modificaciones hechas en ese instante en el tablero original
            hacerCopiaDeTablero();
            System.out.println("");
            System.out.println("\nGeneración " + (generaciones + 1));
            //Lo descomentamos si queremos ver el tablero en String y comentamos el verTablero() para que funcione correctamente
            //tableroString(tablero);
            verTablero();
            for (int i = 0; i < aux.getRenglones(); i++) {
                for (int j = 0; j < aux.getColumnas(); j++) {
                    aplicarReglas(i, j, aux.getElemento(i, j));
                }
            }

            generaciones++;
        } while (generaciones < 10);
    }

    public void hacerCopiaDeTablero() {
        for (int i = 0; i < tablero.getRenglones(); i++) {
            for (int j = 0; j < tablero.getColumnas(); j++) {
                aux.setElemento(i, j, tablero.getElemento(i, j));
            }
        }
    }

    /*public void tableroString(Arreglo2DADT tableroOriginal){
        Arreglo2DADT<String> tableroString = new Arreglo2DADT(tableroOriginal.getRenglones(), tableroOriginal.getColumnas());
    
        //Conversion del tablero original Integer a String
        for (int i = 0; i < tableroOriginal.getRenglones() ; i++) {
            for (int j = 0; j < tableroOriginal.getColumnas(); j++) {
                //Celulas vivas
                if((int)tableroOriginal.getElemento(i, j) == 1){
                    tableroString.setElemento(i, j, "V");
                //Celulas muertas    
                }else{
                    tableroString.setElemento(i, j, ".");
                }
            }
        }
        
        //Presentacion del tablero convertido a String
        for (int i = 0; i < tableroString.getRenglones(); i++) {
            System.out.println("");
            System.out.println("-----------------------------------------------------------------------");
            for (int j = 0; j < tableroString.getColumnas(); j++) {
                System.out.print(" | " + tableroString.getElemento(i, j) + " | ");
                
            }
            
        }
    }*/
    
    public void verTablero() {
        tablero.mostrarMatriz();
    }
}
