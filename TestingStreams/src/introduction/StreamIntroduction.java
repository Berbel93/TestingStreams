package introduction;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import interfaces.IntroInterface;
/**
 * @author PabloBerbel
 *
 * Clase para testear los streams
 */
class StreamIntroduction implements IntroInterface{
	private static final int FILTER = 100; // Filtro para la suma de números
	private long start; // Variable para guardar el tiempo de inicio del testeo
	private long end; // Variable para guardar el tiempo final del testeo
	private int sum; // Variable para guardar la suma de todos los números
	
	/**
	 * Testeo del tiempo de ejecución de la iteración interna del stream
	 * Sumamos todos los números de la lista menores que FILTER
	 * 
	 * @param numbers: lista de números enteros
	 */
	void testInternalIteration(List<Integer> numbers) {
		start = System.nanoTime();
		
		// numbers.stream() devuelve un objeto de tipo Stream<Integer>
		sum = numbers.stream()
				.filter(n -> n < FILTER)
				.reduce(0, Integer::sum); 
		
		end = System.nanoTime();
		allPrints(start, end, sum);
	}
	
	/**
	 * Testeo del tiempo de ejecución de la iteración interna del stream en paralelo
	 * @param numbers: lista de números enteros
	 */
	void testInternalParallelIteration(List<Integer> numbers) {
		start = System.nanoTime();
		
		sum = numbers.parallelStream()
				.filter(n -> n < FILTER)
				.reduce(0, Integer::sum);
		
		end = System.nanoTime();
		allPrints(start, end, sum);
	}
	
	/**
	 * Testeo del tiempo de ejecución de la iteración interna del stream 
	 * en paralelo usando la clase IntStream
	 * @param numbers: lista de números enteros
	 */
	void testIntStream(List<Integer> numbers) {
		start = System.nanoTime();
		
		IntStream stream = numbers.parallelStream().mapToInt(Integer::intValue);
		sum = stream.filter(n -> n < FILTER).reduce(0, Integer::sum);
		
		end = System.nanoTime();
		allPrints(start, end, sum);	
	}
	
	/**
	 * Testeo de la nueva clase Optional para tratar con NullPointerException de una forma más agradable
	 */
	void testOptional() {
		// Optional con el valor "Testing Optional"
		Optional<String> nonNullOptional = Optional.of("Testing optional");
		
		// Optional sin ningún valor ya que ningún número cumple la condición del filtro
		OptionalInt nullOptional = IntStream.of(2, 4, 6, 8, 10).filter(n -> n % 2 == 1).max();
		
		// Optional vació
		Optional<String> emptyOptional = Optional.empty(); // String str = null;
		
		myPrint();
		
		nonNullOptional.ifPresent(value -> optionalPrint(value)); // Imprimirá
		nullOptional.ifPresent(value -> optionalPrint(value)); // No imprimirá
		emptyOptional.ifPresent(value -> optionalPrint(value)); // No imprimirá
		
		if(nonNullOptional.isPresent()) optionalPrint(nonNullOptional.get());
		if(nullOptional.isPresent()) optionalPrint(nullOptional.getAsInt());
		
		optionalPrint(nonNullOptional); //Imprime Optional[Testing optional]
		optionalPrint(emptyOptional); // Imprime Optional.empty
		
		try {
			optionalPrint(emptyOptional.get());
		} catch (NoSuchElementException e) {
			exceptionPrint();
		}
	}
	
	/**
	 * Imprime por pantalla que estamos utilizando streams para el testeo
	 */
	@Override
	public void myPrint() {
		System.out.println("\n----- Con stream -----");
	}

}
