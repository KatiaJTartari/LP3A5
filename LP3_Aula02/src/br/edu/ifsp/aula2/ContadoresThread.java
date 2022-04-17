package br.edu.ifsp.aula2;

public class ContadoresThread {

	public static void main(String[] args) {

		Thread principal = Thread.currentThread();
		System.out.println("Nome da thread " + principal.getName());
		System.out.println("Thread.toString() " + principal);

		class Implementa extends Thread {

			public void run() {
				for (int x = 0; x < 500000; x++) {
					if (x == 1000) {
						System.out.println("Passou na thread " + Thread.currentThread());
					}
				}
			}
		}

		Implementa t1 = new Implementa();

		t1.start();

	}
}
