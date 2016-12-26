package introduction;

import java.util.ArrayList;

import util.MyGenerator;

public class IntroductionMain {

	public static void main(String[] args) {
		// Creamos lista de 2000000 de números e inicializamos las clases para realizar las pruebas
		ArrayList<Integer> myNumbersList = MyGenerator.generateIntegerList(2000000);
		WithoutStreamIntroduction withoutStream = new WithoutStreamIntroduction();
		StreamIntroduction stream = new StreamIntroduction();
		
		// Pruebas
		withoutStream.testIteration(myNumbersList);
		stream.testInternalIteration(myNumbersList);
		stream.testInternalParallelIteration(myNumbersList);
		stream.testIntStream(myNumbersList);
		
		stream.testOptional();
	}

}
