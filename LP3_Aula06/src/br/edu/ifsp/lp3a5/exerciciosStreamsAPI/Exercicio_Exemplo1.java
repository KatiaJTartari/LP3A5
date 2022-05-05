package br.edu.ifsp.lp3a5.exerciciosStreamsAPI;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Exercicio_Exemplo1 {

	public static void main(String[] args) {

		final List<String> lista = Arrays.asList("Espanha", "Venezuela", "Fran�a", "Brasil", "It�lia", "Fran�a",
				"Canad�", "M�xico", "Inglaterra", "Brasil", "Portugal", "Alemanha", "It�lia");

		System.out.println("\tM�todos .distinct() .sorted() .sorted(Comparator)\n");

		/*
		 * Dado uma lista de strings remove todo os itens duplicados utilizando distinct
		 * depois ordena com o m�todo sorted e sorted(Comparator) por fim imprime o
		 * resultado na tela.
		 */

		lista.stream().distinct().sorted().forEach(System.out::println);
		System.out.println();
		lista.stream().distinct().sorted(Comparator.reverseOrder()).forEach(System.out::println);
	}
}
