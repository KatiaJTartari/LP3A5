package br.edu.ifsp.lp3a5.aula5;

public class Exemplo1 {

	public static double multiplicarPorDez(double n) {
		return n * 10;
	}

	public static double dividirPorCinco(double n) {
		return n / 5;
	}

	public static double arredondar(double n) {
		return Math.round(n);
	}

	public static double aplicarOperacao(double n1) {
		final double n2 = multiplicarPorDez(n1);
		final double n3 = dividirPorCinco(n2);
		final double n4 = arredondar(n3);
		return n4;
	}

	public static void main(String[] args) {
		System.out.println("Saida = " + aplicarOperacao(12));
	}

}
