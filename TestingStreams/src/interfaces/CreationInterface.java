package interfaces;

public interface CreationInterface extends BasicInterface{
	/**
	 * @param number: número a comprobar si es primo
	 * 
	 * @return true si el número es primo, false de lo contrario
	 */
	default boolean isPrimeNumber(int number) {
		if(number == 1 || (number % 2 == 0 && number != 2)) 
			return false;
		
		for(int i=3; i<=number/3; i+=2)
			if(number % i == 0)
				return false;
		
		return true;
	}

}
