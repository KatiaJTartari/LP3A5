package br.edu.ifsp.lp3a5.exemplosInterfacesFuncionais;

import java.util.HashMap;
import java.util.function.BiConsumer;

public class ExemploBiConsumer {

	public static void main(String[] args) {
		exemploBiConsumer();
	}

	/**
	 * BiConsumer, interface funcional que contém um método accept com dois valores
	 * de etrada e nenhum de saída. ou seja, recebe dois valores, realiza uma
	 * operação com eles, mas não retorna nada. O BiConsumer pode ser testado mais
	 * facilmente com um Map
	 */
	private static void exemploBiConsumer() {

		final HashMap<String, String> nomeSobrenome = new HashMap<>();
		nomeSobrenome.put("Diego", "Chaves");
		nomeSobrenome.put("João", "Ninguém");

		final BiConsumer<String, String> merge = (nome, sobrenome) -> {
			System.out.print("\n" + nome + " " + sobrenome);
		};

		// forEach do Map aceita um BiConsumer que vai receber a chave e o valor como
		// parâmetros
		nomeSobrenome.forEach(merge);

		System.out.println("\n\nExemplo com andThen");
		// Exemplo
		nomeSobrenome.forEach(merge.andThen((a, b) -> System.out.print(" - " + (a + " " + b).length())));
	}

}
