/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package fes.aragon;

import java.util.Scanner;

/**
 *
 * @author hp
 */
public class JuegoDeLaVida {

    public static void main(String[] args) {
        Scanner entradaDatos = new Scanner(System.in);

        int opcion;
        Tablero juego = new Tablero();

        System.out.println("\t\t\t Juego de la vida\n");
        System.out.println("\t0 es celula muerta \t 1 es celula viva\n");
        System.out.println("\t\tDigite la opcion que desea usar\n\n"
                + "1. Automatico\n"
                + "2. Manual\n"
                + "3. Salir\n");
        opcion = entradaDatos.nextInt();

        switch (opcion) {
            case 1:
                juego.RellenadoAleatorio();
                juego.jugar();
                break;
            case 2:
                juego.RellenadoManual();
                juego.jugar();
                break;
            case 3:
                break;
            default:
                System.out.println("La opcion digitada no existe");
                break;
        }
    }
}
