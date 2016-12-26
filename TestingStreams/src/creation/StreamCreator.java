package creation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import interfaces.CreationInterface;
import util.MyGenerator;
/**
 * @author PabloBerbel
 *
 * Clase para crear streams de diferentes formas
 */
class StreamCreator implements CreationInterface{
	private long start; // Variable para guardar el tiempo de inicio del testeo
	private long end; // Variable para guardar el tiempo final del testeo
	private int intSum; // Variable para guardar la suma de todos los números enteros
	private double doubleSum; // Variable para guardar la suma de todos los números double
	
	/**
	 * Uso de un Stream builder para crear un stream de números enteros
	 */
	void useStreamBuilder() {
		//Stream.Builder<Integer> builder = Stream.builder();
		Stream<Integer> stream = Stream.<Integer> builder()
				.add(0)
				.add(1)
				.add(2)
				.add(3)
				.build();
		
		stream.forEach(System.out::println); // Para cada elemento del stream, lo imprime por pantalla
	}
	
	/**
	 * Testeo del tiempo de ejecución en un IntStream
	 * 
	 * @param size: cantidad de números que contendrá el stream
	 * @param inclusiveEnd: true si queremos que el final sea inclusivo, 
	 * false si queremos que sea exclusivo
	 */
	void testIntStream(int size, boolean inclusiveEnd) {
		start = time();
		IntStream stream = inclusiveEnd ? IntStream.rangeClosed(0, size):IntStream.range(0, size);
		intSum = stream.sum();
		//intSum = stream.reduce(0, Integer::sum);
		stream.close();
		
		end = time();
		allPrints(start, end, intSum);
	}
	
	/**
	 * Testeo del tiempo de ejecución en un DoubleStream
	 * 
	 * @param numbers: array de números double
	 */
	void testDoubleStream(double[] numbers) {
		DoubleStream stream = DoubleStream.of(numbers);
		start = time();
		doubleSum = stream.reduce(0, Double::sum);
		
		// Mucho más lento
		//doubleSum = stream.sum(); 
		
		end = time();
		allPrints(start, end, doubleSum);
		
	}
	
	/**
	 * Testeo del tiempo de creación de un DoubleStream
	 * 
	 * @param size: cantidad de números que contendrá el stream
	 */
	void testDoubleStreamCreation(int size) {
		start = time();
		MyGenerator.generateDoubleStream(size);
		end = time();
		
		myPrint();
		timePrint(start, end);
	}
	
	/** 
	 * Testeo del tiempo de ejecución en un IntStream que utiliza una función para saber 
	 * si un número es o no primo
	 * 
	 * @param size: máximo número a comprobar si es primo
	 */
	void testFromFunction(int size) {
		start = time();
		IntStream stream = IntStream.range(1, size);
		intSum = stream
		.filter(n -> isPrimeNumber(n))
		.reduce(0, Integer::sum);
		end = time();
		
		allPrints(start, end, intSum);
	}
	
	/**
	 * Uso de un stream que lee un fichero
	 */
	void testFromFile(){
		Path path = Paths.get("./src/creation/StreamCreator.java");
		int linesToSkip = 15; // Descartaremos las primeras 15 líneas
		int linesLimit = 5; // Nos quedaremos con 5 líneas
		
		try(Stream<String> lines = Files.lines(path)) {
			lines.filter(n -> n.length() > 0).skip(linesToSkip).limit(linesLimit).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Imprime por pantalla que estamos utilizando streams para el testeo
	 */
	@Override
	public void myPrint() {
		System.out.println("\n----- Creación de streams -----");
		
	}
}
