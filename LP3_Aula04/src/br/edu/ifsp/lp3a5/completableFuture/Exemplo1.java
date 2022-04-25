package br.edu.ifsp.lp3a5.completableFuture;

import java.util.concurrent.CompletableFuture;

public class Exemplo1 { // Criando um simples CompletableFuture usando o método complete

	public static void main(String... args) throws InterruptedException {
		CompletableFuture<String> c1 = new CompletableFuture<>();
		c1.complete("Hello World!");
		c1.thenAccept(str -> System.out.println(str));
		Thread.sleep(1000);
	}
}
