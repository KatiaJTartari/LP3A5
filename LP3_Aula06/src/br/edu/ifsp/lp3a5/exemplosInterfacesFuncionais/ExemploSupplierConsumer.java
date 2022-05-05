package br.edu.ifsp.lp3a5.exemplosInterfacesFuncionais;

import java.util.Random;
import java.util.stream.Stream;

public class ExemploSupplierConsumer {

	public static void main(String[] args) {
		exemploSupplierConsumer();
	}

	/**
	 * Supplier: fornecedor - n�o recebe nada e retorna um valor Consumer :
	 * consumidor - recebe um valor e n�o retorna nada
	 */
	private static void exemploSupplierConsumer() {
		Stream.generate(() -> new Random().nextInt()) // A fun��o generate recebe um supplier
				// Supplier: interface funcional que cont�m um m�todo get sem argumentos
				// Ou seja, n�o recebe input, mas devolve um output
				.limit(10) // limita a 10 valores
				.forEach((e) -> System.out.println(e)); // a fun��o forEach recebe um consumer
		// Consumer: interface funcional que cont�m um m�todo accept com um par�metro
		// de entrada e void na sa�da
		// Consumer: oposto do supplier, n�o retorna nada, mas recebe um valor com o
		// qual faz alguma a��o.
	}
}
