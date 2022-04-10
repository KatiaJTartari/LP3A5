package br.edu.ifsp.lp3a5.aula03.produtorConsumidor1;

public class Main {

	public static void main(String[] args) {
		Buffer b = new Buffer();
		Produtor p1 = new Produtor(b, 1);
		Consumidor c1 = new Consumidor(b, 1);
		p1.start();
		c1.start();
	}

}

