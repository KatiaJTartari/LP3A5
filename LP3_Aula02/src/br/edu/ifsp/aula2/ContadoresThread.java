package br.edu.ifsp.aula2;

public class ContadoresThread {

	public static void main(String[] args) {

		Thread principal = Thread.currentThread();
		System.out.println("Nome da thread " + principal.getName());
		System.out.println("Thread.toString() " + principal);

		// final Counter counter = new Counter();
		class Implementa extends Thread {

			public void run() {
				for (int x = 0; x < 500000; x++) {
					if (x == 1000) {
						System.out.println("Passou na thread " + Thread.currentThread());
					}
					// counter.increment();
				}
			}
		}
		
		Implementa t1 = new Implementa();
		// Implementa t2 = new Implementa();
		t1.start();
		// t2.start();
		// t1.join();
		// t2.join();
		// System.out.println("counter.get());
	}
}
