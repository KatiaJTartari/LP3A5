package br.edu.ifsp.lp3a5.exemplosAula;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Scanner;

/**
 * Alguns exemplos de como tratar o erro de divis�o por zero no Java seguindo
 * diferentes propostas
 * 
 * @author diego
 *
 */
public class ExemploDivisaoPorZero {

	public static void main(String args[]) {

		try (final Scanner scanner = new Scanner(System.in)) {

			while (desejaContinuar(scanner)) {

				int numerador = 0;
				int denominador = 0;
				int exemplo = 0;
				boolean continueLoop = true;
				do { // baseado no exemplo 11.3 do Deitel & Deitel 10� ed.
					try {
						System.out.print("Por favor, digite um numerador inteiro : ");
						numerador = scanner.nextInt();
						System.out.print("Por favor, digite um denominador inteiro : ");
						denominador = scanner.nextInt();

						System.out.print("Por favor, escolha um c�digo de exemplo entre 0 e 11 : ");
						exemplo = scanner.nextInt();
						continueLoop = false; // entrada bem-sucedida; fim do loop
					} catch (InputMismatchException e) {
						/*
						 * Esse � um exemplo de algo que at� um tempo atr�s era muito estimulado em
						 * Java, o uso de Exception para tratar algo n�o t�o excepcional, uma entrada
						 * errada do usu�rio.
						 * 
						 * Em outras linguagens, onde n�o h� um mecanismo de exce��es t�o "musculoso"
						 * quanto em Java, h� um desencorajamento para este tipo de uso de Exception,
						 * pois as Exceptions s�o muito mais custosas e s�o guardadas para situa��es nas
						 * quais seja necess�rio rastrear a pilha de execu��o ou obter mais informa��es
						 * de contexto onde o erro ocorreu.
						 * 
						 * Mesmo em Java, atualmente h� uma crescente cr�tica a utiliza��o das
						 * Exceptions para lidar com fluxos alternativos mais corriqueiros.
						 */
						System.err.printf("%nException: %s%n", e);
						scanner.nextLine(); // descarta entrada para o usu�rio tentar de novo
						System.out.printf("Voc� precisa digitar inteiros. Por favor, tente outra vez. %n%n");
					}

				} while (continueLoop);

				switch (exemplo) {
				case 0:
					exemplo0(numerador, denominador);
					break;
				case 1:
					exemplo1(numerador, denominador);
					break;
				case 2:
					exemplo2(numerador, denominador);
					break;
				case 3:
					exemplo3(numerador, denominador);
					break;
				case 4:
					exemplo4(numerador, denominador);
					break;
				case 5:
					exemplo5(numerador, denominador);
					break;
				case 6:
					exemplo6(numerador, denominador);
					break;
				case 7:
					exemplo7(numerador, denominador);
					break;
				case 8:
					exemplo8(numerador, denominador);
					break;
				case 9:
					exemplo9(numerador, denominador);
					break;
				case 10:
					exemplo10(numerador, denominador);
					break;
				case 11:
					exemplo11(numerador, denominador);
					break;
				default:
					System.out.println("Exemplo " + exemplo + " n�o existe. Digite um valor entre 0 e 11");
				}

			}
		} finally {
			System.out.println("Programa finalizado.");
		}
	}

	private static boolean desejaContinuar(Scanner scanner) {
		imprimeLinha();
		System.out.println("Deseja fazer uma divis�o [S | N]?");
		return scanner.next().toUpperCase().equals("S");
	}

	private static void imprimeLinha() {
		System.out.println("\n----------------------------------------");
	}

