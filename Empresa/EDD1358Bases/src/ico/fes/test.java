/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ico.fes;

import java.io.IOException;

/**
 *
 * @author hp
 */
public class test {
    public static void main(String[] args) throws IOException {
        NominaADT test = new NominaADT("recursos\\junio.dat");
        test.listar_sueldos();
        System.out.println("Mayor antiguedad");
        test.mayor_antiguedad();
        System.out.println("Menor antiguedad");
        test.menor_antiguedad();
    }
  
}
