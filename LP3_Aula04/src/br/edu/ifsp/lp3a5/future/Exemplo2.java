package br.edu.ifsp.lp3a5.future;

public class Exemplo2 { // C?digo sem Future
	
	public static String getData(final int index, final int time) throws InterruptedException {
		Thread.sleep(time);
		return "TESTE-" + index;
	}

	public static void main(String[] args) throws InterruptedException {
		long start = System.nanoTime();
		System.out.println(getData(0, 5000));
		long end = System.nanoTime();
		System.out.println("Tempo decorrido (segundos) = " + ((end - start) / 1.0E9));
	}
}
