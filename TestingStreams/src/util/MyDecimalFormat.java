package util;

import java.text.DecimalFormat;

/**
 * @author PabloBerbel
 *
 * Clase para formatear los tiempos de ejecución.
 */
public class MyDecimalFormat {
	private static final DecimalFormat f = new DecimalFormat("0.0000");
	
	/**
	 * @param number: número a formatear
	 * @return número con el formato adecuado
	 */
	public static String format(double number) {
		return f.format(number);
	}

}
