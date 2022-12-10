/*

Framework: Java Collections
LinkedList
Cruz Carcamo Alan Eduardo

 */
package fes.aragon;

import java.util.LinkedList;

public class LinkedList_Main {
    public static void main(String[] args) {
        //Hacemos una instancia de tipo LinkedList con una variable de instancia llamada Spotify
        LinkedList spotify = new LinkedList();
        
        //Agregamos una serie de canciones a nuestra lista, a través del método add, addLast y addFirst
        spotify.addFirst("La incondicional");
        spotify.addLast("Neverita");
        spotify.addLast("Me rehuso");
        spotify.add("Mujeres divinas");
        
        //Buscamos la canción que esta hasta el ultimo de nuestra lista de reproducción
        System.out.println("La ultima canción en la lista de reproducción es : " + spotify.getLast());
        
        //Buscamos dentro de nuestra lista de reproducción, ¿En qué lugar esta Neverita?
        System.out.println("Neverita está en la posicion : " + spotify.indexOf("Neverita"));
        
        //Checamos si nuestra lista de reproducción esta vacia o no
        System.out.println("¿Está vacia? : " + spotify.isEmpty());
        
        //Chechamos el tamaño que tiene nuestra lista de reproducción
        System.out.println("Tamaño : " + spotify.size());
        
        //Por ultimo, mostramos las canciones que tiene nuestra lista de reproducción
        System.out.println("\t\tLista de reproducción\n");
        for (Object cancion : spotify) {
            System.out.println("| " + cancion + " |");
        }
    }
}
