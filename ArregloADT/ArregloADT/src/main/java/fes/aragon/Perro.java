package fes.aragon;

public class Perro {
   private String nombre;
   private String raza;
   private int edad;

 public Perro(String nombre, String raza, int edad) {
    this.nombre = nombre;
    this.raza = raza;
    this.edad = edad;
    }

 @Override
 public String toString() {
    return "Perro{" + "nombre=" + nombre + ", raza=" + raza + ", edad=" + edad + '}';
    }
}
