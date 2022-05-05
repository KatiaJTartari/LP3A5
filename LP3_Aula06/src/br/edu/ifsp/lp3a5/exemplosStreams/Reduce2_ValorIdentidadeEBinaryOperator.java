package br.edu.ifsp.lp3a5.exemplosStreams;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class Reduce2_ValorIdentidadeEBinaryOperator {
	public static void main(String args[]) {
		exemploReduce2();
	}

	private static void exemploReduce2() {
		// Exemplos com valor de identidade e BinaryOperator
		final String resultadoConcatenacao2 = Stream.of("Ana", "Beatriz", "Clara", "Diana", "Eliane", "").reduce("",
				(v1, v2) -> v1.concat(v2));
		System.out.println("Resultado Concatenação 2: " + resultadoConcatenacao2 + "\n");

		try {
			final Optional<String> resultadoConcatenacao3 = Arrays.stream(new String[] {})
					.reduce((v1, v2) -> v1.concat(v2));
			System.out.println("Resultado Concatenação 3: " + resultadoConcatenacao3.get());
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println();
		final String resultadoConcatenacao4 = Arrays.stream(new String[] {}).reduce("", (v1, v2) -> v1.concat(v2));
		System.out.println("Resultado Concatenação 4: RESULTADO COM IDENTIDADE =[" + resultadoConcatenacao4 + "]");

	}
}
