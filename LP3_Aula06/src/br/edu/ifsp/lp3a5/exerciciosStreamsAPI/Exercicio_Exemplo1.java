package br.edu.ifsp.lp3a5.exerciciosStreamsAPI;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Exercicio_Exemplo1 {

	public static void main(String[] args) {

		final List<String> lista = Arrays.asList("Espanha", "Venezuela", "França", "Brasil", "Itália", "França",
				"Canadá", "México", "Inglaterra", "Brasil", "Portugal", "Alemanha", "Itália");

		System.out.println("\tMétodos .distinct() .sorted() .sorted(Comparator)\n");

		/*
		 * Dado uma lista de strings remove todo os itens duplicados utilizando distinct
		 * depois ordena com o método sorted e sorted(Comparator) por fim imprime o
		 * resultado na tela.
		 */

		lista.stream().distinct().sorted().forEach(System.out::println);
		System.out.println();
		lista.stream().distinct().sorted(Comparator.reverseOrder()).forEach(System.out::println);
	}
}
