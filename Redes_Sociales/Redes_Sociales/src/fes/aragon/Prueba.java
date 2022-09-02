package fes.aragon;

import java.io.IOException;
import java.util.Scanner;

public class Prueba {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int opcion;
		String primerMesYoutube, segundoMesYoutube, primerMesTwitter, segundoMesTwitter, primerMesFacebook,
				segundoMesFacebook;

		LecturaArchivo prueba = new LecturaArchivo();
		try {
			prueba.lecturaArchivo("C:\\Users\\hp\\Desktop\\ICO\\presenciaredes.csv");
			// prueba.imprimirrDatos();

			System.out.print("\t\t\t Menu de opciones\n\n"
					+ "\t1.Diferencia de seguidores de Twitter entre enero y junio\n"
					+ "\t2.Diferencia de visualizaciones de Youtube\n" 
					+ "\t3.Promedio de crecimiento en Twitter\n"
					+ "\t4.Promedio de crecimiento en Facebook\n"
					+ "\t5.Salir\n");

			do {

				System.out.print("\n Digite la opcion que quiera probar : ");
				opcion = input.nextInt();

				switch (opcion) {
				case 1:
					prueba.diferenciaFollowers();
					System.out.println();
					break;
				case 2:
					System.out.print("Digite el nombre del primer mes : ");
					primerMesYoutube = input.next();
					System.out.print("Digite el nombre del segundo mes : ");
					segundoMesYoutube = input.next();
					prueba.visualizacionesDeYoutube(primerMesYoutube, segundoMesYoutube);
					break;
				case 3:
					System.out.print("Digite el nombre del primer mes : ");
					primerMesTwitter = input.next();
					System.out.print("Digite el nombre del segundo mes : ");
					segundoMesTwitter = input.next();
					prueba.crecimientoDeTwitter(primerMesTwitter, segundoMesTwitter);
					break;
				case 4:
					System.out.print("Digite el nombre del primer mes : ");
					primerMesFacebook = input.next();
					System.out.print("Digite el nombre del segundo mes : ");
					segundoMesFacebook = input.next();
					prueba.crecimientoDeFacebook(primerMesFacebook, segundoMesFacebook);
					break;
				default:
					break;
				}

			} while ((opcion > 0) && (opcion <= 4));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
