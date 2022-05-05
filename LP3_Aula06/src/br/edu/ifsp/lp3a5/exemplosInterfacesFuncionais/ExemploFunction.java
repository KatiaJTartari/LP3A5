package br.edu.ifsp.lp3a5.exemplosInterfacesFuncionais;

import java.util.Arrays;
import java.util.List;

public class ExemploFunction {

	public static void main(String[] args) {
		exemploFunction();
	}

	/**
	 * Function � uma interface funcional que cont�m um m�todo apply que recebe um
	 * valor, aplica a fun��o e devolve um resultado
	 */
	private static void exemploFunction() {
		final List<String> frutas = Arrays.asList("ameixa", "jaca", "abacate", "caqui", "banana", "abacaxi");

		frutas.stream().map((fruta) -> fruta + "s").forEach(System.out::println);

		// BiFunction � uma function com dois valores de entrada
		// UnaryOperator � uma uma function que obrigatoriamente recebe e devolve um
		// valor do mesmo tipo
	}

}
