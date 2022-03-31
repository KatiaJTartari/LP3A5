package br.edu.ifsp.aula2;

public class ThreadPrincipal {

	public static void main(String[] args) {

		Thread principal = Thread.currentThread();
		System.out.println("Nome da thread " + principal.getName());
		System.out.println("Thread.toString() " + principal);
	}

}
