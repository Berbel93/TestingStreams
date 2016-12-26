package interfaces;

public interface IntroInterface extends BasicInterface{
	default <T> void optionalPrint(T value) {
		System.out.println("Optional contiene el valor: " + value);
	}
	
	default void exceptionPrint() {
		System.out.println("Optional no contiene ningún valor");
	}
}
