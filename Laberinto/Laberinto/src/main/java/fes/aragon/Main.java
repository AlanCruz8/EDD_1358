package fes.aragon;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Laberinto juego = new Laberinto("Laberintos\\LaberintoUno.csv");
        juego.encontrarSalida();
    }
}
