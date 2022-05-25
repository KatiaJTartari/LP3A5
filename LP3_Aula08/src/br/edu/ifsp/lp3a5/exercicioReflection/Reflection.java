package br.edu.ifsp.lp3a5.exercicioReflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
//Ou 
//import java.lang.reflect.*;

public class Reflection {

	public Reflection() {
	}

	public void listaNomeDosMetodos() {
		try {
			Class cl = Class.forName("br.edu.ifsp.lp3a5.exercicioReflection.Pessoa");
			Method[] metodos = cl.getDeclaredMethods();

			for (int i = 0; i < metodos.length; i++) {
				System.out.println(metodos[i].toString());
			}

		} catch (Throwable e) {
			System.err.print(e);
		}
	}

	public void atributos() {
		try {
			Class cl = Class.forName("br.edu.ifsp.lp3a5.exercicioReflection.Pessoa");
			Method metodos[] = cl.getDeclaredMethods();
			for (int i = 0; i < metodos.length; i++) {
				Method m = metodos[i];
				System.out.println("Nome do método: " + m.getName());
				System.out.println("Parâmetros:");

				for (int j = 0; j < m.getParameterTypes().length; j++) {
					System.out.println("        " + j + ": " + m.getParameterTypes()[j]);
				}

				System.out.println("Tipo de retorno: " + m.getReturnType());
			}

		} catch (Throwable e) {
			System.err.print(e);
		}
	}

	public void invocaMetodos() {
		Pessoa pessoa = new Pessoa("Jaqueline Tartari", 29, "111.222.333-44", "55.666.777-8");
		try {
			Class cl = Class.forName("br.edu.ifsp.lp3a5.exercicioReflection.Pessoa");
			Field[] fi = cl.getDeclaredFields();
			Method[] met = cl.getDeclaredMethods();
			for (int i = 0; i < met.length; i++) {
				System.out.println(fi[i].getName() + ": " + met[i].invoke(pessoa));
			}

		} catch (Throwable e) {
			System.err.print(e);
		}
	}

}