package creation;

import interfaces.CreationInterface;
import util.MyGenerator;

class WithoutStream implements CreationInterface{
	private long start; // Variable para guardar el tiempo de inicio del testeo
	private long end; // Variable para guardar el tiempo final del testeo
	private int intSum; // Variable para guardar la suma de todos los números enteros
	private double doubleSum; // Variable para guardar la suma de todos los números double
	
	WithoutStream() {
		super();
	}
	
	/**
	 * Testeo de la suma de números enteros
	 * 
	 * @param size: cantidad de números a sumar
	 */
	void testIntSum(int size) {
		start = System.nanoTime();
		intSum = 0;
		for(int i=1; i<=size; i++)
			intSum += i;
		
		end = System.nanoTime();
		allPrints(start, end, intSum);
	}
	
	/**
	 * Testeo de la suma de números decimales dobles de un array
	 * @param array: array de números decimales dobles
	 */
	void testDoubleSum(double[] array) {
		start = System.nanoTime();
		doubleSum = 0;
		for(int i=0; i<array.length; i++)
			doubleSum += array[i];
		
		end = System.nanoTime();
		allPrints(start, end, doubleSum);
	}
	
	/**
	 * Testeo del tiempo de creación  de un array de números decimales dobles
	 * @param size: tamaño del array
	 */
	void testArrayCreation(int size) {
		start = time();
		MyGenerator.generateDoubleArray(size);
		end = time();
		
		myPrint();
		timePrint(start, end);
	}
	
	/**
	 * Testeo de la suma de números primos
	 * @param size: máximo número a comprobar si es primo
	 */
	void testSumPrimeNumbers(int size) {
		start = time();
		intSum = 0;
		for(int i=1; i<size; i++)
			if(isPrimeNumber(i))
				intSum += i;
		end = time();
		
		allPrints(start, end, intSum);
	}

	@Override
	public void myPrint() {
		System.out.println("----- Sin stream -----");
		
	}

}