	private static void exemplo0(int numerador, int denominador) {

		imprimeLinha();
		System.out.println("Exemplo 0");
		imprimeLinha();
		System.out.println("Nesse exemplo o denominador � tratado com um if 0 antes da chamada � fun��o.");
		System.out.println("O erro � tratado e n�o h� risco de um fim anormal.");
		System.out.println("Embora seja uma solu��o muito utilizada, seu uso � mais indicado em m�todos private.");
		System.out.println("Em m�todo public pode ser algo problem�tico.");
		System.out.println(
				"Primeiramente, por quebrar o encapsulamento, jogando o tratamento de uma regra de neg�cio para um objeto externo.");
		System.out.println(
				"Al�m disso, tal tratamento precisar� ser replicado em todas as chamadas ao m�todo, algo que vai contra o DRY (d'ont repeat yourself).");
		imprimeLinha();

		if (denominador == 0) {
			System.out.println("ERRO : Denominador n�o pode ser zero.");
			return;
		}

		final double resultado = divisaoSemTratamento(numerador, denominador);
		System.out.printf("\nAo dividir %d por %d o resultado da divis�o foi %.2f", numerador, denominador, resultado);
	}

	private static void exemplo1(int numerador, int denominador) {
		imprimeLinha();
		System.out.println("Exemplo 1");
		imprimeLinha();
		System.out.println("Nesse exemplo n�o h� qualquer tratamento ao denominador 0.");
		System.out.println(
				"Com isso a divis�o ser� efetuada e poder� gerar uma exce��o que caso n�o seja tratada pode finalizar a execu��o do programa.");
		imprimeLinha();

		final double resultado = divisaoSemTratamento(numerador, denominador);
		System.out.printf("\nAo dividir %d por %d o resultado da divis�o foi %.2f", numerador, denominador, resultado);
	}

	private static void exemplo2(int numerador, int denominador) {
		imprimeLinha();
		System.out.println("Exemplo 2");
		imprimeLinha();
		System.out.println(
				"Nesse exemplo o m�todo n�o trata o erro, sendo gerada uma ArithmeticException que � capturada e tratada pelo m�todo que fez a chamada.");
		System.out.println(
				"Tal qual o Exemplo 0, n�o � t�o problem�tico em m�todos private, por�m em m�todos public quebra o encapsulamento e gera c�digo redundante.");
		System.out.println("No entanto, mesmo em m�todos private esse � um tipo de exce��o question�vel.");
		System.out.println(
				"A n�o divis�o por 0 � uma regra bem conhecida da divis�o de n�meros inteiros, logo, deixar que a exce��o ocorra � um erro de programa��o.");
		System.out
				.println("Nesse caso o melhor � corrigir o m�todo do que contornar o erro com tratamento de exce��es.");
		imprimeLinha();

		try {
			final double resultado = divisaoSemTratamento(numerador, denominador);
			System.out.printf("\nAo dividir %d por %d o resultado da divis�o foi %.2f", numerador, denominador,
					resultado);
		} catch (ArithmeticException e) {
			System.out.println("A divis�o falhou, pois o denominador precisa ser um n�mero positivo.");
		}

	}

	private static void exemplo3(int numerador, int denominador) {
		imprimeLinha();
		System.out.println("Exemplo 3");
		imprimeLinha();
		System.out.println(
				"Esse exemplo difere dos anteriores pois utiliza um m�todo que trata a entrada do usu�rio, devolvendo null caso o denominador seja 0.");
		System.out.println("O null � tratado e � exibido um aviso de denominador 0.");
		System.out.println("Retornar null na aus�ncia de um estado v�lido foi muito utilizado at� o Java 7.");
		System.out.println(
				"null, nesses casos, funciona como uma esp�cie de c�digo de erro. Seu uso e significado deve ser indicado na documenta��o dos m�todos public.");
		imprimeLinha();

		final Double resultado = divisaoUsandoNullComoIndicadorDeErro(numerador, denominador);
		if (resultado != null) {
			System.out.printf("\nAo dividir %d por %d o resultado da divis�o foi %.2f", numerador, denominador,
					resultado);
		} else {
			System.out.println("ERRO : Denominador n�o pode ser 0. Digite um n�mero v�lido.\n");
		}

	}

