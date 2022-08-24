package fes.aragon;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LecturaArchivo {

	private String linea = null;
	private String[] partes;
	private String[][] datosEnMatriz = new String[19][15];
	private int i = 0;

	public void lecturaArchivo(String nombreArchivo) throws IOException {
		try {
			BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo));
			// Lectura del archivo
			while ((linea = lector.readLine()) != null) {
				partes = linea.split(",");
				// Almacenamiento de las lineas del archivo en una matriz
				for (int j = 0; j < partes.length; j++) {
					datosEnMatriz[i][j] = partes[j];
				}
				// Contador para el numero de fila en la cual debe guardarse el dato
				i++;
			}

			lector.close();
			i = 0;
			partes = null;
			linea = null;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void imprimirrDatos() {
		for (int i = 0; i < datosEnMatriz.length; i++) {
			System.out.println();
			for (int j = 0; j < datosEnMatriz[i].length; j++) {
				System.out.print(datosEnMatriz[i][j] + " ");

			}
		}
	}

	public void diferenciaFollowers() {
		// Conversion de los datos de la matriz a enteros para poder hacer los calculos
		int numeroFilaTwitter = 8;
		
		int enero = Integer.parseInt(datosEnMatriz[numeroFilaTwitter][3]);
		int julio = Integer.parseInt(datosEnMatriz[numeroFilaTwitter][8]);

		// Impresion del calculo de seguidores
		System.out.print("Diferencia de seguidores de Twitter entre enero y junio : " + (enero + julio));
	}

	public void crecimientoDeFacebook(String primerMes, String segundoMes) {
		// Variables para calcular la posicion de los meses digitados por el usuario
		int fila = 0;
		int numeroFilaFacebook = 3;
		int posicionMesUno = 0;
		int posicionMesDos = 0;
		float porcentajeMesUno, porcentajeMesDos, promedioDePorcentajeFacebook;

		for (int i = 0; i < datosEnMatriz[fila].length; i++) {
			// Salida del for en caso de ya haber encontrado la posicion del mes
			// seleccionado
			if (datosEnMatriz[fila][i].equalsIgnoreCase(primerMes)) {
				break;
			}
			posicionMesUno++;
		}

		for (int i = 0; i < datosEnMatriz[fila].length; i++) {
			// Salida del for en caso de ya haber encontrado la posicion del mes
			// seleccionado
			if (datosEnMatriz[fila][i].equalsIgnoreCase(segundoMes)) {
				break;
			}
			// Contador de posiciones recorridas
			posicionMesDos++;
		}

		// Separamos la el caracter % de la cadena para poder hacer la conversion a
		// Integer
		String[] crecimientoSinPorcentajeUno = datosEnMatriz[numeroFilaFacebook][posicionMesUno].split("%");
		porcentajeMesUno = Float.parseFloat(crecimientoSinPorcentajeUno[0]);
		String[] crecimientoSinPorcentajeDos = datosEnMatriz[numeroFilaFacebook][posicionMesDos].split("%");
		porcentajeMesDos = Float.parseFloat(crecimientoSinPorcentajeDos[0]);

		// Calculamos el promedio de porcentaje
		promedioDePorcentajeFacebook = ((porcentajeMesUno + porcentajeMesDos) / 2);
		
		System.out.print("\nEl promedio de porcentaje de crecimiento en Facebook, entre los meses " + primerMes + " y "
				+ segundoMes + " es de : " + promedioDePorcentajeFacebook + "%");
	}

	public void crecimientoDeTwitter(String primerMes, String segundoMes) {
		// Variables para calcular la posicion de los meses digitados por el usuario
		int fila = 0;
		int numeroFilaTwitter = 10;
		int posicionMesUno = 0;
		int posicionMesDos = 0;
		float porcentajeMesUno, porcentajeMesDos, promedioDePorcentajeTwitter;

		for (int i = 0; i < datosEnMatriz[fila].length; i++) {
			// Salida del for en caso de ya haber encontrado la posicion del mes
			// seleccionado
			if (datosEnMatriz[fila][i].equalsIgnoreCase(primerMes)) {
				break;
			}
			posicionMesUno++;
		}

		for (int i = 0; i < datosEnMatriz[fila].length; i++) {
			// Salida del for en caso de ya haber encontrado la posicion del mes
			// seleccionado
			if (datosEnMatriz[fila][i].equalsIgnoreCase(segundoMes)) {
				break;
			}
			// Contador de posiciones recorridas
			posicionMesDos++;
		}

		// Separamos la el caracter % de la cadena para poder hacer la conversion a
		// Integer
		String[] crecimientoSinPorcentajeUno = datosEnMatriz[numeroFilaTwitter][posicionMesUno].split("%");
		porcentajeMesUno = Float.parseFloat(crecimientoSinPorcentajeUno[0]);
		String[] crecimientoSinPorcentajeDos = datosEnMatriz[numeroFilaTwitter][posicionMesDos].split("%");
		porcentajeMesDos = Float.parseFloat(crecimientoSinPorcentajeDos[0]);

		promedioDePorcentajeTwitter = ((porcentajeMesUno + porcentajeMesDos) / 2);

		System.out.print("\nEl promedio de porcentaje de crecimiento en Twitter, entre los meses " + primerMes + " y "
				+ segundoMes + " es de : " + promedioDePorcentajeTwitter + "%");
	}

	public void visualizacionesDeYoutube(String primerMes, String segundoMes) {
		// Variables para calcular la posicion de los meses digitados por el usuario
		int fila = 0;
		int numeroFilaYoutube = 16;
		int posicionPrimerMes = 0;
		int posicionSegundoMes = 0;
		// Variables para almacenar los valores (enteros) de los datos dentro del la
		// matriz
		int datoMesUno, datoMesDos;

		for (int i = 0; i < datosEnMatriz[fila].length; i++) {
			if (datosEnMatriz[fila][i].equalsIgnoreCase(primerMes)) {
				break;
			}
			// Contador de posiciones recorridas
			posicionPrimerMes++;
		}

		for (int i = 0; i < datosEnMatriz[fila].length; i++) {
			if (datosEnMatriz[fila][i].equalsIgnoreCase(segundoMes)) {
				break;
			}
			// Contador de posiciones recorridas
			posicionSegundoMes++;
		}

		datoMesUno = Integer.parseInt(datosEnMatriz[numeroFilaYoutube][posicionPrimerMes]);
		datoMesDos = Integer.parseInt(datosEnMatriz[numeroFilaYoutube][posicionSegundoMes]);
		// Impresion del calculo
		System.out.print("\n Diferencia de visualizaciones entre el mes de " + primerMes + " y el mes de " + segundoMes
				+ " : " + (datoMesDos - datoMesUno));
	}
}
