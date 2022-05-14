package br.edu.ifsp.lp3a5.exemplosAula;

import java.util.Optional;

public class ExemploOptional5 {

	static Optional<String> optString;

	public static void main(String[] args) {

		String s = "abcdefg";
		optString = Optional.ofNullable(s);

		optString.filter(r -> s.contains("g")).ifPresent(System.out::println);

	}

}
