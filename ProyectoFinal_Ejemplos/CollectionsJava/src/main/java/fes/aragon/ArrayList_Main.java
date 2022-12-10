/*

Framework: Java Collections
ArrayList
Cruz Carcamo Alan Eduardo

 */
package fes.aragon;

import java.util.ArrayList;

public class ArrayList_Main {

    public static void main(String[] args) {
        //Hacemos una instancia de tipo ArrayList con una variable de instancia llamada tienda
        ArrayList tienda = new ArrayList();

        //Agregamos o surtimos la tienda de algunos productos comunes que suelen vender
        tienda.add("Aceite 123");
        tienda.add("Jabón Roma");
        tienda.add("Pinol");
        tienda.add("Coca cola");
        tienda.add("Galletas principe");

        //Mostramos los productos que hasta ahora tiene nuestra tienda
        String productos = "\t\tProductos en existencia\n";

        //Recorremos la tienda a través del iterator para saber con qué productos cuenta
        for (Object producto : tienda) {
            //Concatenamos cada producto con la cadena llamada productos, para asi poder mostrarlos
            productos += "\n|" + producto + " |";
        }

        //Imprimimos los productos con los que cuenta nuestra tienda
        System.out.println(productos);

        //Eliminamos algunos productos que vendimos en nuestra tienda
        tienda.remove("Coca cola");
        tienda.remove("Galletas principe");

        //Mostramos de nuevo, ahora con que productos contamos
        System.out.println();
        for (Object producto : tienda) {
            System.out.println(producto);
        }

        //Vemos si contamos todavia con galletas principe
        System.out.println();
        System.out.println("¿Todavia tenemos galletas? : " + tienda.contains("Galletas principe"));

        //Vendemos todo lo que teniamos de productos en la tienda
        tienda.clear();
    }
}
