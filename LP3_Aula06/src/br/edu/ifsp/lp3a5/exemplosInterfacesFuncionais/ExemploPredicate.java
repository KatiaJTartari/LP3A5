package br.edu.ifsp.lp3a5.exemplosInterfacesFuncionais;

import java.util.Arrays;
import java.util.List;

public class ExemploPredicate {
	public static void main(String args[]) {
		exemploPredicate();
	}

	/**
	 * Predicate é uma interface funcional que possui um método test que recebe um
	 * valor e retorna um boolean
	 * 
	 * Pode ser visto em ação na função filter de uma List
	 */
	private static void exemploPredicate() {
		final List<String> frutas = Arrays.asList("ameixa", "jaca", "abacate", "caqui", "banana", "abacaxi");

		frutas.stream().filter((fruta) -> fruta.startsWith("a")).forEach(System.out::println);

	}
}
