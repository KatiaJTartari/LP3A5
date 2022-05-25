package br.edu.ifsp.lp3a5.exemplos;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		for (int i = 0; i < 100; i++) {
			System.out.println("\tSystem.out.println(\"eu vou ser um bom aluno\");");
		}
	}

	@Override
	// @Deprecated
	public String toString() {
		System.out.println();
		return "Minha Classe";
	}

	@SuppressWarnings("rawtypes")
	public List list = new ArrayList();

}
