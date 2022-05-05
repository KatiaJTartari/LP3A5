package br.edu.ifsp.lp3a5.exerciciosStreamsAPI;

import java.util.Arrays;
import java.util.List;

public class Exercicio_Exemplo2 {

	public static void main(String[] args) {

		List<String> nomes = Arrays.asList("Amanda", "Samuel", "Carlos", "Ana", "Bianca", "João", "Ester", "Pedro",
				"Sara");

		System.out.println("\tMétodos .anyMatch() .allMatch() .noneMatch()\n");

		/*
		 * anyMatch: retorna true se qualquer um dos elementos do fluxo corresponde ao
		 * predicado fornecido. predicado fornecido.
		 */
		boolean resultado = nomes.stream().anyMatch((n) -> n.startsWith("A"));
		System.out.println(resultado + "\n");

		/*
		 * allMatch: retorna true se todos os elementos do fluxo correspondem ao
		 * predicado fornecido.
		 */
		resultado = nomes.stream().allMatch((n) -> n.startsWith("A"));
		System.out.println(resultado + "\n");

		/*
		 * noneMatch: retorna true se nenhum dos elementos do fluxo corresponde ao
		 * predicado fornecido.
		 */
		resultado = nomes.stream().noneMatch((n) -> n.startsWith("A"));
		System.out.println(resultado);

	}

}
