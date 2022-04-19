package br.edu.ifsp.lp3a5.aula2;

public class Interna {

	public static void main(String[] args) {

		class HelloParalelo implements Runnable {

			public void run() {

				System.out.println("Hello World Paralelo!");
			}
		}

		Thread t1 = new Thread(new HelloParalelo());

		t1.start();

		System.out.println("Thread principal: " + Thread.currentThread().getName());
	}
}
