package br.edu.ifsp.lp3a5.exemplosStreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CriandoStreams {

	public static void main(String args[]) {
		streams();
	}

	private static void streams() {

		// A interface collection possui o método stream e parallelStream
		final List<String> lista = Arrays.asList("amor", "bola", "casa", "dado");

		System.out.println("Criando stream a partir de uma lista");
		// Criação de stream a partir de uma lista
		lista.stream().forEach(System.out::println);

		System.out.println("\nExemplo com parallelStream");
		/*
		 * O parallelStream é para programação paralela, situações em que não é
		 * necessário que o fluxo de processamento seja linear
		 */
		lista.parallelStream().forEach(System.out::println);

		// Também é possível criar streams a partir de arrays
		String[] nomes = new String[] { "Ana", "Beatriz", "Clara", "Diana", "Eliane" };
		System.out.println("\nStream a partir de array usando a classe java.util.Arrays");
		Arrays.stream(nomes).forEach(System.out::println);

		//É possível criar um Stream também com a própria classe Stream usando o método of
		 
		System.out.println("\nAo usar o método Stream.of podem ser passados Object");
		Stream.of("casa", 1, "teste").forEach(System.out::println);

		// Para números é possível gerar um intervalo
		System.out.println("\nCriando um stream com o método IntStream.range");
		IntStream.range(10, 20).forEach(System.out::println);
		// caso deseje incluir o último número pode usar o rangeClosed

		// Outra forma de criar um stream é o método iterate.
		// Inicia-se com uma semente e uma função que define como ela será transformada
		System.out.println("\nCriando um stream com o método Stream.iterate");
		Stream.iterate(true, valor -> !valor).limit(5).forEach(System.out::println);

	}
}