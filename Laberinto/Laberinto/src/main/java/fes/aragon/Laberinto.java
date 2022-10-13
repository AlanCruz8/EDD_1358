package fes.aragon;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Laberinto {

    private Arreglo2DADT laberinto;
    private Jugador jugador;
    private String rutaArchivo;
    private String entrada, salida;

    public Laberinto(String ruta) throws FileNotFoundException, IOException {
        ArrayList<String[]> casillasLaberinto = new ArrayList();
        this.rutaArchivo = ruta;
        //Lectura del archivo
        String info = null;
        ArrayList<String> lineas = new ArrayList<>();
        String tmp[], tmpEntrada[];

        BufferedReader entrada = new BufferedReader(new FileReader(this.rutaArchivo));
        while ((info = entrada.readLine()) != null) {
            lineas.add(info);
        }

        //Pasamos las lineas que contienen el mapa del laberinto
        for (int i = 2; i < lineas.size() - 2; i++) {
            tmp = lineas.get(i).split(",");
            casillasLaberinto.add(tmp);
        }

        //Creacion del laberinto vacio(todo true)
        this.laberinto = new Arreglo2DADT(Integer.parseInt(lineas.get(0)), Integer.parseInt(lineas.get(1)));

        //Modificacion del laberinto, cambiando las casillas para que sean iguales a las que propuso el usuario
        for (int i = 0; i < casillasLaberinto.size(); i++) {
            for (int j = 0; j < casillasLaberinto.get(i).length; j++) {
                if (casillasLaberinto.get(i)[j].equalsIgnoreCase("0")) {
                    laberinto.setElemento(i, j, " ");
                } else {
                    laberinto.setElemento(i, j, "0");
                }
            }
        }

        this.entrada = lineas.get(lineas.size() - 2);
        this.salida = lineas.get(lineas.size() - 1);
        tmpEntrada = lineas.get(lineas.size() - 2).split(",");
        this.jugador = new Jugador(Integer.parseInt(tmpEntrada[0]), Integer.parseInt(tmpEntrada[1]));
    }

    //Metodo para marcar las casillas que el jugador ya visito 
    public void caminoRecorrido(int x, int y) {
        this.laberinto.setElemento(x, y, "*");
    }

    //Lo llamamos en el metodo direccion en caso de que el jugador este en un punto sin salida
    public void caminoSinSalida(int x, int y) {
        laberinto.setElemento(x, y, "0");
    }

    //Definimos los limites del laberinto para poder hacer las operaciones
    public boolean limitesLaberinto(int x, int y) {
        return x >= 0 && x < this.laberinto.getRenglones() && y >= 0 && y < this.laberinto.getColumnas();
    }

    public boolean reglasDeVisita(int x, int y) {
        //Bandera booleana para saber si el jugador pudo moverse dentro del laberinto
        boolean haySalida=false;
        //En caso de que las coordenadas esten dentro de los limites verificamos el paso que debe dar el jugador
        if (this.limitesLaberinto(x, y)) {
            this.caminoRecorrido(x, y);
            //Izquierda
            if (y - 1 >=0 && laberinto.getElemento(x, y - 1).equals(" ")) {
                //this.caminoRecorrido(x, y);
                jugador.mover(x, y - 1);
                haySalida = true;
            } //Arriba
            else if (x - 1 >=0 && laberinto.getElemento(x - 1, y).equals(" ")) {
                //this.caminoRecorrido(x, y);
                jugador.mover(x - 1, y);
                haySalida = true;
            } //Derecha
            else if (y + 1 < laberinto.getColumnas() && laberinto.getElemento(x, y + 1).equals(" ")) {
                //this.caminoRecorrido(x, y);
                jugador.mover(x, y + 1);
                haySalida = true;
            } //Abajo
            else if ( x + 1 < laberinto.getRenglones() && laberinto.getElemento(x + 1, y).equals(" ")) {
                //this.caminoRecorrido(x, y);
                jugador.mover(x + 1, y);
                haySalida = true;
            } //No hay salida
            //Hacemos pop
            else if(!haySalida){
                this.caminoSinSalida(x, y);
                jugador.regresar();
                haySalida=true;
                //Si no encuentra una salida aun haciendo pop y llega a la entrada , entonces no tiene solucion el laberinto
                if(jugador.posicionActual().equalsIgnoreCase(this.entrada)){
                    haySalida=false;
                }
            }
            //Si la posicion del jugadro esta fuera de los limites el laberinto no puede solucionarse
        } else {
            haySalida = false;
        }
        return haySalida;
    }

    //Evaluamos si el jugador en las coordenadas x,y se puede mover dentro del laberinto
    public boolean puedoMoverme(int x, int y) {
        if (this.reglasDeVisita(x, y)) {
            return true;
        } else {
            System.out.println("\nNo hay solucion para el laberinto propuesto");
            return false;
        }
    }

    //Solucion e impresion del laberinto con la ruta solucion(coordenadas en String)
    public void encontrarSalida() {
        while (puedoMoverme(jugador.getCoorX(), jugador.getCoorY())) {
            laberinto.mostrarMatriz();
            System.out.println("");
            if (jugador.posicionActual().equalsIgnoreCase(this.salida)) {
                this.laberinto.setElemento(jugador.getCoorX(), jugador.getCoorY(), "*");
                laberinto.mostrarMatriz();
                break;
            }
        }
        System.out.println("\nCamino solucion : " + jugador.getCamino());
    }
}
