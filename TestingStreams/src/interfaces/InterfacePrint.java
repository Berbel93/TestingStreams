package interfaces;

import util.MyDecimalFormat;

public interface InterfacePrint {
	void myPrint();
	
	default void timePrint(long start) {
		System.out.println("Tiempo empleado: " + MyDecimalFormat
				.format((System.nanoTime() - start) / 1e9) + " segundos");
	}
	
	default void sumPrint(int sum) {
		System.out.println("Suma: " + sum);
	}
	
	default void allPrints(long start, int sum) {
		myPrint();
		timePrint(start);
		sumPrint(sum);
	}
	
	default <T> void optionalPrint(T value) {
		System.out.println("Optional contiene el valor: " + value);
	}
	
	default void exceptionPrint() {
		System.out.println("Optional no contiene ningún valor");
	}

}
