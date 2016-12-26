package creation;

import util.MyGenerator;

public class CreationMain {

	public static void main(String[] args) {
		showMemory();
		StreamCreator streamCreator = new StreamCreator();
		WithoutStream withoutStream = new WithoutStream();
		streamCreator.useStreamBuilder();
		
		int size = 1000000000; // 10^9
		System.out.println("\n***** Suma " + size + " enteros *****");
		withoutStream.testIntSum(size);
		streamCreator.testIntStream(size, true);
		
		size = 100000000; // 10^8
		System.out.println("\n***** Suma de " + size + " números decimales dobles *****");
		double[] numbersArray = MyGenerator.generateDoubleArray(size);
		withoutStream.testDoubleSum(numbersArray);
		streamCreator.testDoubleStream(numbersArray);
		numbersArray = null; // Para decirle al Garbage Collector que no queremos mantenerlo en memoria
		
		System.out.println("\n***** Creación de un array de números decimales dobles VS DoubleStream (ambos de " 
				+ size + " elementos) *****");
		withoutStream.testArrayCreation(size);
		streamCreator.testDoubleStreamCreation(size);
		
		size = 200000;
		System.out.println("\n***** Suma de todos los números primos menores a " + size + " *****");
		withoutStream.testSumPrimeNumbers(size);
		streamCreator.testFromFunction(size);
		
		System.out.println("\n***** Algunas líneas de código *****");
		streamCreator.testFromFile();
	
	}
	
	private static void showMemory() {
		System.out.println("\nMemoria total (en bytes): " + Runtime.getRuntime().totalMemory());
		System.out.println("Memoria libre (en bytes): " + Runtime.getRuntime().freeMemory());
		//System.out.println("Procesadores libres: " + Runtime.getRuntime().availableProcessors());
	}

}
