package br.edu.ifsp.aula2;

public class HelloWorldRunnable implements Runnable {

	@Override

	public void run() {
		System.out.println("Aqui quem fala é a " + Thread.currentThread().getName());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Estamos na " + Thread.currentThread().getName());

		Runnable runnable = new HelloWorldRunnable();

		runnable.run();
	}

}
