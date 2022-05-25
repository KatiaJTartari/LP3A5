package br.edu.ifsp.lp3a5.exercicioReflection;

public class Main {

	public static void main(String[] args) {
		Reflection re = new Reflection();

		System.out.println("\n--- Lista todos os Métodos da Classe pesquisada ---\n");
		re.listaNomeDosMetodos();
		System.out.println("\n--- Lista Atributos da Classe ---\n");
		re.atributos();
		System.out.println("\n--- Invoca Métodos da Classe Pessoa ---\n");
		re.invocaMetodos();
	}

}
