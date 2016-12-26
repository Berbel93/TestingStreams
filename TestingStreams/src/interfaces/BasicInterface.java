package interfaces;

import util.MyDecimalFormat;

public interface BasicInterface {
	void myPrint();
	
	default long time() {
		return System.nanoTime();
	}
	
	default void timePrint(long start, long end) {
		System.out.println("Tiempo empleado: " + MyDecimalFormat
				.format((end - start) / 1e9) + " segundos");
	}
	
	default <T> void sumPrint(T sum) {
		System.out.println("Suma: " + sum);
	}
	
	default <T> void allPrints(long start, long end, T sum) {
		myPrint();
		timePrint(start, end);
		sumPrint(sum);
	}

}
