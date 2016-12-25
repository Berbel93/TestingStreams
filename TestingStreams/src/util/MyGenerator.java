package util;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author PabloBerbel
 *
 * Clase utilizada para generar elementos.
 */
public class MyGenerator {
	private static final int MAX_NUMBER = 200;
	
	/**
	 * @param size: tamaño de la lista
	 * @param maxNumber: todos los números de la lista estarán 
	 * dentro del siguiente rango: 0 < número < maxNumber
	 * 
	 * @return lista de números enteros aleatorios generada
	 */
	public static ArrayList<Integer> generateIntegerList(int size) {
		ArrayList<Integer> list = new ArrayList<>();
		Random g = new Random();
		
		for(int i=0; i<size; i++)
			list.add(g.nextInt(MAX_NUMBER));
		
		return list;
	}

}
