package br.edu.ifsp.lp3a5.myExamples;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionDivisao {

	public static int calculaQuociente(int dividendo, int divisor) throws ArithmeticException {
		return dividendo / divisor;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		boolean continua = true;

		do {
			try {
				System.out.print("Dividendo: ");
				int dividendo = sc.nextInt();

				System.out.print("Divisor: ");
				int divisor = sc.nextInt();

				int resultado = calculaQuociente(dividendo, divisor);
				System.out.println("Resultado: " + resultado);

				continua = false;

			} catch (InputMismatchException erro1) {
				System.err.println("Não é permitido inserir letras, informe apenas números inteiros!");
				sc.nextLine(); // descarta a entrada errada do usuário
			} catch (ArithmeticException erro2) {
				System.err.println("O número do divisor deve ser diferente de 0!");
			} finally {
				System.out.println("Execução do Finally!");
			}
		} while (continua);

		sc.close();
	}
}

