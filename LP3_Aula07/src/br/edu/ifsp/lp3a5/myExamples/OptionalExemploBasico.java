package br.edu.ifsp.lp3a5.myExamples;

import java.util.Optional;

public class OptionalExemploBasico {

	static Optional<String> optString;

	public static void main(String[] args) {

		Optional<String> linguagem = Optional.of("JAVA");
		String respostaPreenchida = "Sim";
		String respostaNula = null;

		System.out.println("Optional N�o Vazio:" + linguagem);
		System.out.println("Optional N�o Vazio: Obtem o valor: " + linguagem.get());
		System.out.println("Optional Vazio: " + Optional.empty());

		System.out.println(
				"Chamada do m�todo ofNullable() em Optional N�o Vazio: " + Optional.ofNullable(respostaPreenchida));
		System.out.println("Chamada do m�todo ofNullable() em Optional Vazio: " + Optional.ofNullable(respostaNula));

		// Ocorre uma java.lang.NullPointerException na linha abaixo
		System.out.println("Chamada do m�todo of() Optional N�o Vazio: " + Optional.of(respostaNula));
	}
}

