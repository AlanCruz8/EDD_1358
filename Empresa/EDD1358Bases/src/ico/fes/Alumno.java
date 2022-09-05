/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ico.fes;

/**
 *
 * @author Cabrera
 */
public class Alumno {
  private String numeroCuenta;
    private String nombre;
    private String carrera;
    private double promedio;

    public Alumno() {
    }

    public Alumno(String numeroCuenta, String nombre, String carrera, double promedio) {
        this.numeroCuenta = numeroCuenta;
        this.nombre = nombre;
        this.carrera = carrera;
        this.promedio = promedio;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "Alumno{" + "numeroCuenta=" + numeroCuenta + ", nombre=" + nombre + ", carrera=" + carrera + ", promedio=" + promedio + '}';
    }


    
    
}
