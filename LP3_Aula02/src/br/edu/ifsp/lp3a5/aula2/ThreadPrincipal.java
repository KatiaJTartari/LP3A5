package br.edu.ifsp.lp3a5.aula2;

public class ThreadPrincipal {

	public static void main(String[] args) {

		Thread principal = Thread.currentThread();
		System.out.println("Nome da thread: " + principal.getName());
		System.out.println("Thread.toString(): " + principal);
	}

}
