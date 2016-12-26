package introduction;

import java.util.List;

import interfaces.BasicInterface;

/**
 * @author PabloBerbel
 *
 * Clase para realizar las mismas operaciones que los streams, pero de la forma tradicional.
 */
public class WithoutStreamIntroduction implements BasicInterface{
	private static final int FILTER = 100; // Filtro para la suma de números
	private long start; // Variable para guardar el tiempo de inicio del testeo
	private long end; // Variable para guardar el tiempo final del testeo
	
	public WithoutStreamIntroduction() {
		super();
	}
	
	/**
	 * Testeo de la iteración for
	 * @param numbers: lista de números enteros
	 */
	void testIteration(List<Integer> numbers) {
		start = System.nanoTime();
		int sum = 0;
		
		for(int n:numbers)
			if(n < FILTER)
				sum += n;
		
		end = System.nanoTime();
		allPrints(start, end, sum);;
	}

	/**
	 * Imprime por pantalla que no estamos utilizando streams para el testeo
	 */
	@Override
	public void myPrint() {
		System.out.println("\n----- Sin stream -----");
	}

}
