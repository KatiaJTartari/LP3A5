package br.edu.ifsp.lp3a5.aula5;

public class Exemplo2 {

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
		return arredondar(dividirPorCinco(multiplicarPorDez(n1)));
	}

	public static void main(String[] args) {
		System.out.println("Saida = " + aplicarOperacao(20.5));
	}

}
