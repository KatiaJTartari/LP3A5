package br.edu.ifsp.aula2;

public class HelloWorldRunnable1 implements Runnable {

	@Override

	public void run() {
		System.out.println("Aqui quem fala � a " + Thread.currentThread().getName());
	}

	public static void main(String[] args) {

		System.out.println("Estamos na: " + Thread.currentThread().getName());

		Runnable runnable = new HelloWorldRunnable1();

		runnable.run();
	}

}
