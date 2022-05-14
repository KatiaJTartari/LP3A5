package br.edu.ifsp.lp3a5.exemplosAula;

import java.util.Optional;

public class ExemploOptional1 {

	static Optional<String> optString;

	public static void main(String[] args) {

		String s = null;
		optString = Optional.ofNullable(s);

		System.out.println(optString.orElseGet(() -> "<Valor Ausente>"));

	}

}
