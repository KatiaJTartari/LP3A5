package br.edu.ifsp.lp3a5.exemplosStreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Map;

public class Collect {

	public static void main(String[] args) {
		exemploCollect();
	}

	private static void exemploCollect() {

		Map<Integer, List<String>> mapColetado = Stream.of("Ana", "Beatriz", "Clara", "Diana", "Eliane")
				.collect(Collectors.groupingBy(nome -> nome.length()));

		System.out.println(mapColetado);
		
		System.out.println();

		// A chave do map eh do tipo que é retornado no lambda do groupingBy
		Map<Boolean, List<String>> mapColetado2 = Stream.of("Ana", "Beatriz", "Clara", "Diana", "Eliane")
				.collect(Collectors.groupingBy(nome -> nome.length() > 5));

		System.out.println(mapColetado2);

	}
}
