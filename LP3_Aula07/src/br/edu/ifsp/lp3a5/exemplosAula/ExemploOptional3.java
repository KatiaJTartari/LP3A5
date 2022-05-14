package br.edu.ifsp.lp3a5.exemplosAula;

import java.util.Optional;

public class ExemploOptional3 {

	static Optional<String> optString;

	public static void main(String[] args) {

		String s = "bola";
		optString = Optional.ofNullable(s);
		// Nunca usar Runtime nesse caso é apenas um exemplo
		System.out.println(optString.orElseThrow(() -> new RuntimeException("")));

	}

}
