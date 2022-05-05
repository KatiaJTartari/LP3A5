package br.edu.ifsp.lp3a5.exemplosStreams;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Reduce1_BinaryOperator {
	public static void main(String args[]) {
		exemploReduce1();
	}

	private static void exemploReduce1() {
		// EXEMPLOS COM BinaryOperator
		final OptionalInt resultadoSoma = IntStream.rangeClosed(1, 10).reduce((v1, v2) -> v1 + v2);
		System.out.println("Resultado Soma: " + resultadoSoma.getAsInt() + "\n");

		final Optional<String> resultadoConcatenacao1 = Stream.of("Ana", "Beatriz", "Clara", "Diana", "Eliane")
				.reduce((v1, v2) -> v1.concat(v2));
		System.out.println("Resultado Concatenação 1: " + resultadoConcatenacao1.get());
	}
}