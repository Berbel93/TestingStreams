package util;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.DoubleStream;

/**
 * @author PabloBerbel
 *
 * Clase utilizada para generar elementos.
 */
public class MyGenerator {
	private static final int MAX_NUMBER = 200;
	private static final Random GENERATOR = new Random();
	
	/**
	 * @param size: tamaño de la lista
	 * @param maxNumber: todos los números de la lista estarán 
	 * dentro del siguiente rango: 0 < número < maxNumber
	 * 
	 * @return lista de números enteros aleatorios generada
	 */
	public static ArrayList<Integer> generateIntegerList(int size) {
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=0; i<size; i++)
			list.add(GENERATOR.nextInt(MAX_NUMBER));
		
		return list;
	}
	
	/**
	 * @param size: tamaño del array
	 * 
	 * @return array de números decimales dobles aleatorios
	 */
	public static double[] generateDoubleArray(int size) {
		double[] array = new double[size];
		
		for(int i=0; i<size; i++)
			array[i] = GENERATOR.nextDouble();
		
		return array;
	}
	
	/**
	 * 
	 * @param size: tamaño del stream
	 * 
	 * @return DoubleStream de números decimales dobles aleatorios
	 */
	public static DoubleStream generateDoubleStream(int size) {
		return new Random().doubles(size);
	}
		
}
