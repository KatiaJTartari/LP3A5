package br.edu.ifsp.lp3a5.exemplosAula;

import java.util.Optional;

public class ExemploOptional2 {

	static Optional<String> optString;

	public static void main(String[] args) {

		String s = null;
		optString = Optional.ofNullable(s);

		System.out.println(optString.orElseGet(() -> loadValor()));

	}

	public static String loadValor() {
		// Acesso ao banco

		return "Valor não encontrado no banco";
	}
}
