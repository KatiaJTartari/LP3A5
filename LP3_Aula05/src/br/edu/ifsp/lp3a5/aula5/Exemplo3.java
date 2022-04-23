package br.edu.ifsp.lp3a5.aula5;

import java.util.Optional;

public class Exemplo3 {

	public static Optional<Double> multiplicarPorDez(Double n) {
		return Optional.of(n * 10);
	}

	public static Optional<Double> dividirPorCinco(Double n) {
		return Optional.of(n / 5);
	}

	public static Optional<Double> arredondar(Double n) {
		return Optional.of(Double.valueOf(Math.round(n)));
	}

	public static Optional<Double> aplicarOperacao(Double n1) {
		return multiplicarPorDez(n1).flatMap(n -> dividirPorCinco(n)).flatMap(n -> arredondar(n));
	}

	public static void main(String[] args) {
		final Double entrada = null;

		final Optional<Double> optEntrada = Optional.ofNullable(entrada);

		optEntrada.ifPresent(n -> aplicarOperacao(n).ifPresent(System.out::println));

		optEntrada.ifPresentOrElse(n -> aplicarOperacao(n).ifPresent(System.out::println),
				() -> System.out.println("Valor informado não pode ser nulo."));
	}

}
