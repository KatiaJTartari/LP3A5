package br.edu.ifsp.lp3a5.exerciciosStreamsAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercicio_Exemplo3 {

	public static void main(String[] args) {

		/*
		 * Fun��o Stream.flatMap() obt�m um �nico List contendo todos os elementos de
		 * uma lista de listas.
		 */
		List<Integer> lista1 = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> lista2 = Arrays.asList(6, 7, 8, 9, 10);
		List<Integer> lista3 = Arrays.asList(11, 12, 13, 14, 15);

		// Converte List<List<Integer>> para List<Integer>
		List<List<Integer>> listaDeListas = Arrays.asList(lista1, lista2, lista3);

		List<Integer> unicoListNumeros = listaDeListas.stream().flatMap(x -> x.stream()).collect(Collectors.toList());

		System.out.println("\tM�todo Stream.flatMap()\n\nMescla listas em uma �nica lista:\n" + unicoListNumeros);

		/*
		 * Fun��o Stream.flatMap() obt�m um �nico List contendo todos os elementos de um
		 * array de arrays.
		 */
		String[][] arrayDeArrays = new String[][] { { "a", "b", "c", "d" }, { "e", "f", "g", "h" },
				{ "i", "j", "k", "l" }, { "m", "n", "o", "p" } };

		List<String> unicoListChars = Arrays.stream(arrayDeArrays).flatMap(x -> Arrays.stream(x))
				.collect(Collectors.toList());

		System.out.println("\nMescla arrays em uma �nica lista:\n" + unicoListChars);

	}

}
