package br.edu.ifsp.lp3a5.exemplosStreams;

import java.util.stream.IntStream;

public class Map {
	public static void main(String args[]) {
		exemploMap();
	}

	private static void exemploMap() {
		// Mapeia os números inteiros nos pares
		IntStream.rangeClosed(1, 10).map(n -> n * 2).peek(null).forEach(System.out::println);
	}

}
