package br.edu.ifsp.lp3a5.exemplosInterfacesFuncionais;

import java.util.Arrays;
import java.util.List;

public class ExemploFunction {

	public static void main(String[] args) {
		exemploFunction();
	}

	/**
	 * Function é uma interface funcional que contém um método apply que recebe um
	 * valor, aplica a função e devolve um resultado
	 */
	private static void exemploFunction() {
		final List<String> frutas = Arrays.asList("ameixa", "jaca", "abacate", "caqui", "banana", "abacaxi");

		frutas.stream().map((fruta) -> fruta + "s").forEach(System.out::println);

		// BiFunction é uma function com dois valores de entrada
		// UnaryOperator é uma uma function que obrigatoriamente recebe e devolve um
		// valor do mesmo tipo
	}

}
