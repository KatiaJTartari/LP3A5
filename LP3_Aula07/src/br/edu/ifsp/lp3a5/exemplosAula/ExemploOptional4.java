package br.edu.ifsp.lp3a5.exemplosAula;

import java.util.Optional;

public class ExemploOptional4 {

	static Optional<String> optString;

	public static void main(String[] args) {

		String s = null;
		optString = Optional.ofNullable(s);

		// Este também nunca usar é apenas um exemplo
		if (optString.isPresent()) {
			System.out.println(optString.get());
		}

	}

}
