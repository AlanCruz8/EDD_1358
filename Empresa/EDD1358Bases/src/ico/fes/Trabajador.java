/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ico.fes;

/**
 *
 * @author Cabrera
 */
public class Trabajador {
    private double HORA_EXTRA;
    private int numero_trabador;
    private String nombre;
    private String paterno;
    private String materno;
    private int horas_extra;
    private double sueldo_base;
    private int anio_ingreso;

    public Trabajador(int nt, String nom, String pat, String mat, int ht, double suel, int anio) {
        this.HORA_EXTRA = 276.5;
        this.numero_trabador = nt;
        this.nombre = nom;
        this.paterno = pat;
        this.materno = mat;
        this.horas_extra = ht;
        this.sueldo_base = suel;
        this.anio_ingreso = anio;
    }

    public int getNumero_trabador() {
        return numero_trabador;
    }

    public void setNumero_trabador(int nt) {
        this.numero_trabador = nt;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nom) {
        this.nombre = nom;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String pat) {
        this.paterno = pat;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String mat) {
        this.materno = mat;
    }

    public int getHoras_extra() {
        return horas_extra;
    }

    public void setHoras_extra(int he) {
        this.horas_extra = he;
    }

    public double getSueldo_base() {
        return sueldo_base;
    }

    public void setSueldo_base(double sb) {
        this.sueldo_base = sb;
    }

    public int getAnio_ingreso() {
        return anio_ingreso;
    }

    public void setAnio_ingreso(int ai) {
        this.anio_ingreso = ai;
    }

    @Override
    public String toString() {
        return "Trabajador{" + "id=" + numero_trabador + " nombre=" + nombre + '}';
    }
    
    public double calcular_sueldo(){
        double antiguedad = 2022 - this.anio_ingreso;
        double total = this.sueldo_base + (this.sueldo_base*(antiguedad*0.03)) + (this.horas_extra * this.HORA_EXTRA);
        return total;
    }
    
}
