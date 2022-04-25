package br.edu.ifsp.lp3a5.completableFuture;

import java.util.concurrent.CompletableFuture;

public class Exemplo2 { // Threads e complete

	public static void main(String... args) throws InterruptedException {
		final CompletableFuture<String> c1 = new CompletableFuture<>();
		new Thread(() -> c1.complete("Hello World!")).start();
		c1.thenAccept(str -> System.out.println(str));
		Thread.sleep(1000);
	}
}
