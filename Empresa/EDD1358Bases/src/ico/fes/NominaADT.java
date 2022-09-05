/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ico.fes;

import adts.arrays.ArregloADT;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 *
 * @author Cabrera
 */
public class NominaADT {
    private String archivo;
    private ArrayList<String> lineas = new ArrayList<>();
    private ArregloADT<Trabajador> nomina;
    private String[] tmp;
    private String info=null;
    private int numero_lineas=0;
    private Trabajador trabTemp;
    
    public NominaADT(String ruta) throws FileNotFoundException, IOException{
        this.archivo=ruta;
        BufferedReader entrada = new BufferedReader(new FileReader(this.archivo));
        while((info = entrada.readLine()) != null){
            lineas.add(info);
            numero_lineas+=1;
        }
        
        
        this.nomina=new ArregloADT(numero_lineas-1);
        int contador=0;
        
        for (int i = 1; i < lineas.size(); i++) {
            tmp = lineas.get(i).split(",");
            Integer numero_trabajador = Integer.parseInt(tmp[0]);
            Integer horas_extra = Integer.parseInt(tmp[4]);
            Double sueldo_base = Double.parseDouble(tmp[5]);
            Integer anio = Integer.parseInt(tmp[6]);
            trabTemp = new Trabajador(numero_trabajador, tmp[1], tmp[2], tmp[3], horas_extra, sueldo_base, anio);
            this.nomina.setElemento(contador, trabTemp);
            contador+=1;
        }
        
        System.out.println(this.nomina);
    }
    
    public void listar_sueldos(){
        for (int i = 0; i < this.nomina.getLongitud(); i++) {
            Trabajador emp = this.nomina.getElemento(i);
            System.out.println("Id : " +emp.getNumero_trabador() + "\t" + "Sueldo : " + emp.calcular_sueldo());
        }
    }

    public void mayor_antiguedad(){
        int mayor = 2023;
        int idx = 0;
        for (int i = 0; i < this.nomina.getLongitud(); i++) {
            Trabajador emp = this.nomina.getElemento(i);
            if(emp.getAnio_ingreso() < mayor){
                idx=i;
                mayor = emp.getAnio_ingreso();
            } 
        }
        System.out.println(this.nomina.getElemento(idx));
    }
    
    public void menor_antiguedad(){
        int menor = 0;
        int idx = 0;
        for (int i = 0; i < this.nomina.getLongitud(); i++) {
            Trabajador emp = this.nomina.getElemento(i);
            if(emp.getAnio_ingreso() > menor){
                idx=i;
                menor = emp.getAnio_ingreso();
            } 
        }
        System.out.println(this.nomina.getElemento(idx));
    }
}
