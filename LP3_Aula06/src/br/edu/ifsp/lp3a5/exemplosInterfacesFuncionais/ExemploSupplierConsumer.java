package br.edu.ifsp.lp3a5.exemplosInterfacesFuncionais;

import java.util.Random;
import java.util.stream.Stream;

public class ExemploSupplierConsumer {

	public static void main(String[] args) {
		exemploSupplierConsumer();
	}

	/**
	 * Supplier: fornecedor - não recebe nada e retorna um valor Consumer :
	 * consumidor - recebe um valor e não retorna nada
	 */
	private static void exemploSupplierConsumer() {
		Stream.generate(() -> new Random().nextInt()) // A função generate recebe um supplier
				// Supplier: interface funcional que contém um método get sem argumentos
				// Ou seja, não recebe input, mas devolve um output
				.limit(10) // limita a 10 valores
				.forEach((e) -> System.out.println(e)); // a função forEach recebe um consumer
		// Consumer: interface funcional que contém um método accept com um parâmetro
		// de entrada e void na saída
		// Consumer: oposto do supplier, não retorna nada, mas recebe um valor com o
		// qual faz alguma ação.
	}
}