	private static void exemplo4(int numerador, int denominador) {
		imprimeLinha();
		System.out.println("Exemplo 4");
		imprimeLinha();
		System.out.println("Usa o m�todo com retorno null, por�m, n�o trata o null.");
		System.out.println("Esse � o grande problema de retornar null ou c�digos de erros.");
		System.out.println("Mesmo bem documentado, isso n�o implica que quem v� invocar o m�todo fa�a o tratamento.");
		System.out.println("Como pode ser visto nesse exemplo o n�o tratamento do null pode gerar um grande problema.");
		System.out.println(
				"Quando o programa tenta usar o valor null � lan�ada uma exce��o de ponteiro nulo sem rela��o com o denominador zero.");
		System.out.println(
				"Assim, n�o h� clareza do porqu� da exce��o lan�ada, o que mascara o problema, al�m disso o programa pode terminar de forma inesperada.");
		imprimeLinha();

		final double resultado = divisaoUsandoNullComoIndicadorDeErro(numerador, denominador);
		System.out.printf("\nAo dividir %d por %d o resultado da divis�o foi %.2f", numerador, denominador, resultado);
	}

	private static void exemplo5(int numerador, int denominador) {
		imprimeLinha();
		System.out.println("Exemplo 5");
		imprimeLinha();
		System.out.println("Usa um m�todo que lan�a IllegalArgumentException quando recebe denominador 0");
		System.out.println(
				"IllegalArgumentException descende de RuntimeException, um tipo de exce��o que n�o precisa de verifica��o");
		System.out
				.println("Quem vai utilizar fica respons�vel por ler a documenta��o e tratar a exce��o adequadamente.");
		imprimeLinha();

		try {
			final double resultado = divisaoLancandoIllegalArgumentException(numerador, denominador);
			System.out.printf("\nAo dividir %d por %d o resultado da divis�o foi %.2f", numerador, denominador,
					resultado);
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
	}

	private static void exemplo6(int numerador, int denominador) {
		imprimeLinha();
		System.out.println("Exemplo 6");
		imprimeLinha();
		System.out.println("� usado o m�todo que lan�a IllegalArgumentException j� visto no exemplo 5.");
		System.out.println("Por�m, o usu�rio n�o trata a exce��o e ela causa o t�rmino do programa.");
		System.out.println(
				"Exce��es n�o verificadas n�o geram obriga��o de declara��o e o usu�rio as vezes esquece de tratar.");
		System.out.println(
				"Apesar de ser um um problema, o erro � mais f�cil de identificar do que o null pointer do exemplo 4.");
		imprimeLinha();

		final double resultado = divisaoLancandoIllegalArgumentException(numerador, denominador);
		System.out.printf("\nAo dividir %d por %d o resultado da divis�o foi %.2f", numerador, denominador, resultado);
	}

	private static void exemplo7(int numerador, int denominador) {
		imprimeLinha();
		System.out.println("Exemplo 7");
		imprimeLinha();
		System.out.println("Usa um m�todo que lan�a uma exce��o customizada quando recebe denominador 0");
		System.out.println("� uma exce��o que exige verifica��o (checked exception) e est� na assinatura do m�todo.");
		System.out.println("Isso obriga o programador a tratar a exce��o.");
		System.out.println(
				"Se a mensagem estiver bem expl�cita, n�o � necess�rio saber a regra do neg�cio, basta retornar a mensagem");
		System.out.println(
				"O �nico ponto discut�vel nessa estrat�gia � o alto custo de usar exception para tratar um fluxo alternativo para um argumento errado.");
		System.out.println(
				"Apesar do uso de exce��es ser uma cultura da plataforma Java, um uso generalizado pode levar a problemas de desempenho.");
		System.out.println("O custo precisa ser avaliado de acordo com o contexto.");
		System.out.println("Em uma opera��o ocasional como esta do exemplo n�o chega a ser um problema.");
		System.out.println(
				"Mas ao processar milh�es de registros e com a possibilidade do erro ser uma situa��o comum e n�o uma excepcionalidade a situa��o � outra.");
		System.out.println(
				"Nesse caso espec�fico tampouco a pilha de execu��o � uma informa��o relevante, apenas o aviso do denominador 0 parece ser suficiente.");
		imprimeLinha();

		try {
			final double resultado = divisaoLancandoCheckedException(numerador, denominador);
			System.out.printf("\nAo dividir %d por %d o resultado da divis�o foi %.2f", numerador, denominador,
					resultado);
		} catch (DivisaoPorZeroException e) {
			e.printStackTrace();
		}
	}

	private static void exemplo8(int numerador, int denominador) {

		imprimeLinha();
		System.out.println("Exemplo 8");
		imprimeLinha();
		System.out.println("Aqui � usada a exce��o verific�vel tamb�m usada no exemplo 7.");
		System.out.println("Por�m, apesar de abrir o bloco catch com o erro, o usu�rio n�o faz nenhum tratamento.");
		System.out.println(
				"Ou seja, um programador relapso pode engolir e silenciar a exce��o, dificultando descobrir onde o erro est� ocorrendo.");
		imprimeLinha();

		try {
			final double resultado = divisaoLancandoCheckedException(numerador, denominador);
			System.out.printf("\nAo dividir %d por %d o resultado da divis�o foi %.2f", numerador, denominador,
					resultado);
		} catch (DivisaoPorZeroException e) {
			// n�o faz nada.
			// Quem faz isso ganha um peda�o de carv�o do Papai Noel no Natal.
		}
	}

	private static void exemplo9(int numerador, int denominador) {
		imprimeLinha();
		System.out.println("Exemplo 9");
		imprimeLinha();
		System.out.println(
				"O m�todo utilizado trata a exce��o retornando um Optional empty quando o denominador � zero.");
		System.out.println(
				"A partir do Java 8 a linguagem incorporou elementos do paradigma funcional entre elas o Optional.");
		System.out.println(
				"Em algumas situa��es pode ser vantajoso, pois retornar um Option n�o � t�o custoso quanto gerar uma exce��o.");
		System.out.println(
				"Por�m, em milh�es de execu��es tamb�m pode impactar o desempenho, pois cria uma chamada extra para se acessar o valor.");
		System.out.println("A maior vantagem do empty � a redu��o do risco de um ponteiro de exce��o nula.");
		System.out.println("Por�m possui problemas similares ao c�digo de erro ou ao uso do null.");
		System.out.println("Na pr�tica funciona como um c�digo de erro em forma de m�nada.");
		System.out
				.println("O usu�rio precisar� saber o significado do empty caso seja necess�rio notificar o usu�rio.");
		System.out
				.println("Ou seja, a documenta��o do m�todo precisa ser bem feita, caso seja usado em m�todo public.");
		imprimeLinha();

		OptionalDouble resultado = divisaoRetornandoOptionalDouble(numerador, denominador);

		// No Java 9
		// resultado.ifPresentOrElse( r -> System.out.printf("\nO resultado da divis�o �
		// %.2f" , r ));

		// No Java 8
		if (resultado.isPresent()) {
			System.out.printf("\nAo dividir %d por %d o resultado da divis�o foi %.2f", numerador, denominador,
					resultado.getAsDouble());
		} else {
			System.out.println("Denominador n�o pode ser 0.");
		}

	}

	private static void exemplo10(int numerador, int denominador) {
		imprimeLinha();
		System.out.println("Exemplo 10");
		imprimeLinha();
		System.out.println("O optional tamb�m pode ser mal utilizado, resultado em erro parecido com o null pointer.");
		System.out.println(
				"O m�todo get do Optional vai tentar pegar o valor, mesmo que ele seja empty, por isso seu uso n�o � aconselhado.");
		imprimeLinha();

		OptionalDouble resultado = divisaoRetornandoOptionalDouble(numerador, denominador);
		System.out.printf("\nAo dividir %d por %d o resultado da divis�o foi %.2f", numerador, denominador,
				resultado.getAsDouble());
	}

	/**
	 * Esbo�o de solu��o para situa��es nas quais o uso da exception possa ser muito
	 * custoso, ou caso o programador tenha antipatia por exceptions.
	 * 
	 * No Java n�o h� a op��o de m�ltiplos retornos, mas pode-se criar uma classe de
	 * retorno que contenha tanto o valor quanto a mensagem de erro.
	 */
	private static void exemplo11(int numerador, int denominador) {
		imprimeLinha();
		System.out.println("Exemplo 11");
		imprimeLinha();
		System.out.println("Retorna um objeto com o valor e uma mensagem de erro caso o valor esteja vazio.");
		System.out.println("Outras linguagens oferecem a possibilidade de m�ltiplos retornos.");
		System.out.println(
				"Assim, pode ser retornado um valor e tamb�m uma mensagem explicativa para caso o valor esteja vazio.");
		System.out.println(
				"O Java n�o possui esse tipo de retorno, mas pode ser criado um objeto de retorno que encapsule o valor e a mensagem.");
		System.out.println(
				"Esse tipo de estrat�gia esbo�ada aqui melhora o encapsulamento e reduz a repeti��o de c�digo.");
		System.out.println(
				"Mas em situa��es de muita carga de dados pode ter o mesmo problema de efici�ncia do Optional apontado no exemplo 9.");
		imprimeLinha();

		RetornoDivisao retorno = divisaoRetornandoObjetoDeResultado(numerador, denominador);
		retorno.resultado.ifPresent(r -> System.out.printf("\nAo dividir %d por %d o resultado da divis�o foi %.2f",
				numerador, denominador, r));
		retorno.mensagem.ifPresent(m -> System.out.println(m));
	}

	/**
	 * O m�todo simplesmente divide um valor pelo outro.
	 * 
	 * Se o denominador for zero � lan�ada uma ArithmeticException.
	 * 
	 * @param numerador
	 * @param denominador
	 * @return
	 */
	private static double divisaoSemTratamento(int numerador, int denominador) {
		return numerador / denominador;
	}

	/**
	 * O m�todo verifica se o denominador � diferente de zero antes de prosseguir
	 * 
	 * @param numerador
	 * @param denominador
	 * @return
	 */
	private static Double divisaoUsandoNullComoIndicadorDeErro(int numerador, int denominador) {
		if (denominador == 0) {
			return null;
		}

		return (double) (numerador / denominador);
	}

	private static double divisaoLancandoIllegalArgumentException(int numerador, int denominador) {
		if (denominador == 0) {
			throw new IllegalArgumentException("Denominador n�o pode ser 0");
		}

		return (double) (numerador / denominador);
	}

	private static double divisaoLancandoCheckedException(int numerador, int denominador)
			throws DivisaoPorZeroException {
		if (denominador == 0) {
			throw new DivisaoPorZeroException("Denominador n�o pode ser 0");
		}

		return (double) (numerador / denominador);
	}

	private static OptionalDouble divisaoRetornandoOptionalDouble(int numerador, int denominador) {
		if (denominador == 0) {
			return OptionalDouble.empty();
		} else {
			return OptionalDouble.of(numerador / denominador);
		}
	}

	private static RetornoDivisao divisaoRetornandoObjetoDeResultado(int numerador, int denominador) {
		if (denominador == 0) {
			return new RetornoDivisao("Denominador n�o pode ser 0.");
		} else {
			return new RetornoDivisao(numerador / denominador);
		}
	}

}

class DivisaoPorZeroException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3254144233731847721L;

	public DivisaoPorZeroException(String msg) {
		super(msg);
	}
}

class RetornoDivisao {
	OptionalDouble resultado;
	Optional<String> mensagem;

	public RetornoDivisao(double resultado) {
		this.resultado = OptionalDouble.of(resultado);
		this.mensagem = Optional.empty();
	}

	public RetornoDivisao(String mensagem) {
		this.resultado = OptionalDouble.empty();
		this.mensagem = Optional.of(mensagem);
	}
}
