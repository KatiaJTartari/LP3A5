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

		// A interface collection possui o m�todo stream e parallelStream
		final List<String> lista = Arrays.asList("amor", "bola", "casa", "dado");

		System.out.println("Criando stream a partir de uma lista");
		// Cria��o de stream a partir de uma lista
		lista.stream().forEach(System.out::println);

		System.out.println("\nExemplo com parallelStream");
		/*
		 * O parallelStream � para programa��o paralela, situa��es em que n�o �
		 * necess�rio que o fluxo de processamento seja linear
		 */
		lista.parallelStream().forEach(System.out::println);

		// Tamb�m � poss�vel criar streams a partir de arrays
		String[] nomes = new String[] { "Ana", "Beatriz", "Clara", "Diana", "Eliane" };
		System.out.println("\nStream a partir de array usando a classe java.util.Arrays");
		Arrays.stream(nomes).forEach(System.out::println);

		//� poss�vel criar um Stream tamb�m com a pr�pria classe Stream usando o m�todo of
		 
		System.out.println("\nAo usar o m�todo Stream.of podem ser passados Object");
		Stream.of("casa", 1, "teste").forEach(System.out::println);

		// Para n�meros � poss�vel gerar um intervalo
		System.out.println("\nCriando um stream com o m�todo IntStream.range");
		IntStream.range(10, 20).forEach(System.out::println);
		// caso deseje incluir o �ltimo n�mero pode usar o rangeClosed

		// Outra forma de criar um stream � o m�todo iterate.
		// Inicia-se com uma semente e uma fun��o que define como ela ser� transformada
		System.out.println("\nCriando um stream com o m�todo Stream.iterate");
		Stream.iterate(true, valor -> !valor).limit(5).forEach(System.out::println);

	}
}